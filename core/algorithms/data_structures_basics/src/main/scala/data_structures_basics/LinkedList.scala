package data_structures_basics

/** LinkedList: lista enlazada simple construida desde cero sobre [[Node]].
  *
  * Especificación: 06_Data_Structures_Basics
  *
  * Adecuaciones de salida de esta fase: las lecturas enteras que pueden fallar
  * devuelven el centinela **-1** (`head`), las booleanas devuelven `true`/
  * `false` (`delete`, `isEmpty`) y `size` devuelve el número de nodos. Solo los
  * enlaces usan `Option`. No se lanza ninguna excepción.
  *
  * Implementación del paso 5: recorridos propios sobre la cadena de [[Node]]
  * (Scala no necesita `unsafe` ni celdas compartidas mutables).
  */
final class LinkedList private ():
  private var _head: Option[Node] = None
  private var _tail: Option[Node] = None
  private var _count: Int = 0

  /** Valor de la cabeza, o -1 cuando la lista está vacía. */
  def head: Int = _head.map(_.value).getOrElse(-1)

  /** `true` solo si no hay nodos. */
  def isEmpty: Boolean = _count == 0

  /** Número de nodos. */
  def size: Int = _count

  /** Inserta `value` al principio. O(1). */
  def insertHead(value: Int): Unit =
    val newNode = Node(value)
    newNode.next = _head
    _head = Some(newNode)
    if (_tail.isEmpty) _tail = _head
    _count += 1

  /** Inserta `value` al final. O(1). */
  def insertTail(value: Int): Unit =
    val newNode = Node(value)
    if (_tail.isEmpty) {
      _head = Some(newNode)
      _tail = _head
    } else {
      _tail.get.next = Some(newNode)
      _tail = Some(newNode)
    }
    _count += 1

  /** Borra la primera aparición de `value`; `true` si borró y
    * `false` si el valor no estaba. O(n).
    */
  def delete(value: Int): Boolean =
    var current = _head
    var previous: Option[Node] = None
    while (current.isDefined) {
      if (current.get.value == value) {
        if (previous.isEmpty) {
          _head = current.get.next
          if (_head.isEmpty) _tail = None
        } else {
          previous.get.next = current.get.next
          if (current.get.next.isEmpty) _tail = previous
        }
        _count -= 1
        return true
      }
      previous = current
      current = current.get.next
    }
    false

object LinkedList:
  /** Crea una lista vacía (el `init()` de la especificación): sin enlaces y
    * con el contador a cero.
    */
  def apply(): LinkedList = new LinkedList()
