package data_structures_basics

/** Stack: pila LIFO construida desde cero sobre [[Node]].
  *
  * Especificación: 06_Data_Structures_Basics
  *
  * Adecuaciones de salida de esta fase: las lecturas enteras que pueden fallar
  * devuelven el centinela **-1** (`pop`, `peek`), las booleanas devuelven
  * `true`/`false` (`isEmpty`) y `size` devuelve el número de nodos. Solo los
  * enlaces usan `Option`. No se lanza ninguna excepción.
  *
  * Implementación del paso 5: recorridos propios sobre la cadena de [[Node]].
  */
final class Stack private ():
  private var _top: Option[Node] = None
  private var _count: Int = 0

  /** `true` solo si no hay nodos. */
  def isEmpty: Boolean = _count == 0

  /** Número de nodos. */
  def size: Int = _count

  /** Apila `value`. O(1). */
  def push(value: Int): Unit =
    val newNode = Node(value)
    newNode.next = _top
    _top = Some(newNode)
    _count += 1

  /** Desapila; -1 cuando la pila está vacía. O(1). */
  def pop(): Int =
    if _top.isDefined then
      val topNode = _top.get
      _top = topNode.next
      _count -= 1
      topNode.value
    else
      -1

  /** Mira la cima sin desapilarla; -1 cuando la pila está vacía. */
  def peek: Int =
    if _top.isDefined then
      _top.get.value
    else
      -1

object Stack:
  /** Crea una pila vacía (el `init()` de la especificación): sin enlaces y con
    * el contador a cero.
    */
  def apply(): Stack = new Stack()
