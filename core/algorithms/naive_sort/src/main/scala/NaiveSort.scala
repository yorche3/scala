// naive_sort — ordenamientos elementales O(n²).
//
// Especificación: 05_Naive_Sort
//
// Contrato: las tres funciones reciben un `Array[Int]` y devuelven el array
// ordenado de menor a mayor. El orden es in-place sobre el array recibido (se
// reordena y se devuelve la misma referencia), sin invocar `sorted`, `sortBy`,
// `sortWith` ni ninguna otra ayuda de ordenamiento de la biblioteca estándar.
// Firma: `def selection_sort(arr: Array[Int]): Array[Int]` (idéntica forma para
// `bubble_sort` e `insertion_sort`), en un `object NaiveSort` como en el módulo
// `Numbers` de `core/foundations/numbers/`.
// Si la entrada es `null` (representable en un array de la JVM) se devuelve
// `null` como indicador de fallo; si está vacía o tiene un solo elemento se
// devuelve sin cambios. No lanza excepciones.
//
// Implementación pendiente: la escribe el autor. Esta delegación solo genera el
// esqueleto y las pruebas unitarias.
object NaiveSort {
  def selection_sort(arr: Array[Int]): Array[Int] = {
    if (arr == null) return null
    val n = arr.length
    if (n < 2) return arr
    for (i <- 0 until n - 1) {
      var min_index = i
      for (j <- i + 1 until n) {
        if (arr(j) < arr(min_index)) {
          min_index = j
        }
      }
      if (min_index != i) {
        val temp = arr(i)
        arr(i) = arr(min_index)
        arr(min_index) = temp
      }
    }
    arr
  }

  def bubble_sort(arr: Array[Int]): Array[Int] = {
    if (arr == null) return null
    val n = arr.length
    if (n < 2) return arr
    var i = 0
    var swapped = true
    while (i < n - 1 && swapped) {
      swapped = false
      for (j <- 0 until n - i - 1) {
        if (arr(j) > arr(j + 1)) {
          val temp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = temp
          swapped = true
        }
      }
      i += 1
    }
    arr
  }

  def insertion_sort(arr: Array[Int]): Array[Int] = {
    if (arr == null) return null
    val n = arr.length
    if (n < 2) return arr
    for (i <- 1 until n) {
      val key = arr(i)
      var j = i
      while (j > 0 && arr(j - 1) > key) {
        arr(j) = arr(j - 1)
        j -= 1
      }
      arr(j) = key
    }
    arr
  }
}