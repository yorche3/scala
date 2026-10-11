package data_structures_basics

import org.scalatest.funsuite.AnyFunSuite

class DataStructuresBasicsTests extends AnyFunSuite:
  private val firstNodeInput = 10
  private val secondNodeInput = 20
  private val firstNodeOutput = 10
  private val secondNodeOutput = 20
  private val absentNextOutput: Option[Node] = None

  private val listFirstTailInput = 10
  private val listSecondTailInput = 20
  private val listHeadInput = 5
  private val listRepeatedTailInput = 10
  private val listAbsentValueInput = 99
  private val emptyListSizeOutput = 0
  private val populatedListSizeOutput = 4
  private val firstDeleteSizeOutput = 3
  private val emptyListHeadOutput = -1

  private val stackFirstInput = 10
  private val stackSecondInput = 20
  private val stackThirdInput = 30
  private val stackReuseInput = 40
  private val emptyStackSizeOutput = 0
  private val populatedStackSizeOutput = 3
  private val emptyStackOutput = -1
  private val stackPeekOutput = 30
  private val stackFirstPopOutput = 30
  private val stackSecondPopOutput = 40
  private val stackThirdPopOutput = 20
  private val stackFourthPopOutput = 10

  private val queueFirstInput = 10
  private val queueSecondInput = 20
  private val queueThirdInput = 30
  private val queueReuseInput = 40
  private val emptyQueueSizeOutput = 0
  private val populatedQueueSizeOutput = 3
  private val emptyQueueOutput = -1
  private val queuePeekOutput = 10
  private val queueFirstDequeueOutput = 10
  private val queueSecondDequeueOutput = 20
  private val queueThirdDequeueOutput = 30
  private val queueFourthDequeueOutput = 40

  private def assertNodeCases(subject: String): Unit =
    val firstNode = Node(firstNodeInput)
    assert(
      firstNode.value == firstNodeOutput,
      s"$subject should preserve the first node value; expected $firstNodeOutput but got ${firstNode.value}"
    )
    assert(
      firstNode.next == absentNextOutput,
      s"$subject should leave the first node link absent after initialization"
    )

    val secondNode = Node(secondNodeInput)
    firstNode.next = Some(secondNode)
    assert(
      firstNode.next.map(_.value) == Some(secondNodeOutput),
      s"$subject should link the first node to the second node value $secondNodeOutput"
    )
    assert(
      secondNode.next == absentNextOutput,
      s"$subject should leave the second node link absent after initialization"
    )

  private def assertLinkedListCases(subject: String): Unit =
    val list = LinkedList()
    assert(list.isEmpty, s"$subject should report an initialized list as empty")
    assert(
      list.size == emptyListSizeOutput,
      s"$subject should report size $emptyListSizeOutput for an initialized list but got ${list.size}"
    )
    assert(
      list.head == emptyListHeadOutput,
      s"$subject should return $emptyListHeadOutput for the head of an empty list but got ${list.head}"
    )

    list.insertTail(listFirstTailInput)
    list.insertTail(listSecondTailInput)
    list.insertHead(listHeadInput)
    list.insertTail(listRepeatedTailInput)
    assert(
      list.size == populatedListSizeOutput,
      s"$subject should report size $populatedListSizeOutput after insertions but got ${list.size}"
    )
    assert(
      list.head == listHeadInput,
      s"$subject should expose head $listHeadInput after insertions but got ${list.head}"
    )

    assert(list.delete(listFirstTailInput), s"$subject should delete the first occurrence of $listFirstTailInput")
    assert(
      list.size == firstDeleteSizeOutput,
      s"$subject should report size $firstDeleteSizeOutput after deleting the first occurrence but got ${list.size}"
    )
    assert(
      list.head == listHeadInput,
      s"$subject should preserve head $listHeadInput after deleting the first occurrence"
    )

    assert(!list.delete(listAbsentValueInput), s"$subject should fail to delete absent value $listAbsentValueInput")
    assert(
      list.size == firstDeleteSizeOutput,
      s"$subject should preserve size $firstDeleteSizeOutput after failing to delete an absent value"
    )
    assert(
      list.head == listHeadInput,
      s"$subject should preserve head $listHeadInput after failing to delete an absent value"
    )

    assert(list.delete(listHeadInput), s"$subject should delete head value $listHeadInput")
    assert(list.delete(listSecondTailInput), s"$subject should delete value $listSecondTailInput")
    assert(list.delete(listRepeatedTailInput), s"$subject should delete remaining value $listRepeatedTailInput")
    assert(list.isEmpty, s"$subject should report the list as empty after all values are deleted")
    assert(
      list.size == emptyListSizeOutput,
      s"$subject should report size $emptyListSizeOutput after all values are deleted but got ${list.size}"
    )
    assert(
      list.head == emptyListHeadOutput,
      s"$subject should return $emptyListHeadOutput for the empty list head but got ${list.head}"
    )

  private def assertStackCases(subject: String): Unit =
    val stack = Stack()
    assert(stack.isEmpty, s"$subject should report an initialized stack as empty")
    assert(
      stack.size == emptyStackSizeOutput,
      s"$subject should report size $emptyStackSizeOutput for an initialized stack but got ${stack.size}"
    )
    assert(
      stack.peek == emptyStackOutput,
      s"$subject should return $emptyStackOutput when peeking an empty stack but got ${stack.peek}"
    )
    assert(
      stack.pop() == emptyStackOutput,
      s"$subject should return $emptyStackOutput when popping an empty stack"
    )

    stack.push(stackFirstInput)
    stack.push(stackSecondInput)
    stack.push(stackThirdInput)
    assert(
      stack.peek == stackPeekOutput,
      s"$subject should peek value $stackPeekOutput but got ${stack.peek}"
    )
    assert(
      stack.size == populatedStackSizeOutput,
      s"$subject should preserve size $populatedStackSizeOutput after peek but got ${stack.size}"
    )

    assert(stack.pop() == stackFirstPopOutput, s"$subject should first pop $stackFirstPopOutput")
    stack.push(stackReuseInput)
    assert(stack.pop() == stackSecondPopOutput, s"$subject should next pop reused value $stackSecondPopOutput")
    assert(stack.pop() == stackThirdPopOutput, s"$subject should next pop $stackThirdPopOutput")
    assert(stack.pop() == stackFourthPopOutput, s"$subject should last pop $stackFourthPopOutput")
    assert(stack.isEmpty, s"$subject should report the stack as empty after all values are popped")
    assert(
      stack.size == emptyStackSizeOutput,
      s"$subject should report size $emptyStackSizeOutput after all values are popped but got ${stack.size}"
    )
    assert(
      stack.pop() == emptyStackOutput,
      s"$subject should return $emptyStackOutput when popping after the stack is empty"
    )
    assert(stack.isEmpty, s"$subject should remain empty after a failed pop")

  private def assertQueueCases(subject: String): Unit =
    val queue = Queue()
    assert(queue.isEmpty, s"$subject should report an initialized queue as empty")
    assert(
      queue.size == emptyQueueSizeOutput,
      s"$subject should report size $emptyQueueSizeOutput for an initialized queue but got ${queue.size}"
    )
    assert(
      queue.peek == emptyQueueOutput,
      s"$subject should return $emptyQueueOutput when peeking an empty queue but got ${queue.peek}"
    )
    assert(
      queue.dequeue() == emptyQueueOutput,
      s"$subject should return $emptyQueueOutput when dequeuing an empty queue"
    )

    queue.enqueue(queueFirstInput)
    queue.enqueue(queueSecondInput)
    queue.enqueue(queueThirdInput)
    assert(
      queue.peek == queuePeekOutput,
      s"$subject should peek value $queuePeekOutput but got ${queue.peek}"
    )
    assert(
      queue.size == populatedQueueSizeOutput,
      s"$subject should preserve size $populatedQueueSizeOutput after peek but got ${queue.size}"
    )

    assert(queue.dequeue() == queueFirstDequeueOutput, s"$subject should first dequeue $queueFirstDequeueOutput")
    queue.enqueue(queueReuseInput)
    assert(queue.dequeue() == queueSecondDequeueOutput, s"$subject should next dequeue $queueSecondDequeueOutput")
    assert(queue.dequeue() == queueThirdDequeueOutput, s"$subject should next dequeue $queueThirdDequeueOutput")
    assert(queue.dequeue() == queueFourthDequeueOutput, s"$subject should last dequeue $queueFourthDequeueOutput")
    assert(queue.isEmpty, s"$subject should report the queue as empty after all values are dequeued")
    assert(
      queue.size == emptyQueueSizeOutput,
      s"$subject should report size $emptyQueueSizeOutput after all values are dequeued but got ${queue.size}"
    )
    assert(
      queue.dequeue() == emptyQueueOutput,
      s"$subject should return $emptyQueueOutput when dequeuing after the queue is empty"
    )
    assert(queue.isEmpty, s"$subject should remain empty after a failed dequeue")

  test("Node.value") {
    assertNodeCases("Node.value")
  }

  test("Node.next") {
    assertNodeCases("Node.next")
  }

  test("Node.next_=") {
    assertNodeCases("Node.next_=")
  }

  test("LinkedList.head") {
    assertLinkedListCases("LinkedList.head")
  }

  test("LinkedList.isEmpty") {
    assertLinkedListCases("LinkedList.isEmpty")
  }

  test("LinkedList.size") {
    assertLinkedListCases("LinkedList.size")
  }

  test("LinkedList.insertHead") {
    assertLinkedListCases("LinkedList.insertHead")
  }

  test("LinkedList.insertTail") {
    assertLinkedListCases("LinkedList.insertTail")
  }

  test("LinkedList.delete") {
    assertLinkedListCases("LinkedList.delete")
  }

  test("Stack.isEmpty") {
    assertStackCases("Stack.isEmpty")
  }

  test("Stack.size") {
    assertStackCases("Stack.size")
  }

  test("Stack.push") {
    assertStackCases("Stack.push")
  }

  test("Stack.pop") {
    assertStackCases("Stack.pop")
  }

  test("Stack.peek") {
    assertStackCases("Stack.peek")
  }

  test("Queue.isEmpty") {
    assertQueueCases("Queue.isEmpty")
  }

  test("Queue.size") {
    assertQueueCases("Queue.size")
  }

  test("Queue.enqueue") {
    assertQueueCases("Queue.enqueue")
  }

  test("Queue.dequeue") {
    assertQueueCases("Queue.dequeue")
  }

  test("Queue.peek") {
    assertQueueCases("Queue.peek")
  }
