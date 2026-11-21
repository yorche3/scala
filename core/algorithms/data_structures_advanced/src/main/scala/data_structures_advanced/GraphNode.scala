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
    label: Int,
    private var _nextVertex: Option[GraphNode]
) extends Node(label):
  private var _neighbors: List[Int] = List.empty

  /** Vecinos en orden creciente, sin duplicados. */
  def neighbors: List[Int] = _neighbors

  /** Siguiente vértice del registro canónico, o `None` al final. */
  def nextVertex: Option[GraphNode] = _nextVertex

  /** Reemplaza el enlace al siguiente vértice del registro.
    *
    * Esqueleto del paso 4b: la asignación llega en el paso 5.
    */
  def nextVertex_=(next: Option[GraphNode]): Unit = ()

private[data_structures_advanced] object GraphNode:
  /** Crea un vértice con `label`, sin vecinos y sin siguiente (el
    * `init(label)` interno de la especificación).
    */
  def apply(label: Int): GraphNode = new GraphNode(label, None)
