package data_structures_advanced

/** BinaryTree: ABB sin capacidad contractual.
  *
  * Especificación: 07_Data_Structures_Advanced
  *
  * Raíz propia y contador de valores distintos; los duplicados no crecen el
  * tamaño. El éxito de `insert` es booleano y no lanza excepciones: un
  * duplicado también es éxito.
  */
final class BinaryTree private ():
  private var _root: Option[TreeNode] = None
  private var _count: Int = 0

  private def insertNode(node: TreeNode, value: Int): Boolean =
    if value == node.value then false
    else if value < node.value then
      node.left match
        case Some(leftNode) => insertNode(leftNode, value)
        case None =>
          node.left = Some(TreeNode(value))
          true
    else
      node.right match
        case Some(rightNode) => insertNode(rightNode, value)
        case None =>
          node.right = Some(TreeNode(value))
          true

  /** Inserta `value`; un duplicado también es éxito y no crece el tamaño. */
  def insert(value: Int): Boolean =
    _root match
      case Some(rootNode) =>
        if insertNode(rootNode, value) then _count += 1
      case None =>
        _root = Some(TreeNode(value))
        _count += 1
    true

  /** Éxito si `value` pertenece al árbol; sigue la invariante del ABB. */
  def contains(value: Int): Boolean =
    def containsNode(node: TreeNode, value: Int): Boolean =
      if value == node.value then true
      else if value < node.value then
        node.left match
          case Some(leftNode) => containsNode(leftNode, value)
          case None => false
      else
        node.right match
          case Some(rightNode) => containsNode(rightNode, value)
          case None => false

    _root match
      case Some(rootNode) => containsNode(rootNode, value)
      case None => false

  /** `true` solo si no hay nodos. */
  def isEmpty: Boolean = _count == 0

  /** Número de valores distintos del árbol. */
  def size: Int = _count

object BinaryTree:
  /** Crea un árbol vacío utilizable (el `init()` de la especificación). */
  def apply(): BinaryTree = new BinaryTree()
