# Numbers — Scala

Implementación de la especificación [04_Numbers](https://yorche3.github.io/programming_languages/core/foundations/04_Numbers/) en **Scala**, usando **sbt** como gestor del proyecto y **ScalaTest** como framework de pruebas unitarias.

El módulo incluye los cinco algoritmos en tres enfoques: recursivo directo, recursivo con acumulador y iterativo. Los tests se agrupan por método dentro de cada suite de enfoque.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo | Propósito |
|---------|-----------|
| [`build.sbt`](build.sbt) | Configuración del proyecto sbt y la dependencia `scalatest`. |
| [`project/build.properties`](project/build.properties) | Versión de sbt. |
| [`src/main/scala/Numbers.scala`](src/main/scala/Numbers.scala) | Implementación del módulo `Numbers` con los 3 enfoques. |
| [`src/test/scala/RecursiveTests.scala`](src/test/scala/RecursiveTests.scala) | Suite de pruebas recursivas. |
| [`src/test/scala/RecursiveWithAccumulatorTests.scala`](src/test/scala/RecursiveWithAccumulatorTests.scala) | Suite de pruebas con acumulador. |
| [`src/test/scala/IterativeTests.scala`](src/test/scala/IterativeTests.scala) | Suite de pruebas iterativas. |
| [`.gitignore`](.gitignore) | Ignora artefactos generados por sbt y el editor. |

**Estructura de directorios esperada:**

```text
numbers/
├── build.sbt
├── project/
│   └── build.properties
├── src/
│   ├── main/
│   │   └── scala/
│   │       └── Numbers.scala
│   └── test/
│       └── scala/
│           ├── RecursiveTests.scala
│           ├── RecursiveWithAccumulatorTests.scala
│           └── IterativeTests.scala
├── .gitignore
└── README.md
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** Este módulo implementa los algoritmos de la especificación en dos enfoques que sí tienen sentido en Scala y uno que funciona como puente didáctico:

| Enfoque | Sufijo | Estado en Scala |
|---------|--------|-----------------|
| Recursión directa | `_rec` | ✅ se prueba |
| Recursión con acumulador | `_acc` | ✅ se prueba, y usa `@tailrec` para reflejar estilo de cola |
| Iterativo | `_ite` | ✅ se prueba |

**EN:** This module implements the required algorithms in three approaches, all valid in Scala:

| Approach | Suffix | State in Scala |
|----------|--------|----------------|
| Direct recursion | `_rec` | ✅ tested |
| Accumulator recursion | `_acc` | ✅ tested, using `@tailrec` to reflect tail-style programming |
| Iterative | `_ite` | ✅ tested |

### Inicialización / Initialization

```bash
mkdir -p scala/core/foundations/numbers/src/main/scala
mkdir -p scala/core/foundations/numbers/src/test/scala
mkdir -p scala/core/foundations/numbers/project
cd scala/core/foundations/numbers
```

Después se crean los archivos de configuración y el módulo `Numbers` junto con sus suites de prueba.

---

## 📄 Archivos de configuración clave / Key Configuration Files

### `build.sbt`

```scala
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.9.0"

lazy val root = (project in file("."))
  .settings(
    name := "numbers",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
```

| Elemento | Propósito |
|----------|-----------|
| `scalaVersion := "3.9.0"` | Fija la versión de Scala. |
| `name := "numbers"` | Nombre del proyecto. |
| `libraryDependencies += ... % Test` | Añade ScalaTest para las pruebas. |

### `src/main/scala/Numbers.scala`

**ES:** El objeto `Numbers` reúne todas las funciones con sufijos `_rec`, `_acc` e `_ite`, más los helpers de cola cuando se necesitan. En Scala, el hecho de que `@tailrec` esté presente ayuda a documentar la intención de optimización. El código no incluye comentarios extensos; solo se añaden pequeñas marcas de sección cuando aportan claridad.

**EN:** The `Numbers` object groups all functions with `_rec`, `_acc`, and `_ite` suffixes, plus tail-recursive helpers where needed. In Scala, the presence of `@tailrec` helps communicate the optimization intent. The code does not include extensive comments; only brief section markers are used when they add clarity.

```scala
object Numbers {
  def sum_of_first_n_rec(n: Int): Int =
    if (n <= 0) 0 else n + sum_of_first_n_rec(n - 1)

  def sum_of_first_n_acc(n: Int): Int = {
    @annotation.tailrec
    def helper(current: Int, acc: Int): Int =
      if (current <= 0) acc
      else helper(current - 1, current + acc)

    helper(n, 0)
  }

  def sum_of_first_n_ite(n: Int): Int = {
    var result = 0
    var current = 1
    while (current <= n) {
      result += current
      current += 1
    }
    result
  }
}
```

---

## 🚀 Compilación y ejecución / Build & Run

### Requisitos / Requirements

- **JDK** compatible con Scala.
- **sbt** instalado en el sistema.
- **Scala 3.9.0** y **ScalaTest 3.2.19**.

Verificar:

```bash
source ~/.bash_profile
java -version
sbt --version
```

### Ejecutar pruebas / Run tests

```bash
cd scala/core/foundations/numbers
sbt test
```

### Salida esperada / Expected output

```text
[info] RecursiveTests:
[info] - sum_of_first_n_rec
[info] - factorial_rec
[info] - fibonacci_rec
[info] - greatest_common_divisor_rec
[info] - least_common_multiple_rec
[info] RecursiveWithAccumulatorTests:
[info] - sum_of_first_n_acc
[info] - factorial_acc
[info] - fibonacci_acc
[info] - greatest_common_divisor_acc
[info] - least_common_multiple_acc
[info] IterativeTests:
[info] - sum_of_first_n_ite
[info] - factorial_ite
[info] - fibonacci_ite
[info] - greatest_common_divisor_ite
[info] - least_common_multiple_ite
[info] All tests passed.
[info] Total number of tests run: 15
[info] Tests: succeeded 15, failed 0
```

> **ES:** El resumen exacto puede variar ligeramente según la versión de sbt/ScalaTest, pero la clave es que todas las suites pasan y no hay fallos.  
> **EN:** The exact summary may vary slightly by sbt/ScalaTest version, but the key point is that all suites pass with no failures.

---

## 🧪 Agrupación de tests por método / Grouping tests by method

**ES:** Cada suite de enfoque tiene un `class ... extends AnyFunSuite`, y dentro de ella los tests están agrupados por método:

- `test("sum_of_first_n_rec")`
- `test("factorial_rec")`
- `test("fibonacci_rec")`
- `test("greatest_common_divisor_rec")`
- `test("least_common_multiple_rec")`

Esto mantiene una organización legible y consistente con las convenciones del repositorio.

**EN:** Each approach-specific suite is an `AnyFunSuite`, and the tests are grouped by method:

- `test("sum_of_first_n_rec")`
- `test("factorial_rec")`
- `test("fibonacci_rec")`
- `test("greatest_common_divisor_rec")`
- `test("least_common_multiple_rec")`

This keeps the test code easy to read and consistent with the repo conventions.

---

## 📝 Notas de implementación / Implementation Notes

- **ES:** En Scala, la versión `_acc` puede emplear helpers anidados con `@tailrec`, lo que refleja la intención de optimización y da una ruta clara hacia la versión iterativa.  
- **EN:** In Scala, the `_acc` version can use nested helpers with `@tailrec`, which reflects the optimization intent and provides a clear bridge toward the iterative version.
- **ES:** La versión `_ite` usa `while` para cumplir la especificación sin recursión y mantener memoria constante O(1).  
- **EN:** The `_ite` version uses `while` to satisfy the specification without recursion and maintain O(1) memory.
- **ES:** Los artefactos de compilación (`target/`, `.bsp/`) quedan ignorados por `.gitignore`.  
- **EN:** Compile artifacts (`target/`, `.bsp/`) are ignored by `.gitignore`.

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
