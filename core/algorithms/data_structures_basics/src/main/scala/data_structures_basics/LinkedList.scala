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
  * Implementación pendiente: la escribe el autor. Esta delegación solo genera el
  * contrato (firmas y esqueletos) con las adecuaciones de salida.
  */
final class LinkedList private ():
  private var _head: Option[Node] = None
  private var _tail: Option[Node] = None
  private var _count: Int = 0

  /** Esqueleto: valor de la cabeza, o -1 cuando la lista está vacía. */
  def head: Int = -1

  /** Esqueleto: `true` solo si no hay nodos. */
  def isEmpty: Boolean = false

  /** Esqueleto: número de nodos. */
  def size: Int = 0

  /** Esqueleto: inserta `value` al principio. O(1). */
  def insertHead(value: Int): Unit = ()

  /** Esqueleto: inserta `value` al final. O(1). */
  def insertTail(value: Int): Unit = ()

  /** Esqueleto: borra la primera aparición de `value`; `true` si borró y
    * `false` si el valor no estaba. O(n).
    */
  def delete(value: Int): Boolean = false

object LinkedList:
  /** Crea una lista vacía (el `init()` de la especificación): sin enlaces y
    * con el contador a cero.
    */
  def apply(): LinkedList = new LinkedList()
