package data_structures_advanced

/** Graph: grafo dirigido sin aristas paralelas y con bucles permitidos.
  *
  * Especificación: 07_Data_Structures_Advanced
  *
  * Registro enlazado canónico de vértices escrito a mano —sin `HashMap`, `Set`
  * ni índices por etiqueta— y contadores separados de vértices y aristas.
  * `neighbors` devuelve `Some(Nil)` para un vértice aislado y `None` para un
  * vértice inexistente: el contrato obliga a distinguir los dos casos.
  */
final class Graph private ():
  private var _vertices: Option[GraphNode] = None
  private var _vertexCount: Int = 0
  private var _edgeCount: Int = 0

  /** Registra `label`; un duplicado también es éxito y conserva los vecinos.
    *
    * Esqueleto del paso 4b: devuelve el fallo sin resolver el caso.
    */
  def addVertex(label: Int): Boolean = false

  /** Añade la arista `u → v`; falla si falta un extremo y no muta.
    *
    * Esqueleto del paso 4b: devuelve el fallo sin resolver el caso.
    */
  def addEdge(u: Int, v: Int): Boolean = false

  /** Éxito si la arista `u → v` existe; falla si falta un extremo.
    *
    * Esqueleto del paso 4b: devuelve el fallo sin resolver el caso.
    */
  def hasEdge(u: Int, v: Int): Boolean = false

  /** Vecinos de `u` en orden creciente; `Some(Nil)` si está aislado y `None` si
    * el vértice no existe.
    *
    * Esqueleto del paso 4b: devuelve la ausencia sin resolver el caso.
    */
  def neighbors(u: Int): Option[List[Int]] = None

  /** `true` solo si no hay vértices. */
  def isEmpty: Boolean = _vertexCount == 0

  /** Número de vértices registrados. */
  def vertexCount: Int = _vertexCount

  /** Número de aristas registradas. */
  def edgeCount: Int = _edgeCount

object Graph:
  /** Crea un grafo vacío utilizable (el `init()` de la especificación). */
  def apply(): Graph = new Graph()
