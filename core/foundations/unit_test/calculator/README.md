# Calculator — Scala

Implementación de la especificación [03_Unit_Test_Calculator](https://yorche3.github.io/programming_languages/core/foundations/03_Unit_Test_Calculator/) en **Scala**, usando **sbt** como gestor del proyecto y **ScalaTest** como framework de pruebas unitarias.

El proyecto sigue una estructura tipo librería con separación entre código fuente y pruebas, y cada operación se implementa de forma educativa para cumplir la especificación.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo | Propósito |
|---------|-----------|
| [`build.sbt`](build.sbt) | Configuración del proyecto sbt y la dependencia `scalatest`. |
| [`project/build.properties`](project/build.properties) | Versión de sbt. |
| [`src/main/scala/Calculator.scala`](src/main/scala/Calculator.scala) | Implementación de la librería `Calculator`. |
| [`src/test/scala/CalculatorTest.scala`](src/test/scala/CalculatorTest.scala) | Suite de pruebas con ScalaTest. |
| [`.gitignore`](.gitignore) | Ignora artefactos de build y editor. |

**Estructura de directorios esperada:**

```text
calculator/
├── build.sbt
├── project/
│   └── build.properties
├── src/
│   ├── main/
│   │   └── scala/
│   │       └── Calculator.scala
│   └── test/
│       └── scala/
│           └── CalculatorTest.scala
├── .gitignore
└── README.md
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** El proyecto está estructurado como una librería Scala con `src/main/scala` para la lógica y `src/test/scala` para las pruebas. Se usa `sbt` para compilar, enlazar y ejecutar la suite de tests.

**EN:** The project is structured as a Scala library with `src/main/scala` for the logic and `src/test/scala` for tests. `sbt` is used to compile, link, and run the test suite.

Cada operación sigue la misma idea pedagógica de la especificación:

- `addition`: suma directa.
- `subtraction`: resta directa.
- `multiplication`: suma repetitiva, sin usar `*`.
- `division`: resta repetitiva, sin usar `/`.
- `modulus`: reutiliza `division` y `multiplication` para obtener el resto, sin usar `%`.

### Inicialización / Initialization

```bash
mkdir -p scala/core/foundations/unit_test/calculator/src/main/scala
mkdir -p scala/core/foundations/unit_test/calculator/src/test/scala
mkdir -p scala/core/foundations/unit_test/calculator/project
cd scala/core/foundations/unit_test/calculator
```

Luego se crean los archivos `build.sbt`, `project/build.properties`, la librería y las pruebas.

---

## 📄 Archivos de configuración clave / Key Configuration Files

### `build.sbt`

```scala
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.9.0"

lazy val root = (project in file("."))
  .settings(
    name := "calculator",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
```

| Elemento | Propósito |
|----------|-----------|
| `scalaVersion := "3.9.0"` | Fija la versión de Scala del proyecto. |
| `name := "calculator"` | Define el nombre del proyecto. |
| `libraryDependencies += ... % Test` | Añade ScalaTest solo para el ámbito de pruebas. |

### `src/main/scala/Calculator.scala`

```scala
object Calculator {
  def addition(a: Int, b: Int): Int = a + b

  def subtraction(a: Int, b: Int): Int = a - b

  def multiplication(a: Int, b: Int): Int = {
    var result = 0
    var count = 0
    while (count < b) {
      result = addition(result, a)
      count += 1
    }
    result
  }

  def division(a: Int, b: Int): Int = {
    var dividend = a
    var quotient = 0
    while (dividend >= b) {
      dividend = subtraction(dividend, b)
      quotient += 1
    }
    quotient
  }

  def modulus(a: Int, b: Int): Int = {
    val quotient = division(a, b)
    val product = multiplication(quotient, b)
    subtraction(a, product)
  }
}
```

### `src/test/scala/CalculatorTest.scala`

```scala
import org.scalatest.funsuite.AnyFunSuite

class CalculatorTest extends AnyFunSuite {
  test("addition") {
    assert(Calculator.addition(2, 3) == 5)
  }

  test("subtraction") {
    assert(Calculator.subtraction(5, 2) == 3)
  }

  test("multiplication") {
    assert(Calculator.multiplication(3, 4) == 12)
  }

  test("division") {
    assert(Calculator.division(10, 3) == 3)
  }

  test("modulus") {
    assert(Calculator.modulus(10, 3) == 1)
  }
}
```

> **ES:** ScalaTest usa `AnyFunSuite` con pruebas nombradas por `test(...)`, siguiendo un estilo sencillo y muy legible. El proyecto no necesita una clase “test runner” adicional porque `sbt test` descubre y ejecuta la suite.  
> **EN:** ScalaTest uses `AnyFunSuite` with tests named via `test(...)`, following a simple and readable style. The project does not need an extra “test runner” class because `sbt test` discovers and executes the suite.

---

## 🚀 Compilación y ejecución / Build & Run

### Requisitos / Requirements

- **JDK** compatible con Scala.
- **sbt** instalado en el sistema.
- **Scala 3.9.0** y **ScalaTest 3.2.19**.

Verificar las herramientas:

```bash
source ~/.bash_profile
java -version
sbt --version
```

### Ejecutar pruebas / Run tests

```bash
cd scala/core/foundations/unit_test/calculator
sbt test
```

### Salida esperada / Expected output

```text
[info] CalculatorTest:
[info] - addition
[info] - subtraction
[info] - multiplication
[info] - division
[info] - modulus
[info] All tests passed.
[info] Total number of tests run: 5
[info] Suites: 1
[info] Tests: 5
[info] Failures: 0
[info] Errors: 0
[info] Passed: 5
```

> **ES:** El formato exacto puede variar ligeramente según la versión de sbt/ScalaTest, pero la conclusión debe ser que 5 pruebas pasan y 0 fallan.  
> **EN:** The exact format may vary slightly by sbt/ScalaTest version, but the outcome must be that 5 tests pass and 0 fail.

---

## 📝 Notas de implementación / Implementation Notes

- **ES:** La lógica se implementa con bucles `while` para respetar la especificación educativa, sin usar operadores aritméticos directos para multiplicación o división.  
- **EN:** The logic is implemented with `while` loops to follow the educational specification, without using direct arithmetic operators for multiplication or division.
- **ES:** `modulus` se calcula como `a - (division(a, b) * b)`, siguiendo la regla del resto.  
- **EN:** `modulus` is calculated as `a - (division(a, b) * b)`, following the remainder rule.
- **ES:** Los artefactos de compilación (`target/`, `.bsp/`) quedan excluidos por `.gitignore`.  
- **EN:** Build artifacts (`target/`, `.bsp/`) are excluded by `.gitignore`.

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
