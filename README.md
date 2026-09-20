# Scala

Proyectos en **Scala**, con programas independientes ejecutados mediante `scala` o `scala-cli` y proyectos tipo librería gestionados con **sbt** y probados con **ScalaTest**.

---

## 📂 Módulos / Modules

| Módulo | Descripción |
| ------ | ----------- |
| [`core/foundations/`](core/foundations/) | **Fase 0 — Fundamentos**: `helloworld`, `hellouser`, `unit_test/calculator`, `numbers` |
| [`core/algorithms/`](core/algorithms/) | **Fase 1 — Algoritmos Puros**: `naive_sort` |

---

## ▶️ Comenzar / Getting Started

```bash
# Cargar el entorno de Scala/Coursier
source ~/.bash_profile

# Hello, World!
cd core/foundations/helloworld
scala helloworld.scala

# Hello, User!
cd ../hellouser
scala hellouser.scala

# Calculator tests
cd ../unit_test/calculator
sbt test

# Numbers tests
cd ../../numbers
sbt test

# Naive Sort tests
cd ../../algorithms/naive_sort
sbt test
```

---

## 📦 Requisitos / Requirements

| Herramienta | Uso | Instalación / verificación |
| ----------- | --- | -------------------------- |
| [JDK](https://openjdk.org/) | Ejecutar Scala y sbt | `java -version` |
| [Coursier](https://get-coursier.io/) | Instalar Scala y scala-cli | `cs --version` |
| [Scala 3.x](https://scala-lang.org/) | Compilar y ejecutar archivos `.scala` | `scala -version` |
| [sbt](https://www.scala-sbt.org/) | Gestionar librerías y tests | `sbt --version` |

```bash
# Cargar herramientas del entorno
source ~/.bash_profile

# Verificar la instalación
java -version
scala -version
sbt --version
```

> **ES:** En este entorno, Scala y sbt se cargan desde `~/.bash_profile` mediante Coursier y la configuración del shell.
> **EN:** In this environment, Scala and sbt are loaded from `~/.bash_profile` through Coursier and shell configuration.

---

## 🏗️ Tipos de proyecto / Project Types

### 1. Programa independiente (`scala` / `scala-cli`)

**ES:** Un solo archivo `.scala` con `object` y `main`, ejecutado directamente con el intérprete de Scala. Es el formato usado por `helloworld` y `hellouser`.

**EN:** A single `.scala` file with `object` and `main`, run directly with the Scala interpreter. This is the format used by `helloworld` and `hellouser`.

```bash
scala <File>.scala
# o
scala-cli run <File>.scala
```

### 2. Proyecto tipo librería con sbt + ScalaTest

**ES:** `calculator` y `numbers` usan `build.sbt`, `src/main/scala` y `src/test/scala`. `sbt` compila la librería, descubre la suite de tests y ejecuta las pruebas con un único comando.

**EN:** `calculator` and `numbers` use `build.sbt`, `src/main/scala`, and `src/test/scala`. `sbt` builds the library, discovers the test suite, and runs the tests with a single command.

```bash
sbt test
```

---

## 🔁 Decisión de TCO / TCO Decision

Scala admite recursión con acumulador y usa `@tailrec` cuando se desea enfatizar la optimización de cola. Aunque el lenguaje puede optimizar algunas llamadas recursivas de cola, se mantiene la documentación del enfoque didáctico y se validan las suites con tests reales, siguiendo la regla del repositorio: cada enfoque se prueba cuando aporta valor claro y es soportado por el lenguaje.

Scala supports accumulator recursion and uses `@tailrec` when the optimization of tail calls is intended. Although the language can optimize some tail-recursive calls, the educational approach is preserved and validated with real tests, following the repository rule: each approach is tested when it provides a clear benefit and is supported by the language.

---

## 🧪 Convenciones de pruebas / Testing Conventions

**ES:** Los proyectos Scala usan `ScalaTest` y `AnyFunSuite`. Cada suite agrupa pruebas por método: `test("sum_of_first_n_rec")`, `test("factorial_acc")`, etc., para mantener una lectura clara y consistente en la salida de sbt.

**EN:** Scala projects use `ScalaTest` and `AnyFunSuite`. Each suite groups tests by method: `test("sum_of_first_n_rec")`, `test("factorial_acc")`, etc., to keep the output readable and consistent.

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
