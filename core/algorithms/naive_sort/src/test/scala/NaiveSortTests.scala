import org.scalatest.funsuite.AnyFunSuite

/**
 * Pruebas unitarias de la especificación 05_Naive_Sort.
 *
 * Caso nulo incluido: un `Array[Int]` de la JVM admite `null` y el contrato
 * exige devolverlo como indicador de fallo, sin lanzar excepciones.
 *
 * Aislamiento: los arrays de la JVM son mutables y los tres algoritmos ordenan
 * in-place, así que cada caso ordena una copia (`clone`) del fixture compartido.
 */
class NaiveSortTests extends AnyFunSuite {

  // Casos de prueba de la especificación 05_Naive_Sort.md
  private val standardInput = Array(5, 2, 9, 1, 5, 6)
  private val standardOutput = Array(1, 2, 5, 5, 6, 9)

  private val sortedInput = Array(1, 2, 3, 4, 5)
  private val sortedOutput = Array(1, 2, 3, 4, 5)

  private val reverseInput = Array(5, 4, 3, 2, 1)
  private val reverseOutput = Array(1, 2, 3, 4, 5)

  private val identicalInput = Array(7, 7, 7, 7)
  private val identicalOutput = Array(7, 7, 7, 7)

  private val negativeInput = Array(3, -1, 4, -5, 0)
  private val negativeOutput = Array(-5, -1, 0, 3, 4)

  private val singleInput = Array(42)
  private val singleOutput = Array(42)

  private val emptyInput = Array.empty[Int]
  private val emptyOutput = Array.empty[Int]

  private val nullInput: Array[Int] = null
  private val nullOutput: Array[Int] = null

  /** Tabla de casos: descripción, entrada y salida esperada. */
  private case class SortCase(description: String, input: Array[Int], expected: Array[Int])

  private val cases = Seq(
    SortCase("an unsorted array", standardInput, standardOutput),
    SortCase("an already sorted array", sortedInput, sortedOutput),
    SortCase("a reverse ordered array", reverseInput, reverseOutput),
    SortCase("an array of identical elements", identicalInput, identicalOutput),
    SortCase("an array with negative numbers", negativeInput, negativeOutput),
    SortCase("a single element array", singleInput, singleOutput),
    SortCase("an empty array", emptyInput, emptyOutput),
    SortCase("a null input", nullInput, nullOutput)
  )

  /**
   * Helper compartido: recibe el nombre del algoritmo y la función a probar, y
   * ejecuta todos los casos con el mensaje descriptivo del contrato.
   */
  private def assertSortsAllCases(algorithm: String, sort: Array[Int] => Array[Int]): Unit =
    cases.foreach { testCase =>
      val message = s"$algorithm should sort ${testCase.description}"
      val input = if (testCase.input == null) null else testCase.input.clone()
      val actual = sort(input)

      if (testCase.expected == null) assert(actual == null, message)
      else assert(actual sameElements testCase.expected, message)
    }

  test("selection_sort") {
    assertSortsAllCases("selection_sort", NaiveSort.selection_sort)
  }

  test("bubble_sort") {
    assertSortsAllCases("bubble_sort", NaiveSort.bubble_sort)
  }

  test("insertion_sort") {
    assertSortsAllCases("insertion_sort", NaiveSort.insertion_sort)
  }
}
