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
  * Implementación pendiente: la escribe el autor. Esta delegación solo genera el
  * contrato (firmas y esqueletos) con las adecuaciones de salida.
  */
final class Stack private ():
  private var _top: Option[Node] = None
  private var _count: Int = 0

  /** Esqueleto: `true` solo si no hay nodos. */
  def isEmpty: Boolean = false

  /** Esqueleto: número de nodos. */
  def size: Int = 0

  /** Esqueleto: apila `value`. O(1). */
  def push(value: Int): Unit = ()

  /** Esqueleto: desapila; -1 cuando la pila está vacía. O(1). */
  def pop(): Int = -1

  /** Esqueleto: mira la cima sin desapilarla; -1 cuando la pila está vacía. */
  def peek: Int = -1

object Stack:
  /** Crea una pila vacía (el `init()` de la especificación): sin enlaces y con
    * el contador a cero.
    */
  def apply(): Stack = new Stack()
