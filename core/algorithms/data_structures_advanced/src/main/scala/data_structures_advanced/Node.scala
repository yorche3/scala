package data_structures_advanced

/** Node: base local del módulo.
  *
  * Especificación: 07_Data_Structures_Advanced
  *
  * Solo el valor: sin enlaces, sin validaciones y sin instancias propias. El
  * constructor es privado al paquete y el compañero no expone `apply`, así que
  * [[TreeNode]] y [[GraphNode]] son sus únicos usuarios, por herencia. El valor
  * ausente de los enlaces no vive aquí: cada hijo valida los suyos.
  */
class Node private[data_structures_advanced] (val value: Int)
