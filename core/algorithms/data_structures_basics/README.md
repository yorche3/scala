# Data Structures Basics — Scala

Implementación de la especificación [06_Data_Structures_Basics](https://yorche3.github.io/programming_languages/core/algorithms/06_Data_Structures_Basics/) en **Scala**, con un enfoque manual y minimalista.

El módulo implementa desde cero `Node` como celda enlazada compartida y tres estructuras de datos clásicas —`LinkedList`, `Stack` y `Queue`— gestionando directamente sus enlaces y contadores internos sin delegar en colecciones de la biblioteca estándar. Las pruebas unitarias se ejecutan con **sbt** y **ScalaTest**.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo / Directory | Propósito / Purpose |
|---|---|
| `src/main/scala/data_structures_basics/Node.scala` | Celda enlazada compartida `Node` con `value: Int` y `next: Option[Node]`. / Shared linked cell `Node`. |
| `src/main/scala/data_structures_basics/LinkedList.scala` | Lista enlazada simple construida sobre `Node`. / Singly linked list built on `Node`. |
| `src/main/scala/data_structures_basics/Stack.scala` | Pila LIFO independiente construida sobre `Node`. / Independent LIFO stack built on `Node`. |
| `src/main/scala/data_structures_basics/Queue.scala` | Cola FIFO independiente construida sobre `Node`. / Independent FIFO queue built on `Node`. |
| `src/test/scala/data_structures_basics/DataStructuresBasicsTests.scala` | Suite ScalaTest con 19 pruebas sobre el estado y operaciones de los cuatro ADTs. / Test suite covering all four ADTs. |
| `build.sbt` | Configuración del proyecto sbt y dependencia de ScalaTest. / sbt build configuration and ScalaTest dependency. |
| `project/build.properties` | Declaración de versión de sbt (`1.10.1`). / sbt version declaration. |
| `.gitignore` | Archivos generados excluidos (`target/`, etc.). / Ignored build artifacts. |

> **Nota de desviación respecto a la ubicación esperada / Deviation note from expected location:**  
> La especificación sugiere `src/data_structures_basics.ext` y `test/data_structures_basics_test.ext`. En Scala se adopta el estándar de sbt dividiendo en archivos separados por clase bajo `src/main/scala/data_structures_basics/` y `src/test/scala/data_structures_basics/`, sin un ejecutable `run_tests` ya que `sbt test` orquesta el descubrimiento y ejecución de pruebas nativamente.

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** El proyecto se estructura siguiendo las convenciones estándar de sbt en Scala 3. Las cuatro estructuras residen en el paquete `data_structures_basics`. Cada estructura implementa sus operaciones mutando referencias internas a nodos, manteniendo la complejidad esperada en cada caso ($O(1)$ para accesos directos, inserciones en extremos y operaciones LIFO/FIFO; $O(n)$ para borrado por valor).

**EN:** The project is structured following standard sbt conventions in Scala 3. All four structures reside in the `data_structures_basics` package. Each structure implements its operations by mutating internal node references, maintaining the expected time complexity ($O(1)$ for direct accesses, boundary insertions, and LIFO/FIFO operations; $O(n)$ for deletion by value).

### Inicialización / Initialization

```bash
mkdir -p scala/core/algorithms/data_structures_basics/src/main/scala/data_structures_basics
mkdir -p scala/core/algorithms/data_structures_basics/src/test/scala/data_structures_basics
mkdir -p scala/core/algorithms/data_structures_basics/project
cd scala/core/algorithms/data_structures_basics
```

---

## 📄 Configuración clave / Key Configuration

### `build.sbt`

```scala
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.9.0"

lazy val root = (project in file("."))
  .settings(
    name := "data_structures_basics",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
```

| Elemento / Setting | Propósito / Purpose |
|---|---|
| `scalaVersion := "3.9.0"` | Fija el compilador Scala 3. / Sets Scala 3 compiler version. |
| `name := "data_structures_basics"` | Nombre del módulo / Module name. |
| `libraryDependencies += "org.scalatest" ... % Test` | Dependencia de pruebas unitarias / Testing framework dependency. |

---

## 🚀 Compilación y ejecución / Build & Run

```bash
cd scala/core/algorithms/data_structures_basics
sbt clean compile test
```

**Salida real / Actual output:**

```text
[info] welcome to sbt 1.10.1 (Ubuntu Java 25.0.4.1)
[info] loading project definition from ~/programming_languages/scala/core/algorithms/data_structures_basics/project
[info] loading settings for project root from build.sbt ...
[info] set current project to data_structures_basics (in build file:~/programming_languages/scala/core/algorithms/data_structures_basics/)
[info] Executing in batch mode. For better performance use sbt's shell
[success] Total time: 0 s, completed Oct 11, 2026, 3:22:11 PM
[info] compiling 4 Scala sources to ~/programming_languages/scala/core/algorithms/data_structures_basics/target/scala-3.9.0/classes ...
[info] done compiling
[success] Total time: 3 s, completed Oct 11, 2026, 3:22:14 PM
[info] compiling 1 Scala source to ~/programming_languages/scala/core/algorithms/data_structures_basics/target/scala-3.9.0/test-classes ...
[info] done compiling
[info] DataStructuresBasicsTests:
[info] - Node.value
[info] - Node.next
[info] - Node.next_=
[info] - LinkedList.head
[info] - LinkedList.isEmpty
[info] - LinkedList.size
[info] - LinkedList.insertHead
[info] - LinkedList.insertTail
[info] - LinkedList.delete
[info] - Stack.isEmpty
[info] - Stack.size
[info] - Stack.push
[info] - Stack.pop
[info] - Stack.peek
[info] - Queue.isEmpty
[info] - Queue.size
[info] - Queue.enqueue
[info] - Queue.dequeue
[info] - Queue.peek
[info] Run completed in 174 milliseconds.
[info] Total number of tests run: 19
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 19, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 2 s, completed Oct 11, 2026, 3:22:16 PM
```

---

## 🧠 Algoritmos y operaciones / Algorithms & Operations

| Operación / Operation | Entrada → salida / Input → output | Complejidad / Complexity | Notas / Notes |
|---|---|---|---|
| `Node(value)` | `Int → Node` | $O(1)$ | Factory en `Node.apply`, inicializa enlace en `None`. |
| `Node.value` | `() → Int` | $O(1)$ | Observador inmutable del valor de la celda. |
| `Node.next` / `next_=` | `() → Option[Node]` / `Option[Node] → Unit` | $O(1)$ | Getter y setter mutable del enlace al siguiente nodo. |
| `LinkedList()` | `() → LinkedList` | $O(1)$ | Factory en `LinkedList.apply`, cabeza/cola ausentes y tamaño 0. |
| `LinkedList.head` | `() → Int` | $O(1)$ | Observa la cabeza; devuelve centinela `-1` si está vacía. |
| `LinkedList.isEmpty` | `() → Boolean` | $O(1)$ | Informa si `size == 0`. |
| `LinkedList.size` | `() → Int` | $O(1)$ | Consulta el contador interno `_count`. |
| `LinkedList.insertHead(value)` | `Int → Unit` | $O(1)$ | Inserta un nodo al inicio y actualiza cabeza y cola si aplica. |
| `LinkedList.insertTail(value)` | `Int → Unit` | $O(1)$ | Inserta un nodo al final usando el puntero `_tail`. |
| `LinkedList.delete(value)` | `Int → Boolean` | $O(n)$ | Elimina la primera aparición de `value`; devuelve `true` en éxito o `false` si no está. |
| `Stack()` | `() → Stack` | $O(1)$ | Factory en `Stack.apply`, cima ausente y tamaño 0. |
| `Stack.isEmpty` | `() → Boolean` | $O(1)$ | Informa si `size == 0`. |
| `Stack.size` | `() → Int` | $O(1)$ | Consulta el contador interno `_count`. |
| `Stack.push(value)` | `Int → Unit` | $O(1)$ | Coloca un nuevo nodo en `_top`. |
| `Stack.pop()` | `() → Int` | $O(1)$ | Extrae y devuelve el valor en `_top`; devuelve `-1` si está vacía. |
| `Stack.peek` | `() → Int` | $O(1)$ | Observa `_top` sin extraerlo; devuelve `-1` si está vacía. |
| `Queue()` | `() → Queue` | $O(1)$ | Factory en `Queue.apply`, frente/final ausentes y tamaño 0. |
| `Queue.isEmpty` | `() → Boolean` | $O(1)$ | Informa si `size == 0`. |
| `Queue.size` | `() → Int` | $O(1)$ | Consulta el contador interno `_count`. |
| `Queue.enqueue(value)` | `Int → Unit` | $O(1)$ | Encola al final usando el puntero `_rear`. |
| `Queue.dequeue()` | `() → Int` | $O(1)$ | Desencola desde `_front`; devuelve `-1` si está vacía. |
| `Queue.peek` | `() → Int` | $O(1)$ | Observa `_front` sin extraerlo; devuelve `-1` si está vacía. |

---

## 🧩 Decisiones de diseño / Design decisions

| Decisión / Decision | Alternativa considerada / Alternative | Razón / Reason |
|---|---|---|
| Uso de `companion object.apply` como `init` | Constructor público `new Class()` o método `init()` mutable posterior | En Scala `apply()` en el objeto acompañante es la forma idiomática de instanciación con estado inicial limpio y constructor privado. |
| Uso de `Option[Node]` para el puntero `next` | Punteros anulables con `null` directo | Modela de forma segura y tipada la ausencia de nodo en Scala sin riesgos de `NullPointerException` en el recorrido interno. |
| Métodos de consulta sin paréntesis (`size`, `isEmpty`, `head`, `peek`) | Métodos con paréntesis vacíos `size()` | Convención de acceso uniforme en Scala para métodos sin efectos secundarios (observadores puros). |
| Estado mutable interno encapsulado (`private var`) | Colecciones inmutables persistentes estándar | La especificación evalúa el manejo explícito de celdas y punteros de bajo nivel para ADTs clásicos. |

---

## 🔀 Adaptaciones idiomáticas / Idiomatic adaptations

| Especificación / Specification | Adaptación / Adaptation | Justificación / Justification |
|---|---|---|
| Inicialización explícita `Node.init(v)` / `Struct.init()` | Métodos factoría `apply` en el `companion object` de cada clase | Idiomático en Scala para construir instancias pre-inicializadas con constructor privado. |
| `get_value()`, `get_next()`, `set_next(n)` en `Node` | Propiedad inmutable `val value`, getter `next` y setter `next_=` | Convención estándar de propiedades y mutadores en Scala. |
| `get_head()` en `LinkedList` | Propiedad `head` (devuelve `Int`) | Convención idiomática de nombrado y acceso uniforme en Scala. |
| Ausencia de enlace (`absent`) en `Node` | `Option[Node]` (`None` para ausencia) | Representación nativa segura de ausencia de referencia en la JVM sin romper el tipado estricto. |
| Contrato en un solo archivo `src/data_structures_basics.ext` | 4 archivos fuente (`Node.scala`, `LinkedList.scala`, `Stack.scala`, `Queue.scala`) | Separación idiomática de responsabilidades en proyectos sbt/Scala. |

---

## 🚨 Indicadores de fallo / Failure indicators

| Operación / Operation | Situación de fallo / Failure situation | Indicador / Indicator | Ejemplo / Example |
|---|---|---|---|
| `LinkedList.head` | Lista vacía (`size == 0`) | `-1` | `LinkedList().head == -1` |
| `LinkedList.delete(value)` | Elemento no encontrado en la lista | `false` | `list.delete(99) == false` |
| `Stack.pop()` | Pila vacía (`size == 0`) | `-1` | `Stack().pop() == -1` |
| `Stack.peek` | Pila vacía (`size == 0`) | `-1` | `Stack().peek == -1` |
| `Queue.dequeue()` | Cola vacía (`size == 0`) | `-1` | `Queue().dequeue() == -1` |
| `Queue.peek` | Cola vacía (`size == 0`) | `-1` | `Queue().peek == -1` |
| Entrada nula / Null input | No aplica en la API (valores primitivos `Int`) | No representable | Scala no requiere chequear `null` sobre `Int`. |

---

## ✅ Cobertura de pruebas / Test coverage

| Caso de la especificación / Specification case | Cubierto / Covered | Prueba / Test | Notas / Notes |
|---|---|:--:|---|
| `Node`: Inicializar y observar valor/enlace | Sí | `DataStructuresBasicsTests.scala:216-222` (`Node.value`, `Node.next`) | Comprueba valor `10` y enlace ausente (`None`). |
| `Node`: Enlazar otro nodo y recorrer | Sí | `DataStructuresBasicsTests.scala:224` (`Node.next_=`) | Enlaza segundo nodo (`20`) y verifica encadenamiento. |
| `LinkedList`: Estado vacío (`is_empty`, `size`, `get_head`) | Sí | `DataStructuresBasicsTests.scala:228-238` | `isEmpty == true`, `size == 0`, `head == -1`. |
| `LinkedList`: Insertar por ambos extremos | Sí | `DataStructuresBasicsTests.scala:240-246` | Inserta `10`, `20`, `5`, `10`; verifica `size == 4` y cabeza `5`. |
| `LinkedList`: Eliminar primera aparición | Sí | `DataStructuresBasicsTests.scala:248-250` | `delete(10)` devuelve `true`, `size == 3`. |
| `LinkedList`: Valor ausente | Sí | `DataStructuresBasicsTests.scala:248-250` | `delete(99)` devuelve `false`, tamaño inalterado. |
| `LinkedList`: Vaciar | Sí | `DataStructuresBasicsTests.scala:248-250` | Elimina elementos restantes; `isEmpty == true`, `size == 0`, `head == -1`. |
| `Stack`: Estado vacío y extracción fallida | Sí | `DataStructuresBasicsTests.scala:252-270` | `isEmpty == true`, `size == 0`, `peek == -1`, `pop() == -1`. |
| `Stack`: LIFO y `peek` no mutante | Sí | `DataStructuresBasicsTests.scala:260-270` | `push` de `10, 20, 30`, `peek == 30`, `size == 3`. |
| `Stack`: Extracción y reutilización | Sí | `DataStructuresBasicsTests.scala:264-270` | Extracciones sucesivas respetan orden LIFO (`30, 40, 20, 10`). |
| `Stack`: Vacío tras extracción | Sí | `DataStructuresBasicsTests.scala:264-270` | `pop()` adicional falla (`-1`) y permanece vacío. |
| `Queue`: Estado vacío y extracción fallida | Sí | `DataStructuresBasicsTests.scala:272-290` | `isEmpty == true`, `size == 0`, `peek == -1`, `dequeue() == -1`. |
| `Queue`: FIFO y `peek` no mutante | Sí | `DataStructuresBasicsTests.scala:272-290` | `enqueue` de `10, 20, 30`, `peek == 10`, `size == 3`. |
| `Queue`: Extracción y reutilización | Sí | `DataStructuresBasicsTests.scala:280-290` | Extracciones sucesivas respetan orden FIFO (`10, 20, 30, 40`). |
| `Queue`: Vacío tras extracción | Sí | `DataStructuresBasicsTests.scala:284-290` | `dequeue()` adicional falla (`-1`) y permanece vacío. |

---

## ⚠️ Limitaciones conocidas / Known limitations

| Limitación / Limitation | Impacto / Impact | Alternativa o plan / Workaround or plan |
|---|---|---|
| Dominio restringido a enteros primitivos (`Int`) | No almacena tipos genéricos | Cumple la especificación 06; la generalización genérica o ADTs polimórficos corresponden a fases posteriores. |
| Sin soporte para valores negativos si se usa `-1` como valor de dominio | No se puede distinguir un valor legítimo `-1` del indicador de fallo en `head`, `pop` o `dequeue` | La especificación define el dominio de prueba con enteros positivos para evitar colisión con el indicador natural de fallo. |

---

## 📝 Notas de implementación / Implementation Notes

- **ES:** Se utiliza un único tipo `Node` compartido por las tres estructuras (`LinkedList`, `Stack`, `Queue`), tal y como exige la especificación. Cada estructura de datos maneja de manera independiente sus referencias internas (`_head`/`_tail`, `_top`, `_front`/`_rear`) y contadores de tamaño sin delegar unas en otras.
- **EN:** A single `Node` type is shared across all three structures (`LinkedList`, `Stack`, `Queue`), strictly fulfilling the specification. Each data structure independently manages its internal references (`_head`/`_tail`, `_top`, `_front`/`_rear`) and counters without delegating to each other.
- **ES:** En consonancia con las reglas de la fase 1 (Algorithms Pure), no se lanzan excepciones; las operaciones fallidas sobre estructuras vacías devuelven el centinela `-1`, las de eliminación devuelven `false` si no se encuentra el elemento, y la ausencia de enlaces se representa con `None`.
- **EN:** In alignment with Phase 1 rules (Algorithms Pure), no exceptions are thrown; failing operations on empty structures return the `-1` sentinel, deletions return `false` if the item is absent, and absent links are represented with `None`.

---

## 🔍 Checklist de validación / Validation checklist

- [x] La suite nativa se ejecutó y su salida real está copiada en este README.
- [x] Cada caso de la especificación tiene su fila en _Cobertura de pruebas_ (o `Omitido` con razón).
- [x] Cada desviación del pseudocódigo o de la ubicación esperada está en _Adaptaciones idiomáticas_.
- [x] Cada operación con fallo posible está en _Indicadores de fallo_.
- [x] No hay rutas absolutas del autor, credenciales ni salidas inventadas.
- [x] Los enlaces relativos resuelven dentro del repositorio y el documento es bilingüe.
- [x] Ninguna sección repite lo que ya dice la especificación.

---

## 📚 Referencias / References

| Tipo / Kind | Referencia / Reference |
|---|---|
| Especificación / Specification | [`06_Data_Structures_Basics.md`](https://yorche3.github.io/programming_languages/core/algorithms/06_Data_Structures_Basics/) |
| Módulo homologado del lenguaje / Homologated module | [`core/foundations/numbers/`](../../foundations/numbers/) |
| Módulo previo de la fase / Phase module | [`core/algorithms/naive_sort/`](../naive_sort/) |
| Plantilla de README / README template | [`README_Template.md`](https://github.com/yorche3/programming_languages/blob/main/docs/README_Template.md) |
| Documentación oficial del lenguaje / Language official docs | [Scala 3 Documentation](https://docs.scala-lang.org/) |

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*[← Volver a Algoritmos Puros](../README.md)*

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
