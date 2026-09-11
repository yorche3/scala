# Core — Scala

Sección central de la implementación de ejercicios en **Scala** dentro del repositorio principal.

---

## 📂 Módulos / Modules

| Módulo | Descripción |
| ------ | ----------- |
| [`foundations/`](foundations/) | **Fase 0 — Fundamentos**: `helloworld`, `hellouser`, `unit_test/calculator`, `numbers` |

---

## ▶️ Comenzar / Getting Started

```bash
# Desde la raíz de Scala
cd scala
source ~/.bash_profile

# Ejecutar ejercicios de fundamentos
cd core/foundations/helloworld
scala helloworld.scala

cd ../hellouser
scala hellouser.scala

cd ../unit_test/calculator
sbt test

cd ../../numbers
sbt test
```

---

## 🧭 Organización / Organization

**ES:** `core` agrupa la parte fundamental de la práctica del lenguaje. En Scala, esto incluye programas independientes y proyectos tipo librería con `sbt`.

**EN:** `core` groups the fundamental part of the language practice. In Scala, this includes standalone programs and library-style projects managed with `sbt`.

```text
scala/
└── core/
    ├── README.md
    └── foundations/
        ├── helloworld/
        ├── hellouser/
        ├── unit_test/
        │   └── calculator/
        └── numbers/
```

---

## 🧪 Convenciones de pruebas / Testing Conventions

**ES:** Los módulos con pruebas usan `sbt` y `ScalaTest`, con suites agrupadas por método (`test("...")`) para una lectura clara de la salida.

**EN:** Modules with tests use `sbt` and ScalaTest, with suites grouped by method (`test("...")`) for clear output readability.

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
