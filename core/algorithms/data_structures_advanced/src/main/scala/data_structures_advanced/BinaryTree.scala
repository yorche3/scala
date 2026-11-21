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

  /** Inserta `value`; un duplicado también es éxito y no crece el tamaño.
    *
    * Esqueleto del paso 4b: devuelve el fallo sin resolver el caso.
    */
  def insert(value: Int): Boolean = false

  /** Éxito si `value` pertenece al árbol; sigue la invariante del ABB.
    *
    * Esqueleto del paso 4b: devuelve el fallo sin resolver el caso.
    */
  def contains(value: Int): Boolean = false

  /** `true` solo si no hay nodos. */
  def isEmpty: Boolean = _count == 0

  /** Número de valores distintos del árbol. */
  def size: Int = _count

object BinaryTree:
  /** Crea un árbol vacío utilizable (el `init()` de la especificación). */
  def apply(): BinaryTree = new BinaryTree()
