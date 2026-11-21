package data_structures_advanced

/** GraphNode: vértice del grafo. Interno a [[Graph]].
  *
  * Especificación: 07_Data_Structures_Advanced
  *
  * Etiqueta única, secuencia de vecinos sin duplicados y enlace al siguiente
  * vértice del registro canónico. Reutiliza el valor de [[Node]] por herencia.
  * Los vecinos son una lista inmutable: es la «secuencia ordenada» que admite
  * el contrato, y compartirla no permite modificar el grafo.
  */
private[data_structures_advanced] final class GraphNode private (
    val label: Int,
    private var _nextVertex: Option[GraphNode]
) extends Node(label):
  private var _neighbors: List[Int] = List.empty

  /** Vecinos en orden creciente, sin duplicados. */
  def neighbors: List[Int] = _neighbors

  /** Siguiente vértice del registro canónico, o `None` al final. */
  def nextVertex: Option[GraphNode] = _nextVertex

  /** Reemplaza el enlace al siguiente vértice del registro. */
  def nextVertex_=(next: Option[GraphNode]): Unit = _nextVertex = next

  /** Éxito si `v` ya figura en la adyacencia. */
  def hasNeighbor(v: Int): Boolean =
    GraphNode.containsValue(_neighbors, v)

  /** Inserta `v` en su posición creciente y devuelve `true`.
    *
    * Si `v` ya era vecino no se duplica y devuelve `false`, así que el grafo
    * no cuenta una arista nueva. La búsqueda y la inserción se recorren a mano
    * sobre la lista; no se usan `contains`, `sorted` ni `sortBy`.
    */
  def addNeighborIfAbsent(v: Int): Boolean =
    if GraphNode.containsValue(_neighbors, v) then false
    else
      _neighbors = GraphNode.insertSorted(_neighbors, v)
      true

private[data_structures_advanced] object GraphNode:
  /** Crea un vértice con `label`, sin vecinos y sin siguiente (el
    * `init(label)` interno de la especificación).
    */
  def apply(label: Int): GraphNode = new GraphNode(label, None)

  /** Recorrido lineal de la adyacencia en busca de `v`. */
  private def containsValue(remaining: List[Int], v: Int): Boolean =
    remaining match
      case Nil => false
      case head :: tail => head == v || containsValue(tail, v)

  /** Inserta `v` manteniendo el orden creciente y sin repetir valores. */
  private def insertSorted(remaining: List[Int], v: Int): List[Int] =
    remaining match
      case Nil => List(v)
      case head :: tail =>
        if v < head then v :: remaining
        else head :: insertSorted(tail, v)