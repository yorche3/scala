package data_structures_advanced

import org.scalatest.funsuite.AnyFunSuite

class DataStructuresAdvancedTests extends AnyFunSuite:
  private val parentValueInput = 10
  private val leftChildValueInput = 20
  private val rightChildValueInput = 30
  private val parentValueOutput = 10
  private val leftChildValueOutput = 20
  private val rightChildValueOutput = 30
  private val absentLinkOutput: Option[TreeNode] = None

  private val treeRootInput = 50
  private val treeLowerInput = 30
  private val treeHigherInput = 70
  private val treeLowerLeafInput = 20
  private val treeMiddleLeafInput = 40
  private val treeMissingInput = 99
  private val emptyTreeSizeOutput = 0
  private val rootOnlyTreeSizeOutput = 1
  private val threeValueTreeSizeOutput = 3
  private val fiveValueTreeSizeOutput = 5

  private val firstLabelInput = 10
  private val secondLabelInput = 30
  private val thirdLabelInput = 50
  private val fourthLabelInput = 70
  private val missingLabelInput = 99
  private val otherMissingLabelInput = 98
  private val emptyGraphCountOutput = 0
  private val oneVertexCountOutput = 1
  private val twoVertexCountOutput = 2
  private val threeVertexCountOutput = 3
  private val fourVertexCountOutput = 4
  private val oneEdgeCountOutput = 1
  private val twoEdgeCountOutput = 2
  private val fourEdgeCountOutput = 4
  private val isolatedNeighborsOutput: Option[List[Int]] = Some(Nil)
  private val missingVertexOutput: Option[List[Int]] = None
  private val secondOnlyNeighborsOutput: Option[List[Int]] = Some(List(30))
  private val sortedNeighborsOfFirstOutput: Option[List[Int]] = Some(List(30, 50, 70))
  private val thirdOnlyNeighborsOutput: Option[List[Int]] = Some(List(50))
  private val firstAndSecondNeighborsOutput: Option[List[Int]] = Some(List(30, 50))
  private val selfLoopNeighborsOutput: Option[List[Int]] = Some(List(10))

  private def assertTreeContents(
      subject: String,
      tree: BinaryTree,
      present: List[Int],
      absent: List[Int],
      sizeOutput: Int
  ): Unit =
    assert(
      tree.size == sizeOutput,
      s"$subject should report size $sizeOutput but got ${tree.size}"
    )
    present.foreach: value =>
      assert(tree.contains(value), s"$subject should contain $value")
    absent.foreach: value =>
      assert(!tree.contains(value), s"$subject should not contain $value")

  private def assertInserts(subject: String, tree: BinaryTree, values: List[Int]): Unit =
    values.foreach: value =>
      assert(tree.insert(value), s"$subject should succeed when inserting $value")

  private def assertGraphCounts(
      subject: String,
      graph: Graph,
      vertexOutput: Int,
      edgeOutput: Int
  ): Unit =
    assert(
      graph.vertexCount == vertexOutput,
      s"$subject should report $vertexOutput vertices but got ${graph.vertexCount}"
    )
    assert(
      graph.edgeCount == edgeOutput,
      s"$subject should report $edgeOutput edges but got ${graph.edgeCount}"
    )

  private def assertNeighbors(
      subject: String,
      graph: Graph,
      label: Int,
      output: Option[List[Int]]
  ): Unit =
    assert(
      graph.neighbors(label) == output,
      s"$subject should return $output as the neighbors of $label but got ${graph.neighbors(label)}"
    )

  private def assertAddVertices(subject: String, graph: Graph, labels: List[Int]): Unit =
    labels.foreach: label =>
      assert(graph.addVertex(label), s"$subject should succeed when adding vertex $label")

  private def buildLinkedParent(): TreeNode =
    val parent = TreeNode(parentValueInput)
    parent.left = Some(TreeNode(leftChildValueInput))
    parent.right = Some(TreeNode(rightChildValueInput))
    parent

  // TreeNode
  test("TreeNode: create a tree node"):
    val node = TreeNode(parentValueInput)
    assert(
      node.value == parentValueOutput,
      s"TreeNode should preserve value $parentValueOutput but got ${node.value}"
    )

  test("TreeNode: absent initial links"):
    val node = TreeNode(parentValueInput)
    assert(node.left == absentLinkOutput, "TreeNode should start with an absent left link")
    assert(node.right == absentLinkOutput, "TreeNode should start with an absent right link")

  test("TreeNode: link two children"):
    val parent = buildLinkedParent()
    assert(
      parent.left.map(_.value) == Some(leftChildValueOutput),
      s"TreeNode should link the left child with value $leftChildValueOutput"
    )
    assert(
      parent.right.map(_.value) == Some(rightChildValueOutput),
      s"TreeNode should link the right child with value $rightChildValueOutput"
    )

  test("TreeNode: traverse each link"):
    val parent = buildLinkedParent()
    val left = parent.left
    val right = parent.right
    assert(
      left.map(_.value) == Some(leftChildValueOutput),
      s"TreeNode should reach the left child value $leftChildValueOutput"
    )
    assert(
      right.map(_.value) == Some(rightChildValueOutput),
      s"TreeNode should reach the right child value $rightChildValueOutput"
    )
    assert(
      left.flatMap(_.left) == absentLinkOutput && left.flatMap(_.right) == absentLinkOutput,
      "TreeNode should leave the left child links absent"
    )
    assert(
      right.flatMap(_.left) == absentLinkOutput && right.flatMap(_.right) == absentLinkOutput,
      "TreeNode should leave the right child links absent"
    )

  test("TreeNode: unlink children"):
    val parent = buildLinkedParent()
    parent.left = None
    assert(parent.left == absentLinkOutput, "TreeNode should clear the left link")
    assert(
      parent.value == parentValueOutput,
      "TreeNode should preserve its value after clearing the left link"
    )
    assert(
      parent.right.map(_.value) == Some(rightChildValueOutput),
      "TreeNode should preserve the right child after clearing the left link"
    )
    parent.right = None
    assert(parent.left == absentLinkOutput, "TreeNode should keep the left link absent after clearing the right link")
    assert(parent.right == absentLinkOutput, "TreeNode should clear the right link")
    assert(
      parent.value == parentValueOutput,
      "TreeNode should preserve its value after clearing both links"
    )

  // BinaryTree
  test("BinaryTree: create empty"):
    val tree = BinaryTree()
    assert(tree.isEmpty, "BinaryTree should report an initialized tree as empty")
    assert(
      tree.size == emptyTreeSizeOutput,
      s"BinaryTree should report size $emptyTreeSizeOutput when empty but got ${tree.size}"
    )
    assert(!tree.contains(treeRootInput), "BinaryTree should not contain 50 when empty")

  test("BinaryTree: insert the root"):
    val tree = BinaryTree()
    assertInserts("BinaryTree root", tree, List(treeRootInput))
    assert(!tree.isEmpty, "BinaryTree should not be empty after inserting the root")
    assertTreeContents("BinaryTree root", tree, List(treeRootInput), Nil, rootOnlyTreeSizeOutput)

  test("BinaryTree: insert lower and higher"):
    val tree = BinaryTree()
    assertInserts("BinaryTree lower and higher", tree, List(treeRootInput, treeLowerInput, treeHigherInput))
    assertTreeContents(
      "BinaryTree lower and higher",
      tree,
      List(treeRootInput, treeLowerInput, treeHigherInput),
      Nil,
      threeValueTreeSizeOutput
    )

  test("BinaryTree: multilevel branches"):
    val tree = BinaryTree()
    val values = List(treeRootInput, treeLowerInput, treeHigherInput, treeLowerLeafInput, treeMiddleLeafInput)
    assertInserts("BinaryTree multilevel", tree, values)
    assertTreeContents("BinaryTree multilevel", tree, values, Nil, fiveValueTreeSizeOutput)

  test("BinaryTree: missing value in nonempty tree"):
    val tree = BinaryTree()
    assertInserts("BinaryTree missing value", tree, List(treeRootInput))
    assertTreeContents("BinaryTree missing value", tree, List(treeRootInput), List(treeMissingInput), rootOnlyTreeSizeOutput)

  test("BinaryTree: idempotent duplicate"):
    val tree = BinaryTree()
    assertInserts(
      "BinaryTree duplicate",
      tree,
      List(treeRootInput, treeLowerInput, treeHigherInput, treeLowerInput)
    )
    assertTreeContents(
      "BinaryTree duplicate",
      tree,
      List(treeRootInput, treeLowerInput, treeHigherInput),
      Nil,
      threeValueTreeSizeOutput
    )

  test("BinaryTree: ordered insertions"):
    val tree = BinaryTree()
    val values = List(treeLowerLeafInput, treeLowerInput, treeMiddleLeafInput, treeRootInput, treeHigherInput)
    assertInserts("BinaryTree ordered", tree, values)
    assertTreeContents("BinaryTree ordered", tree, values, List(treeMissingInput), fiveValueTreeSizeOutput)

  // Graph
  test("Graph: create empty"):
    val graph = Graph()
    assert(graph.isEmpty, "Graph should report an initialized graph as empty")
    assertGraphCounts("Graph empty", graph, emptyGraphCountOutput, emptyGraphCountOutput)
    assert(!graph.hasEdge(firstLabelInput, secondLabelInput), "Graph should fail has_edge(10, 30) when empty")
    assertNeighbors("Graph empty", graph, firstLabelInput, missingVertexOutput)

  test("Graph: isolated vertex"):
    val graph = Graph()
    assert(graph.addVertex(firstLabelInput), "Graph should succeed when adding vertex 10")
    assert(!graph.isEmpty, "Graph should not be empty after adding a vertex")
    assertGraphCounts("Graph isolated vertex", graph, oneVertexCountOutput, emptyGraphCountOutput)
    assertNeighbors("Graph isolated vertex", graph, firstLabelInput, isolatedNeighborsOutput)

  test("Graph: nonconsecutive labels and directed edge"):
    val graph = Graph()
    assertAddVertices("Graph directed edge", graph, List(firstLabelInput, fourthLabelInput))
    assert(graph.addEdge(firstLabelInput, fourthLabelInput), "Graph should succeed when adding edge 10 -> 70")
    assert(graph.hasEdge(firstLabelInput, fourthLabelInput), "Graph should contain the forward edge 10 -> 70")
    assert(!graph.hasEdge(fourthLabelInput, firstLabelInput), "Graph should not contain the reverse edge 70 -> 10")
    assertGraphCounts("Graph directed edge", graph, twoVertexCountOutput, oneEdgeCountOutput)

  test("Graph: duplicate vertex preserves adjacency"):
    val graph = Graph()
    assertAddVertices("Graph duplicate vertex", graph, List(firstLabelInput, secondLabelInput))
    assert(graph.addEdge(firstLabelInput, secondLabelInput), "Graph should succeed when adding edge 10 -> 30")
    assert(graph.addVertex(firstLabelInput), "Graph should succeed when re-adding vertex 10")
    assertGraphCounts("Graph duplicate vertex", graph, twoVertexCountOutput, oneEdgeCountOutput)
    assertNeighbors("Graph duplicate vertex", graph, firstLabelInput, secondOnlyNeighborsOutput)

  test("Graph: duplicate edge"):
    val graph = Graph()
    assertAddVertices("Graph duplicate edge", graph, List(firstLabelInput, secondLabelInput))
    assert(graph.addEdge(firstLabelInput, secondLabelInput), "Graph should succeed when adding edge 10 -> 30 the first time")
    assert(graph.addEdge(firstLabelInput, secondLabelInput), "Graph should succeed when adding edge 10 -> 30 the second time")
    assertGraphCounts("Graph duplicate edge", graph, twoVertexCountOutput, oneEdgeCountOutput)
    assertNeighbors("Graph duplicate edge", graph, firstLabelInput, secondOnlyNeighborsOutput)

  test("Graph: missing endpoint without mutation"):
    val graph = Graph()
    assertAddVertices("Graph missing endpoint", graph, List(firstLabelInput, secondLabelInput))
    assert(graph.addEdge(firstLabelInput, secondLabelInput), "Graph should succeed when adding edge 10 -> 30")
    assert(!graph.addEdge(firstLabelInput, missingLabelInput), "Graph should fail when the target 99 is missing")
    assert(!graph.addEdge(missingLabelInput, firstLabelInput), "Graph should fail when the source 99 is missing")
    assert(!graph.addEdge(otherMissingLabelInput, missingLabelInput), "Graph should fail when both endpoints are missing")
    assert(!graph.addEdge(missingLabelInput, missingLabelInput), "Graph should fail for a self-loop on missing vertex 99")
    assertGraphCounts("Graph missing endpoint", graph, twoVertexCountOutput, oneEdgeCountOutput)
    assertNeighbors("Graph missing endpoint", graph, firstLabelInput, secondOnlyNeighborsOutput)
    assertNeighbors("Graph missing endpoint", graph, secondLabelInput, isolatedNeighborsOutput)
    assert(!graph.hasEdge(firstLabelInput, missingLabelInput), "Graph should not report edge 10 -> 99")
    assert(!graph.hasEdge(missingLabelInput, firstLabelInput), "Graph should not report edge 99 -> 10")
    assert(!graph.hasEdge(otherMissingLabelInput, missingLabelInput), "Graph should not report edge 98 -> 99")
    assert(!graph.hasEdge(missingLabelInput, missingLabelInput), "Graph should not report edge 99 -> 99")
    assertNeighbors("Graph missing endpoint", graph, otherMissingLabelInput, missingVertexOutput)
    assertNeighbors("Graph missing endpoint", graph, missingLabelInput, missingVertexOutput)

  test("Graph: sorted neighbors and counts"):
    val graph = Graph()
    assertAddVertices(
      "Graph sorted neighbors",
      graph,
      List(firstLabelInput, secondLabelInput, thirdLabelInput, fourthLabelInput)
    )
    List(
      (firstLabelInput, fourthLabelInput),
      (firstLabelInput, secondLabelInput),
      (firstLabelInput, thirdLabelInput),
      (secondLabelInput, thirdLabelInput)
    ).foreach: (u, v) =>
      assert(graph.addEdge(u, v), s"Graph should succeed when adding edge $u -> $v")
    assertNeighbors("Graph sorted neighbors", graph, firstLabelInput, sortedNeighborsOfFirstOutput)
    assertNeighbors("Graph sorted neighbors", graph, secondLabelInput, thirdOnlyNeighborsOutput)
    assertNeighbors("Graph sorted neighbors", graph, thirdLabelInput, isolatedNeighborsOutput)
    assertNeighbors("Graph sorted neighbors", graph, fourthLabelInput, isolatedNeighborsOutput)
    assertGraphCounts("Graph sorted neighbors", graph, fourVertexCountOutput, fourEdgeCountOutput)

  test("Graph: missing-edge query"):
    val graph = Graph()
    assertAddVertices("Graph missing-edge query", graph, List(firstLabelInput, secondLabelInput))
    assert(!graph.hasEdge(firstLabelInput, secondLabelInput), "Graph should fail has_edge(10, 30) when no edge was added")
    assertGraphCounts("Graph missing-edge query", graph, twoVertexCountOutput, emptyGraphCountOutput)
    assert(!graph.isEmpty, "Graph should not be empty with two vertices")

  test("Graph: neighbors of missing vertex"):
    val graph = Graph()
    assert(graph.addVertex(firstLabelInput), "Graph should succeed when adding vertex 10")
    assertNeighbors("Graph missing vertex", graph, missingLabelInput, missingVertexOutput)
    assert(
      graph.neighbors(missingLabelInput) != graph.neighbors(firstLabelInput),
      "Graph should distinguish a missing vertex from empty neighbors"
    )
    assertGraphCounts("Graph missing vertex", graph, oneVertexCountOutput, emptyGraphCountOutput)

  test("Graph: self-loop and duplicate"):
    val graph = Graph()
    assert(graph.addVertex(firstLabelInput), "Graph should succeed when adding vertex 10")
    assert(graph.addEdge(firstLabelInput, firstLabelInput), "Graph should succeed when adding loop 10 -> 10 the first time")
    assert(graph.addEdge(firstLabelInput, firstLabelInput), "Graph should succeed when adding loop 10 -> 10 the second time")
    assert(graph.hasEdge(firstLabelInput, firstLabelInput), "Graph should contain the loop 10 -> 10")
    assertNeighbors("Graph self-loop", graph, firstLabelInput, selfLoopNeighborsOutput)
    assertGraphCounts("Graph self-loop", graph, oneVertexCountOutput, oneEdgeCountOutput)

  // Scala's List is immutable: the "modify a returned copy" step is not representable.
  test("Graph: neighbor-result isolation"):
    val graph = Graph()
    assertAddVertices(
      "Graph neighbor isolation",
      graph,
      List(firstLabelInput, secondLabelInput, thirdLabelInput)
    )
    assert(graph.addEdge(firstLabelInput, secondLabelInput), "Graph should succeed when adding edge 10 -> 30")
    val saved = graph.neighbors(firstLabelInput)
    assert(graph.addEdge(firstLabelInput, thirdLabelInput), "Graph should succeed when adding edge 10 -> 50")
    assert(
      saved == secondOnlyNeighborsOutput,
      s"Graph should keep the saved neighbors of 10 as $secondOnlyNeighborsOutput but got $saved"
    )
    assertNeighbors("Graph neighbor isolation", graph, firstLabelInput, firstAndSecondNeighborsOutput)
    assertGraphCounts("Graph neighbor isolation", graph, threeVertexCountOutput, twoEdgeCountOutput)
