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
  * Implementación pendiente: la escribe el autor. Esta delegación solo genera el
  * contrato (firmas y esqueletos) con las adecuaciones de salida.
  */
final class Queue private ():
  private var _front: Option[Node] = None
  private var _rear: Option[Node] = None
  private var _count: Int = 0

  /** Esqueleto: `true` solo si no hay nodos. */
  def isEmpty: Boolean = false

  /** Esqueleto: número de nodos. */
  def size: Int = 0

  /** Esqueleto: encola `value` al final. O(1). */
  def enqueue(value: Int): Unit = ()

  /** Esqueleto: desencola; -1 cuando la cola está vacía. O(1). */
  def dequeue(): Int = -1

  /** Esqueleto: mira el frente sin desencolarlo; -1 cuando la cola está vacía. */
  def peek: Int = -1

object Queue:
  /** Crea una cola vacía (el `init()` de la especificación): sin enlaces y con
    * el contador a cero.
    */
  def apply(): Queue = new Queue()
