package data_structures_basics

/** Queue: cola FIFO construida desde cero sobre [[Node]].
  *
  * Especificación: 06_Data_Structures_Basics
  *
  * Adecuaciones de salida de esta fase: las lecturas enteras que pueden fallar
  * devuelven el centinela **-1** (`dequeue`, `peek`), las booleanas devuelven
  * `true`/`false` (`isEmpty`) y `size` devuelve el número de nodos. Solo los
  * enlaces usan `Option`. No se lanza ninguna excepción.
  *
  * Implementación del paso 5: recorridos propios sobre la cadena de [[Node]]
  * (con `_rear` para que el encolado sea O(1)).
  */
final class Queue private ():
  private var _front: Option[Node] = None
  private var _rear: Option[Node] = None
  private var _count: Int = 0

  /** `true` solo si no hay nodos. */
  def isEmpty: Boolean = _count == 0

  /** Número de nodos. */
  def size: Int = _count

  /** Encola `value` al final. O(1). */
  def enqueue(value: Int): Unit =
    val newNode = Node(value)
    if (_rear.isEmpty) {
      _front = Some(newNode)
      _rear = _front
    } else {
      _rear.get.next = Some(newNode)
      _rear = Some(newNode)
    }
    _count += 1

  /** Desencola; -1 cuando la cola está vacía. O(1). */
  def dequeue(): Int =
    if _front.isDefined then
      val frontNode = _front.get
      _front = frontNode.next
      if (_front.isEmpty) _rear = None
      _count -= 1
      frontNode.value
    else
      -1

  /** Mira el frente sin desencolarlo; -1 cuando la cola está vacía. */
  def peek: Int =
    if _front.isDefined then
      _front.get.value
    else
      -1

object Queue:
  /** Crea una cola vacía (el `init()` de la especificación): sin enlaces y con
    * el contador a cero.
    */
  def apply(): Queue = new Queue()
