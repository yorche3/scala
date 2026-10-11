package data_structures_basics

/** Node: celda enlazada compartida por [[LinkedList]], [[Stack]] y [[Queue]].
  *
  * Especificación: 06_Data_Structures_Basics
  *
  * Adecuación: `value` no se reasigna después de la construcción; el enlace sí.
  * El enlace ausente es `None` (único uso de `Option` del contrato).
  */
final class Node private (
    val value: Int,
    private var _next: Option[Node]
):
  /** Esqueleto: enlace siguiente, o `None` cuando está ausente. */
  def next: Option[Node] = None

  /** Esqueleto: reemplaza el enlace siguiente. */
  def next_=(n: Option[Node]): Unit = ()

object Node:
  /** Crea una celda con `value` y sin enlace (el `init(value)` de la
    * especificación).
    */
  def apply(value: Int): Node = new Node(value, None)
