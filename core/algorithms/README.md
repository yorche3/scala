# 🚀 Algoritmos Puros / Algorithms Pure — Scala

Implementaciones de la [Fase 1 — Algoritmos Puros](https://yorche3.github.io/programming_languages/ROADMAP/#fase-1--algoritmos-puros--algorithms-pure-) en **Scala**: ordenamientos elementales, estructuras de datos propias, ordenamientos óptimos y distribuidos, y búsqueda.

Los módulos de esta fase trabajan sobre **arrays mutables** (`Array[Int]`), que se ordenan *in-place* y se devuelven. Un array de la JVM admite `null`, así que el caso nulo se representa con `null` como indicador de fallo (no se lanzan excepciones) y el array vacío es `Array.empty[Int]`.

---

## 📂 Módulos / Modules

| Módulo | Especificación | Enfoque | Tests | Estado |
|--------|---------------|---------|:-----:|:------:|
| [`naive_sort/`](naive_sort/) | [05_Naive_Sort](https://yorche3.github.io/programming_languages/core/algorithms/05_Naive_Sort/) | `sbt test` (ScalaTest) | 24 | ✅ |

---

## 📁 Estructura / Structure

```text
algorithms/
└── naive_sort/                        # 05_Naive_Sort
    ├── build.sbt                      # Proyecto + dependencia scalatest
    ├── project/build.properties       # sbt 1.10.1
    ├── .gitignore                     # target/, .bsp/, .scala-build/, .metals/, .idea/
    ├── src/main/scala/
    │   └── NaiveSort.scala            # Objeto NaiveSort: 3 funciones
    ├── src/test/scala/
    │   └── NaiveSortTests.scala       # 3 tests × 8 casos
    └── README.md
```

---

## 🛠️ Patrón común / Common Pattern

| Característica | Descripción |
|---------------|-------------|
| **Runtime** | Scala 3.9.0 sobre la JVM (en este entorno, OpenJDK 25) |
| **CLI** | `sbt test` (y `sbt clean compile` para la verificación estática), desde la raíz del proyecto |
| **Andamiaje** | ✅ Estructura manual del layout sbt (`mkdir -p src/main/scala src/test/scala project` + `build.sbt` + `project/build.properties`), la que ya usa [`foundations/numbers/`](../foundations/numbers/) |
| **Framework de tests** | ScalaTest 3.2.19 declarado en `build.sbt` (`%% % Test`), sin dependencias extra |
| **Runner** | `sbt test` descubre las suites de `src/test/scala`; no hay `run_tests.scala` |
| **Separación** | `src/main/scala` (objeto del módulo) ↔ `src/test/scala` (suites) |
| **Módulo fuente** | Un `object` por módulo (`NaiveSort`) con funciones `def`, como `Numbers` en `numbers/` |
| **API** | Una función por algoritmo, `def <algoritmo>(arr: Array[Int]): Array[Int]` |
| **Naming** | `snake_case` idéntico al de la especificación (`selection_sort`); la suite usa `PascalCase` y métodos `test("...")` |
| **Mutabilidad** | Los arrays de la JVM son mutables: los algoritmos ordenan *in-place*; la suite ordena una copia (`clone`) por caso |
| **Nulabilidad** | `null` como indicador de fallo (representable en un array de la JVM); el array vacío es `Array.empty[Int]` |
| **Mensajes de aserción** | `assert(actual sameElements expected, s"$algorithm should sort ${description}")`, con el mensaje del contrato |
| **Verificación estática** | `sbt clean compile` sin warnings; ojo con los *non-local returns* (`return` dentro de un `for`), que Scala 3 marca como no soportados |
| **Artefactos** | `target/`, `project/target/`, `.bsp/`, `.scala-build/`, `.metals/`, `.idea/` — ignorados por el `.gitignore` del módulo |
| **Particularidades** | Comparar arrays con `sameElements` (no con `==`, que es identidad de referencia); rangos `until` exclusivos para los `for` del pseudocódigo; salida temprana de `bubble_sort` con `while` y la bandera en la condición |

---

## 🚀 Compilación rápida / Quick Build

```bash
# Naive Sort Tests
cd naive_sort
sbt clean compile test
```

---

## ▶️ Siguiente / Next

👉 Continúa con los módulos pendientes de esta fase en el [Roadmap](https://yorche3.github.io/programming_languages/ROADMAP/).

👉 Continue with the pending modules of this phase in the [Roadmap](https://yorche3.github.io/programming_languages/ROADMAP/).

---

*[← Volver a Core](../README.md)*

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
