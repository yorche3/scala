package data_structures_advanced

/** TreeNode: nodo propio del ABB.
  *
  * Especificación: 07_Data_Structures_Advanced
  *
  * Reutiliza el valor de [[Node]] por herencia y añade los dos enlaces, que
  * valida este nodo. Un enlace ausente es `None`, la representación que la
  * tabla `canonical_names.tsv` fija para Scala (`absent = None`,
  * `present = Some(x)`) y que la Fase 1 admite como indicador.
  */
final class TreeNode(v: Int) extends Node(v):
  private var _left: Option[TreeNode] = None
  private var _right: Option[TreeNode] = None

  /** Enlace izquierdo, o `None` cuando está ausente. */
  def left: Option[TreeNode] = _left

  /** Enlace derecho, o `None` cuando está ausente. */
  def right: Option[TreeNode] = _right

  /** Reemplaza el enlace izquierdo con `node`, o lo deja ausente con `None`. */
  def left_=(node: Option[TreeNode]): Unit = _left = node

  /** Reemplaza el enlace derecho con `node`, o lo deja ausente con `None`. */
  def right_=(node: Option[TreeNode]): Unit = _right = node

object TreeNode:
  /** Crea un nodo con `value` y ambos enlaces ausentes (el `init(value)` de la
    * especificación).
    */
  def apply(value: Int): TreeNode = new TreeNode(value)
