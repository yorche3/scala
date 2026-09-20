# Naive Sort — Scala

Implementación de la especificación [05_Naive_Sort](https://yorche3.github.io/programming_languages/core/algorithms/05_Naive_Sort/) en **Scala**, usando **sbt** como gestor del proyecto y **ScalaTest** como framework de pruebas unitarias.

Los tres algoritmos elementales de ordenamiento $O(n^2)$ — **selection sort**, **bubble sort** e **insertion sort** — ordenan *in-place* el `Array[Int]` recibido y devuelven la misma referencia, sin invocar `sorted`, `sortBy`, `sortWith` ni ninguna otra ayuda de ordenamiento de la biblioteca estándar.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo | Propósito |
|---------|-----------|
| [`build.sbt`](build.sbt) | Configuración del proyecto sbt y la dependencia `scalatest`. |
| [`project/build.properties`](project/build.properties) | Versión de sbt (`1.10.1`). |
| [`src/main/scala/NaiveSort.scala`](src/main/scala/NaiveSort.scala) | Objeto `NaiveSort` con las 3 funciones del contrato. |
| [`src/test/scala/NaiveSortTests.scala`](src/test/scala/NaiveSortTests.scala) | Suite `AnyFunSuite`: 3 tests (uno por algoritmo) con los 8 casos de la tabla. |
| [`.gitignore`](.gitignore) | Ignora artefactos de sbt y del editor (`target/`, `.bsp/`, `.scala-build/`, `.metals/`, `.idea/`). |

**Estructura de directorios esperada / Expected directory structure:**

```text
naive_sort/
├── build.sbt
├── project/
│   └── build.properties
├── src/
│   ├── main/
│   │   └── scala/
│   │       └── NaiveSort.scala        # Objeto NaiveSort: 3 algoritmos
│   └── test/
│       └── scala/
│           └── NaiveSortTests.scala   # Suite: 3 tests × 8 casos
├── .gitignore
└── README.md
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** Es el layout estándar de sbt que ya usa `core/foundations/numbers/`: `src/main/scala` para el objeto del módulo y `src/test/scala` para la suite, con `build.sbt` y `project/build.properties` como configuración. No hay código de ejemplo ni `main`.

**EN:** This is the standard sbt layout already used by `core/foundations/numbers/`: `src/main/scala` for the module object and `src/test/scala` for the suite, with `build.sbt` and `project/build.properties` as configuration. There is no example code or `main`.

### Inicialización / Initialization

```bash
mkdir -p scala/core/algorithms/naive_sort/{src/main/scala,src/test/scala,project}
cd scala/core/algorithms/naive_sort
# Escribir build.sbt (nombre y dependencia scalatest) y project/build.properties (sbt.version)
```

---

## 📄 Configuración clave / Key Configuration

### `build.sbt` — proyecto y dependencia de tests

```scala
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.9.0"

lazy val root = (project in file("."))
  .settings(
    name := "naive_sort",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
```

### `src/main/scala/NaiveSort.scala` — contrato e implementación

**ES:** Las tres funciones tienen la misma forma: reciben el `Array[Int]`, lo reordenan *in-place* y lo devuelven. `null` es representable en un array de la JVM, así que se devuelve como indicador de fallo; con menos de dos elementos el array vuelve sin cambios y ninguna función lanza excepciones.

**EN:** All three functions share the same shape: they take the `Array[Int]`, reorder it *in-place*, and return it. `null` is representable in a JVM array, so it is returned as the failure indicator; with fewer than two elements the array is returned unchanged and no function throws exceptions.

```scala
object NaiveSort {
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
```

| Elemento del contrato | Representación en Scala |
| --------------------- | ----------------------- |
| Array de enteros | `Array[Int]` (índices 0-based) |
| Caso nulo | `null` (indicador de fallo; representable en un array de la JVM) |
| Array vacío | `Array.empty[Int]` (`length == 0`) |
| Orden | in-place, devuelve la misma referencia |
| Nombres de la especificación | `selection_sort`, `bubble_sort`, `insertion_sort` (snake_case, idénticos a la especificación y al módulo `Numbers`) |

### Suite de pruebas / Test suite

**ES:** La suite extiende `AnyFunSuite`, agrupa los casos en una tabla de `SortCase` y usa un helper compartido que recibe el nombre del algoritmo y la función a probar. Cada caso ordena una copia (`clone`) del fixture, porque el orden es *in-place*; el caso nulo se comprueba aparte porque `sameElements` no admite `null`.

**EN:** The suite extends `AnyFunSuite`, groups the cases in a `SortCase` table, and uses a shared helper that receives the algorithm name and the function under test. Each case sorts a `clone` copy of the fixture, because sorting is *in-place*; the null case is checked separately because `sameElements` does not accept `null`.

```scala
  private def assertSortsAllCases(algorithm: String, sort: Array[Int] => Array[Int]): Unit =
    cases.foreach { testCase =>
      val message = s"$algorithm should sort ${testCase.description}"
      val input = if (testCase.input == null) null else testCase.input.clone()
      val actual = sort(input)

      if (testCase.expected == null) assert(actual == null, message)
      else assert(actual sameElements testCase.expected, message)
    }
```

---

## 🚀 Compilación y ejecución / Build & Run

### Requisitos / Requirements

- **JDK** (en este entorno, OpenJDK 25) y **sbt** (la versión del proyecto se fija en `project/build.properties`: `1.10.1`); Scala 3.9.0 lo descarga sbt.

```bash
java -version
sbt --version
```

### Compilar y ejecutar las pruebas / Build & run tests

```bash
cd scala/core/algorithms/naive_sort
sbt clean compile test
```

**Salida real / Actual output:**

```text
[info] compiling 1 Scala source to /home/yorche3/programming_languages/scala/core/algorithms/naive_sort/target/scala-3.9.0/classes ...
[info] done compiling
[success] Total time: 3 s, completed Sep 19, 2026, 7:08:16 PM
[info] compiling 1 Scala source to /home/yorche3/programming_languages/scala/core/algorithms/naive_sort/target/scala-3.9.0/test-classes ...
[info] done compiling
[info] NaiveSortTests:
[info] - selection_sort
[info] - bubble_sort
[info] - insertion_sort
[info] Run completed in 145 milliseconds.
[info] Total number of tests run: 3
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 3, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 1 s, completed Sep 19, 2026, 7:08:16 PM
```

> **ES:** La compilación no produce ningún warning (compuerta de verificación estática) y `sbt test` ejecuta 3 tests, uno por algoritmo, cada uno con los 8 casos de la tabla (24 aserciones).
> **EN:** Compilation produces no warnings (the static verification gate) and `sbt test` runs 3 tests, one per algorithm, each with the 8 cases of the table (24 assertions).

---

## 🧠 Algoritmos y operaciones / Algorithms & Operations

| Función / Algorithm | Enfoque / Approach | Descripción / Description |
| ------------------- | ------------------ | ------------------------- |
| `selection_sort(arr)` | iterativo, in-place | Busca el mínimo del tramo no ordenado con `min_index` y lo intercambia al inicio con `temp`. $O(n^2)$ siempre. |
| `bubble_sort(arr)` | iterativo, in-place, con bandera | Compara adyacentes e intercambia; la bandera `swapped` viaja en la condición del `while (i < n - 1 && swapped)`, que reproduce la salida temprana del pseudocódigo. $O(n^2)$ peor/promedio, $O(n)$ mejor. |
| `insertion_sort(arr)` | iterativo, in-place | Guarda `key`, desplaza el sub-array ordenado con `while (j > 0 && arr(j - 1) > key)` y lo inserta en su posición. $O(n^2)$ peor/promedio, $O(n)$ mejor. |

| Caso (descripción en la suite) | Entrada | Salida esperada |
| ------------------------------ | ------- | --------------- |
| an unsorted array | `[5, 2, 9, 1, 5, 6]` | `[1, 2, 5, 5, 6, 9]` |
| an already sorted array | `[1, 2, 3, 4, 5]` | `[1, 2, 3, 4, 5]` |
| a reverse ordered array | `[5, 4, 3, 2, 1]` | `[1, 2, 3, 4, 5]` |
| an array of identical elements | `[7, 7, 7, 7]` | `[7, 7, 7, 7]` |
| an array with negative numbers | `[3, -1, 4, -5, 0]` | `[-5, -1, 0, 3, 4]` |
| a single element array | `[42]` | `[42]` |
| an empty array | `[]` | `[]` |
| a null input | `null` | `null` |

---

## 📝 Notas de implementación / Implementation Notes

- **ES:** Divergencia idiomática aceptada: los tres algoritmos ordenan **in-place** el `Array[Int]` recibido y devuelven la misma referencia, variante que la especificación permite. Por eso la suite ordena una copia (`clone`) en cada caso, para no contaminar los fixtures compartidos.
- **EN:** Accepted idiomatic divergence: all three algorithms sort the received `Array[Int]` **in-place** and return the same reference, a variant the specification allows. That is why the suite sorts a `clone` copy per case, so the shared fixtures are not polluted.
- **ES:** Caso nulo incluido: un array de la JVM admite `null` y el contrato exige devolverlo como indicador de fallo, así que la suite lo comprueba como octavo caso (`assert(actual == null, …)`), separado de los casos con contenido porque `sameElements` no admite `null`. Ninguna función lanza excepciones.
- **EN:** Null case included: a JVM array admits `null` and the contract requires returning it as the failure indicator, so the suite checks it as the eighth case (`assert(actual == null, …)`), separate from the content cases because `sameElements` does not accept `null`. No function throws exceptions.
- **ES:** La salida temprana de `bubble_sort` usa `while (i < n - 1 && swapped)` con la bandera en la condición, no un `return` dentro del `for`: en Scala ese `return` sería un *non-local return* (el cuerpo de un `for` es una clausura) y el compilador lo marca con el warning «Non local returns are no longer supported; use `boundary` and `boundary.break` in `scala.util` instead». Con el `while` la compilación queda limpia y la bandera sigue siendo la del pseudocódigo (mejor caso $O(n)$).
- **EN:** The early exit of `bubble_sort` uses `while (i < n - 1 && swapped)` with the flag in the condition, not a `return` inside the `for`: in Scala such a `return` would be a *non-local return* (a `for` body is a closure) and the compiler flags it with the warning "Non local returns are no longer supported; use `boundary` and `boundary.break` in `scala.util` instead". With the `while`, compilation is clean and the flag is still the pseudocode's (best case $O(n)$).
- **ES:** Los bucles del pseudocódigo se traducen a rangos exclusivos: `0 until n - 1` y `i + 1 until n` en `selection_sort`, y `0 until n - i - 1` en el bucle interior de `bubble_sort` (el equivalente exacto de `for j = 0 to n - 2 - i` con índices 0-based).
- **EN:** The pseudocode loops translate to exclusive ranges: `0 until n - 1` and `i + 1 until n` in `selection_sort`, and `0 until n - i - 1` in the inner loop of `bubble_sort` (the exact equivalent of `for j = 0 to n - 2 - i` with 0-based indexes).
- **ES:** `insertion_sort` traduce el `while j >= 0 and arr[j] > key` del pseudocódigo a `while (j > 0 && arr(j - 1) > key)` sobre un índice desplazado, con `arr(j) = arr(j - 1)` y la inserción en `arr(j)`; así se evita el índice negativo, con el mismo comportamiento (la comparación estricta lo mantiene estable).
- **EN:** `insertion_sort` translates the pseudocode's `while j >= 0 and arr[j] > key` into `while (j > 0 && arr(j - 1) > key)` over a shifted index, with `arr(j) = arr(j - 1)` and the insertion at `arr(j)`; this avoids negative indexes, with the same behaviour (the strict comparison keeps it stable).
- **ES:** Los intercambios se hacen paso a paso con una variable `temp`; no se invoca `sorted`, `sortBy`, `sortWith`, `scala.util.Sorting` ni ninguna otra ayuda de ordenamiento de la biblioteca estándar.
- **EN:** Swaps are performed step by step with a `temp` variable; `sorted`, `sortBy`, `sortWith`, `scala.util.Sorting`, or any other standard-library sorting helper is never called.
- **ES:** Nota de desviación respecto a la ubicación esperada: se usa el layout estándar de sbt (`src/main/scala/NaiveSort.scala` y `src/test/scala/NaiveSortTests.scala`), el mismo de `core/foundations/numbers/`, y no se añade `run_tests.scala` porque `sbt test` descubre y ejecuta las suites de ScalaTest por sí solo. El objeto y las funciones llevan los nombres `snake_case` de la especificación, que Scala admite tal cual.
- **EN:** Deviation note from the expected location: the standard sbt layout is used (`src/main/scala/NaiveSort.scala` and `src/test/scala/NaiveSortTests.scala`), the same as `core/foundations/numbers/`, and no `run_tests.scala` is added because `sbt test` discovers and runs the ScalaTest suites on its own. The object and the functions keep the specification's `snake_case` names, which Scala accepts as-is.

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*[← Volver a Algoritmos Puros](../README.md)*

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
