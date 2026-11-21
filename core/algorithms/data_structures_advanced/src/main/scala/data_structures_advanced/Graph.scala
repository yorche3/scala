package data_structures_advanced

/** Graph: grafo dirigido sin aristas paralelas y con bucles permitidos.
  *
  * Especificación: 07_Data_Structures_Advanced
  *
  * Registro enlazado canónico de vértices escrito a mano —sin `HashMap`, `Set`
  * ni índices por etiqueta— y contadores separados de vértices y aristas.
  * `neighbors` devuelve `Some(Nil)` para un vértice aislado y `None` para un
  * vértice inexistente: el contrato obliga a distinguir los dos casos.
  */
final class Graph private ():
  private var _vertices: Option[GraphNode] = None
  private var _vertexCount: Int = 0
  private var _edgeCount: Int = 0

  private def findVertex(label: Int): Option[GraphNode] =
    def loop(node: Option[GraphNode]): Option[GraphNode] =
      node match
        case None => None
        case Some(n) =>
          if n.label == label then Some(n)
          else loop(n.nextVertex)

    loop(_vertices)

  /** Registra `label`; un duplicado también es éxito y conserva los vecinos. */
  def addVertex(label: Int): Boolean =
    if findVertex(label).isDefined then true
    else
      val newNode = GraphNode(label)
      newNode.nextVertex = _vertices
      _vertices = Some(newNode)
      _vertexCount += 1
      true

  /** Añade la arista `u → v`; falla si falta un extremo y no muta.
    *
    * Una arista repetida o un bucle repetido también son éxito, pero no suman
    * al contador: solo cuenta la arista nueva.
    */
  def addEdge(u: Int, v: Int): Boolean =
    (findVertex(u), findVertex(v)) match
      case (Some(uNode), Some(_)) =>
        if uNode.addNeighborIfAbsent(v) then _edgeCount += 1
        true
      case _ => false

  /** Éxito si la arista `u → v` existe; falla si falta un extremo. */
  def hasEdge(u: Int, v: Int): Boolean =
    findVertex(u) match
      case Some(uNode) => uNode.hasNeighbor(v)
      case None => false

  /** Vecinos de `u` en orden creciente; `Some(Nil)` si está aislado y `None` si
    * el vértice no existe.
    */
  def neighbors(u: Int): Option[List[Int]] =
    findVertex(u).map(_.neighbors)

  /** `true` solo si no hay vértices. */
  def isEmpty: Boolean = _vertexCount == 0

  /** Número de vértices registrados. */
  def vertexCount: Int = _vertexCount

  /** Número de aristas registradas. */
  def edgeCount: Int = _edgeCount

object Graph:
  /** Crea un grafo vacío utilizable (el `init()` de la especificación). */
  def apply(): Graph = new Graph()
