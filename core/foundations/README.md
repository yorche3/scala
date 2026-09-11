# 🚀 Fundamentos / Foundations — Scala

Implementación de los ejercicios de la sección [Fundamentos / Foundations](https://yorche3.github.io/programming_languages/core/foundations/) del repositorio principal en **Scala**.

---

## 📖 Descripción / Description

**ES:** Esta sección reúne los conceptos esenciales para empezar a trabajar con **Scala**. Cubre desde programas independientes ejecutados con `scala`/`scala-cli` hasta proyectos tipo librería con **sbt** y pruebas unitarias usando **ScalaTest**.

**EN:** This section brings together the essential concepts for getting started with **Scala**. It covers standalone programs run with `scala`/`scala-cli` and library-style projects built with **sbt** and tested using **ScalaTest**.

---

## 📁 Estructura / Structure

```text
scala/
└── core/
    └── foundations/
        ├── README.md                   # Este archivo / This file
        ├── helloworld/                 # 01_Hello_World — Primer programa
        │   ├── helloworld.scala
        │   └── README.md
        ├── hellouser/                  # 02_Hello_User — Entrada y salida
        │   ├── hellouser.scala
        │   └── README.md
        ├── unit_test/
        │   └── calculator/             # 03_Unit_Test_Calculator — Pruebas unitarias
        │       ├── build.sbt
        │       ├── project/
        │       │   └── build.properties
        │       ├── src/
        │       │   ├── main/
        │       │   │   └── scala/
        │       │   │       └── Calculator.scala
        │       │   └── test/
        │       │       └── scala/
        │       │           └── CalculatorTest.scala
        │       ├── .gitignore
        │       └── README.md
        └── numbers/                    # 04_Numbers — Algoritmos numéricos
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

## 🔢 Progresión / Progression

| Especificación | Proyecto | Conceptos | Tests | Dependencias |
| -------------- | -------- | --------- | :---: | ------------ |
| [`01_Hello_World`](https://yorche3.github.io/programming_languages/core/foundations/01_Hello_World/) | [`helloworld/`](helloworld/) | `object`, `main`, `println`, ejecución con `scala`/`scala-cli` | — | Solo JDK + Scala |
| [`02_Hello_User`](https://yorche3.github.io/programming_languages/core/foundations/02_Hello_User/) | [`hellouser/`](hellouser/) | `StdIn.readLine`, `String`, concatenación | — | Solo JDK + Scala |
| [`03_Unit_Test_Calculator`](https://yorche3.github.io/programming_languages/core/foundations/03_Unit_Test_Calculator/) | [`unit_test/calculator/`](unit_test/calculator/) | proyecto sbt, librería, ScalaTest, `AnyFunSuite` | 5 | `scalatest` en Test |
| [`04_Numbers`](https://yorche3.github.io/programming_languages/core/foundations/04_Numbers/) | [`numbers/`](numbers/) | recursión, acumulador, iteración, `@tailrec` | 15 | `scalatest` en Test |

---

## 🛠️ Enfoque general / General Approach

**ES:** Los proyectos de esta sección siguen una progresión gradual:

1. **Hello World** y **Hello User**: programas sencillos en un solo archivo `.scala`, ejecutados con `scala` o `scala-cli`.
2. **Calculator**: primer proyecto tipo librería con `sbt`, `src/main/scala` y `src/test/scala`. Usa ScalaTest (`AnyFunSuite`) para las pruebas unitarias.
3. **Numbers**: proyecto tipo librería con tres enfoques (`_rec`, `_acc`, `_ite`) y tres suites separadas, cada una agrupada por método de la API. La versión `_acc` usa `@tailrec` para reflejar la intención de cola, y todas las pruebas pasan con ScalaTest.

**EN:** The projects in this section follow a gradual progression:

1. **Hello World** and **Hello User**: simple single-file `.scala` programs, run with `scala` or `scala-cli`.
2. **Calculator**: the first library-style project with `sbt`, `src/main/scala`, and `src/test/scala`. It uses ScalaTest (`AnyFunSuite`) for unit testing.
3. **Numbers**: a library-style project with three approaches (`_rec`, `_acc`, `_ite`) and three separate suites, each grouped by method. The `_acc` version uses `@tailrec` to reflect tail-recursive intent, and all tests pass under ScalaTest.

---

## 📦 Requisitos / Requirements

| Herramienta | Uso | Verificación |
| ----------- | --- | ------------ |
| [JDK](https://openjdk.org/) | Ejecutar Scala y sbt | `java -version` |
| [sbt](https://www.scala-sbt.org/) | Gestionar builds y tests | `sbt --version` |
| [Scala 3.x](https://scala-lang.org/) | Compilar y ejecutar proyectos | `scala -version` |

En este entorno, Scala se usa cargando la configuración del shell:

```bash
source ~/.bash_profile
java -version
scala -version
sbt --version
```

---

## 🚀 Ejecución rápida / Quick Start

### Hello World

```bash
cd scala/core/foundations/helloworld
scala helloworld.scala
```

### Hello User

```bash
cd scala/core/foundations/hellouser
scala hellouser.scala
```

### Calculator (sbt + ScalaTest)

```bash
cd scala/core/foundations/unit_test/calculator
sbt test
```

Salida resumida esperada:

```text
Tests: succeeded 5, failed 0
```

### Numbers (sbt + ScalaTest)

```bash
cd scala/core/foundations/numbers
sbt test
```

Salida resumida esperada:

```text
Tests: succeeded 15, failed 0
```

---

## 🧪 Convenciones de pruebas / Testing Conventions

**ES:** Los proyectos con tests usan `sbt` y `ScalaTest` en `src/test/scala`. Cada suite se organiza con `AnyFunSuite` y cada caso se declara con `test("nombre_metodo")`, manteniendo la agrupación por función para una lectura clara del resultado.

**EN:** Projects with tests use `sbt` and ScalaTest under `src/test/scala`. Each suite is organized with `AnyFunSuite`, and each case is declared with `test("method_name")`, keeping the grouping by function for clear test output.

---

## 🧹 Artefactos de compilación / Build Artefacts

sbt genera `target/` y artefactos de entorno como `.bsp/` o `.scala-build/`. Cada proyecto incluye un `.gitignore` local para excluir esos elementos y mantener el repositorio limpio.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
