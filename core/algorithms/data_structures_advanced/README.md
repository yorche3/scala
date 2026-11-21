# Data Structures Advanced — Scala

Implementación de la especificación [07_Data_Structures_Advanced](../../../../docs/core/algorithms/07_Data_Structures_Advanced.md) en **Scala**, con un enfoque manual y minimalista.

**ES:** El módulo implementa una base `Node` con el valor y dos estructuras derivadas avanzadas —`BinaryTree` (árbol de búsqueda binaria sobre `TreeNode`) y `Graph` (grafo dirigido con registro enlazado canónico de vértices sobre `GraphNode`)— gestionando sus enlaces e invariantes manualmente sin delegar en colecciones o índices asociativos de la biblioteca estándar. Las pruebas unitarias se ejecutan con **sbt** y **ScalaTest**.

**EN:** The module implements a `Node` value base and two advanced derived structures —`BinaryTree` (binary search tree built on `TreeNode`) and `Graph` (directed graph with a canonical linked vertex registry built on `GraphNode`)— managing links and invariants manually without delegating to standard library collections or associative indexes. Unit tests run with **sbt** and **ScalaTest**.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo / Directory | Propósito / Purpose |
|---|---|
| `src/main/scala/data_structures_advanced/Node.scala` | Base común local del módulo `Node` con `value: Int` inmutable y visibilidad de paquete. / Local module base `Node`. |
| `src/main/scala/data_structures_advanced/TreeNode.scala` | Nodo de árbol `TreeNode` que hereda de `Node` y añade enlaces izquierdo y derecho `Option[TreeNode]`. / Tree node extending `Node`. |
| `src/main/scala/data_structures_advanced/BinaryTree.scala` | Árbol binario de búsqueda sin capacidad máxima contractual sobre `TreeNode`. / Binary search tree built on `TreeNode`. |
| `src/main/scala/data_structures_advanced/GraphNode.scala` | Vértice `GraphNode` que hereda de `Node` con etiqueta, lista ordenada inmutable de vecinos y enlace canónico al siguiente vértice. / Graph vertex extending `Node`. |
| `src/main/scala/data_structures_advanced/Graph.scala` | Grafo dirigido sobre un registro enlazado manual de `GraphNode` con contadores separados de vértices y aristas. / Directed graph built on a manual linked registry of `GraphNode`. |
| `src/test/scala/data_structures_advanced/DataStructuresAdvancedTests.scala` | Suite ScalaTest con 23 pruebas sobre el estado y operaciones de las tres estructuras. / ScalaTest suite with 23 tests covering all three structures. |
| `build.sbt` | Configuración del proyecto sbt y dependencia de ScalaTest. / sbt build configuration and ScalaTest dependency. |
| `project/build.properties` | Declaración de versión de sbt (`1.10.1`). / sbt version declaration (`1.10.1`). |
| `.gitignore` | Archivos generados excluidos (`target/`, etc.). / Ignored build artifacts. |

> **Nota de desviación respecto a la ubicación esperada / Deviation note from expected location:**  
> La especificación sugiere `src/data_structures_advanced.ext` y `test/data_structures_advanced_test.ext`. En Scala se adopta el estándar de sbt dividiendo en archivos separados por clase bajo `src/main/scala/data_structures_advanced/` y `src/test/scala/data_structures_advanced/`, sin un ejecutable `run_tests` ya que `sbt test` orquesta el descubrimiento y ejecución de pruebas nativamente.

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** El proyecto se estructura siguiendo las convenciones de sbt en Scala 3. Las cinco clases residen en el paquete `data_structures_advanced`. `Node` define la base local que contiene únicamente el valor (`val value: Int`). `TreeNode` y `GraphNode` la extienden por herencia directa. `BinaryTree` implementa inserción y comprobación de pertenencia respetando la invariante del ABB en $O(h)$. `Graph` mantiene un registro enlazado propio de vértices recorrido linealmente en $O(V)$ y listas de vecinos ordenadas crecientemente con operaciones de búsqueda e inserción recursivas manuales en $O(d(u))$.

**EN:** The project is structured following standard sbt conventions in Scala 3. All five classes reside in the `data_structures_advanced` package. `Node` defines the local base containing only the value (`val value: Int`). `TreeNode` and `GraphNode` extend it via direct inheritance. `BinaryTree` implements insertion and membership following the BST invariant in $O(h)$. `Graph` maintains its own linked vertex registry traversed linearly in $O(V)$ and ascending neighbour lists with manual recursive search and insertion in $O(d(u))$.

### Inicialización / Initialization

```bash
mkdir -p scala/core/algorithms/data_structures_advanced/src/main/scala/data_structures_advanced
mkdir -p scala/core/algorithms/data_structures_advanced/src/test/scala/data_structures_advanced
mkdir -p scala/core/algorithms/data_structures_advanced/project
cd scala/core/algorithms/data_structures_advanced
```

---

## 📄 Configuración clave / Key Configuration

### `build.sbt`

```scala
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.9.0"

lazy val root = (project in file("."))
  .settings(
    name := "data_structures_advanced",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
```

| Elemento / Setting | Propósito / Purpose |
|---|---|
| `scalaVersion := "3.9.0"` | Fija el compilador Scala 3. / Sets Scala 3 compiler version. |
| `name := "data_structures_advanced"` | Nombre del módulo / Module name. |
| `libraryDependencies += "org.scalatest" ... % Test` | Dependencia de pruebas unitarias ScalaTest. / Testing framework dependency. |

---

## 🚀 Compilación y ejecución / Build & Run

```bash
cd scala/core/algorithms/data_structures_advanced
sbt -batch -no-colors clean compile test
```

**Salida real / Actual output:**

```text
[info] welcome to sbt 1.10.1 (Ubuntu Java 25.0.5.1)
[info] loading project definition from ~/programming_languages/scala/core/algorithms/data_structures_advanced/project
[info] loading settings for project root from build.sbt ...
[info] set current project to data_structures_advanced (in build file:~/programming_languages/scala/core/algorithms/data_structures_advanced/)
[info] Executing in batch mode. For better performance use sbt's shell
[success] Total time: 0 s, completed Nov 21, 2026, 7:53:17 AM
[info] compiling 5 Scala sources to ~/programming_languages/scala/core/algorithms/data_structures_advanced/target/scala-3.9.0/classes ...
[info] done compiling
[success] Total time: 3 s, completed Nov 21, 2026, 7:53:19 AM
[info] compiling 1 Scala source to ~/programming_languages/scala/core/algorithms/data_structures_advanced/target/scala-3.9.0/test-classes ...
[info] done compiling
[info] DataStructuresAdvancedTests:
[info] - TreeNode: create a tree node
[info] - TreeNode: absent initial links
[info] - TreeNode: link two children
[info] - TreeNode: traverse each link
[info] - TreeNode: unlink children
[info] - BinaryTree: create empty
[info] - BinaryTree: insert the root
[info] - BinaryTree: insert lower and higher
[info] - BinaryTree: multilevel branches
[info] - BinaryTree: missing value in nonempty tree
[info] - BinaryTree: idempotent duplicate
[info] - BinaryTree: ordered insertions
[info] - Graph: create empty
[info] - Graph: isolated vertex
[info] - Graph: nonconsecutive labels and directed edge
[info] - Graph: duplicate vertex preserves adjacency
[info] - Graph: duplicate edge
[info] - Graph: missing endpoint without mutation
[info] - Graph: sorted neighbors and counts
[info] - Graph: missing-edge query
[info] - Graph: neighbors of missing vertex
[info] - Graph: self-loop and duplicate
[info] - Graph: neighbor-result isolation
[info] Run completed in 135 milliseconds.
[info] Total number of tests run: 23
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 23, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 1 s, completed Nov 21, 2026, 7:53:21 AM
```

---

## 🧠 Algoritmos y operaciones / Algorithms & Operations

| Operación / Operation | Entrada → salida / Input → output | Complejidad / Complexity | Notas / Notes |
|---|---|---|---|
| `Node(value)` | `Int → Node` | $O(1)$ | Constructor package-private reutilizado por herencia en `TreeNode` y `GraphNode`. |
| `Node.value` | `() → Int` | $O(1)$ | Observador inmutable del valor de la celda. |
| `TreeNode(value)` | `Int → TreeNode` | $O(1)$ | Factoría en `TreeNode.apply`; enlaces izquierdo y derecho inicializados en `None`. |
| `TreeNode.value` | `() → Int` | $O(1)$ | Observador inmutable heredado de `Node`. |
| `TreeNode.left` / `left_=` | `() → Option[TreeNode]` / `Option[TreeNode] → Unit` | $O(1)$ | Getter y setter mutable del enlace al subárbol izquierdo (`None` si ausente). |
| `TreeNode.right` / `right_=` | `() → Option[TreeNode]` / `Option[TreeNode] → Unit` | $O(1)$ | Getter y setter mutable del enlace al subárbol derecho (`None` si ausente). |
| `BinaryTree()` | `() → BinaryTree` | $O(1)$ | Factoría en `BinaryTree.apply`; raíz ausente (`None`) y tamaño 0. |
| `BinaryTree.insert(value)` | `Int → Boolean` | $O(h)$ | Inserta `value` según la invariante del ABB; duplicados devuelven `true` y no aumentan tamaño ($h$ = altura). |
| `BinaryTree.contains(value)` | `Int → Boolean` | $O(h)$ | Comprueba pertenencia siguiendo la invariante del ABB; devuelve `false` si no está. |
| `BinaryTree.isEmpty` | `() → Boolean` | $O(1)$ | Informa si `size == 0`. |
| `BinaryTree.size` | `() → Int` | $O(1)$ | Consulta el contador interno `_count` de valores distintos. |
| `GraphNode(label)` | `Int → GraphNode` | $O(1)$ | Factoría package-private; etiqueta heredada de `Node`, sin vecinos y `nextVertex = None`. |
| `Graph()` | `() → Graph` | $O(1)$ | Factoría en `Graph.apply`; registro de vértices vacío (`None`), 0 vértices y 0 aristas. |
| `Graph.addVertex(label)` | `Int → Boolean` | $O(V)$ | Registra `label` al frente del registro canónico; si ya existe devuelve `true` sin duplicar. |
| `Graph.addEdge(u, v)` | `(Int, Int) → Boolean` | $O(V + d(u))$ | Añade la arista dirigida $u \to v$ si ambos vértices existen; bucles y duplicados permitidos; devuelve `false` si falta algún extremo. |
| `Graph.hasEdge(u, v)` | `(Int, Int) → Boolean` | $O(V + d(u))$ | Comprueba existencia de la arista dirigida; devuelve `false` si no existe o falta algún extremo. |
| `Graph.neighbors(u)` | `Int → Option[List[Int]]` | $O(V + d(u))$ | Devuelve `Some(List(...))` con vecinos en orden creciente, `Some(Nil)` si está aislado, o `None` si $u$ no existe. |
| `Graph.isEmpty` | `() → Boolean` | $O(1)$ | Informa si `vertexCount == 0`. |
| `Graph.vertexCount` | `() → Int` | $O(1)$ | Consulta el contador de vértices registrados `_vertexCount`. |
| `Graph.edgeCount` | `() → Int` | $O(1)$ | Consulta el contador de aristas registradas `_edgeCount`. |

---

## 🧩 Decisiones de diseño / Design decisions

| Decisión / Decision | Alternativa considerada / Alternative | Razón / Reason |
|---|---|---|
| Reutilización de `Node` por herencia en `TreeNode` y `GraphNode` | Composición / valor embebido (`val node: Node`) | Scala modela la jerarquía de forma directa y eficiente sin indirecciones adicionales; la visibilidad `private[data_structures_advanced]` asegura que `Node` solo se reutilice dentro del paquete. |
| Almacenamiento de vecinos en `GraphNode` con `List[Int]` inmutable | Lista mutable (`ListBuffer`), conjunto (`Set[Int]`) o nodos propios enlazados | La especificación autoriza el uso de la lista de la biblioteca estándar como almacenamiento si los algoritmos de adyacencia son manuales. La inmutabilidad de `List[Int]` asegura que compartir los vecinos con `neighbors(u)` sea seguro frente a mutaciones externas. |
| Registro canónico de vértices con lista enlazada manual en `Graph` | Tabla hash (`Map[Int, GraphNode]`) o array indexado | La especificación prohíbe el uso de tablas hash o diccionarios para el registro de vértices, exigiendo un recorrido lineal explícito en $O(V)$ sobre enlaces propios. |
| `neighbors(u)` devuelve `Option[List[Int]]` | Devolver `List.empty` para vértice aislado y vértice ausente, o lanzar excepción | El contrato obliga a diferenciar un vértice registrado pero aislado (`Some(Nil)`) de un vértice inexistente (`None`), sin recurrir a excepciones ni centinelas ambiguos. |

---

## 🔀 Adaptaciones idiomáticas / Idiomatic adaptations

| Especificación / Specification | Adaptación / Adaptation | Justificación / Justification |
|---|---|---|
| Inicialización `init(value)` / `init()` | Métodos factoría `apply` en el `companion object` de `TreeNode`, `BinaryTree` y `Graph` | Idiomático en Scala para construir instancias pre-inicializadas con constructores privados o de paquete. |
| `get_value()`, `get_left()`, `get_right()`, `set_left(node)`, `set_right(node)` | Propiedad `val value`, getters `left`/`right` y setters mutables `left_=`/`right_=` con `Option[TreeNode]` | Convención estándar de propiedades y mutadores sintácticos en Scala; `Option` representa nativamente enlaces presentes o ausentes. |
| `get_neighbors(u)` con secuencia devuelta | Retorno `Option[List[Int]]` (`Some(List(...))` o `None`) | Representación tipada de presencia/ausencia del vértice sin ambigüedad frente a la lista vacía de un vértice aislado. |
| `is_empty()`, `size()`, `vertex_count()`, `edge_count()` | Métodos sin paréntesis `isEmpty`, `size`, `vertexCount`, `edgeCount` | Convención de acceso uniforme en Scala para métodos observadores puros sin efectos secundarios. |
| Módulo en un solo archivo `src/data_structures_advanced.ext` | 5 archivos fuente bajo `src/main/scala/data_structures_advanced/` | Separación idiomática de responsabilidades y clases en proyectos sbt/Scala. |

---

## 🚨 Indicadores de fallo / Failure indicators

| Operación / Operation | Situación de fallo / Failure situation | Indicador / Indicator | Ejemplo / Example |
|---|---|---|---|
| `TreeNode.left` / `TreeNode.right` | Enlace ausente | `None` | `TreeNode(10).left == None` |
| `BinaryTree.contains(value)` | Valor ausente en el árbol | `false` | `tree.contains(99) == false` |
| `Graph.addEdge(u, v)` | Vértice origen $u$ o destino $v$ no registrado | `false` | `graph.addEdge(10, 99) == false` |
| `Graph.hasEdge(u, v)` | Arista no existente o extremos no registrados | `false` | `graph.hasEdge(10, 30) == false` |
| `Graph.neighbors(u)` | Vértice $u$ no registrado en el grafo | `None` | `graph.neighbors(99) == None` |
| Entrada nula / Null input | No aplica en la API (valores primitivos `Int` y referencias seguras con `Option`) | No representable | Scala no requiere chequear `null` sobre `Int`. |

---

## ✅ Cobertura de pruebas / Test coverage

| Caso de la especificación / Specification case | Cubierto / Covered | Prueba / Test | Notas / Notes |
|---|---|:--:|---|
| `TreeNode`: Crear un nodo de árbol | Sí | `DataStructuresAdvancedTests.scala:98` (`TreeNode: create a tree node`) | Verifica valor `10` preservado tras la inicialización. |
| `TreeNode`: Enlaces iniciales ausentes | Sí | `DataStructuresAdvancedTests.scala:105` (`TreeNode: absent initial links`) | Verifica enlaces izquierdo y derecho iguales a `None`. |
| `TreeNode`: Enlazar dos hijos | Sí | `DataStructuresAdvancedTests.scala:110` (`TreeNode: link two children`) | Enlaza hijos `20` y `30` y verifica sus valores. |
| `TreeNode`: Recorrer cada enlace | Sí | `DataStructuresAdvancedTests.scala:121` (`TreeNode: traverse each link`) | Recorre hacia los hijos y confirma que sus enlaces son `None`. |
| `TreeNode`: Desenlazar hijos | Sí | `DataStructuresAdvancedTests.scala:141` (`TreeNode: unlink children`) | Desenlaza izquierdo y derecho sucesivamente preservando el valor `10`. |
| `TreeNode`: Adaptación inmutable (si aplica) | Omitido | — | No aplica: `TreeNode` en Scala utiliza mutabilidad en enlaces mediante setters `left_=` y `right_=`. |
| `BinaryTree`: Crear vacío | Sí | `DataStructuresAdvancedTests.scala:162` (`BinaryTree: create empty`) | `isEmpty == true`, `size == 0`, `contains(50) == false`. |
| `BinaryTree`: Insertar la raíz | Sí | `DataStructuresAdvancedTests.scala:170` (`BinaryTree: insert the root`) | Inserta `50`; `size == 1`, no vacío, `contains(50) == true`. |
| `BinaryTree`: Insertar menor y mayor | Sí | `DataStructuresAdvancedTests.scala:176` (`BinaryTree: insert lower and higher`) | Inserta `50`, `30`, `70`; `size == 3`, los tres presentes. |
| `BinaryTree`: Ramas de varios niveles | Sí | `DataStructuresAdvancedTests.scala:187` (`BinaryTree: multilevel branches`) | Inserta `50`, `30`, `70`, `20`, `40`; `size == 5`, todos presentes. |
| `BinaryTree`: Valor ausente en árbol no vacío | Sí | `DataStructuresAdvancedTests.scala:194` (`BinaryTree: missing value in nonempty tree`) | Inserta `50`; `contains(99) == false`, `size == 1`. |
| `BinaryTree`: Duplicado idempotente | Sí | `DataStructuresAdvancedTests.scala:199` (`BinaryTree: idempotent duplicate`) | Inserta `50`, `30`, `70`, `30`; cuatro éxitos, `size == 3`. |
| `BinaryTree`: Inserciones ordenadas | Sí | `DataStructuresAdvancedTests.scala:212` (`BinaryTree: ordered insertions`) | Inserta `20`, `30`, `40`, `50`, `70`; `size == 5`, `contains(99) == false`. |
| `Graph`: Crear vacío | Sí | `DataStructuresAdvancedTests.scala:219` (`Graph: create empty`) | `isEmpty == true`, 0 vértices, 0 aristas, `hasEdge` y `neighbors` fallan. |
| `Graph`: Vértice aislado | Sí | `DataStructuresAdvancedTests.scala:226` (`Graph: isolated vertex`) | `addVertex(10)`; 1 vértice, 0 aristas, `neighbors(10) == Some(Nil)`. |
| `Graph`: Etiquetas no consecutivas y arista dirigida | Sí | `DataStructuresAdvancedTests.scala:232` (`Graph: nonconsecutive labels and directed edge`) | Vértices `10`, `70`; arista `10 -> 70` presente, `70 -> 10` ausente; 2 vértices, 1 arista. |
| `Graph`: Vértice duplicado conserva adyacencia | Sí | `DataStructuresAdvancedTests.scala:240` (`Graph: duplicate vertex preserves adjacency`) | Re-insertar vértice `10` no altera adyacencia previa `[30]`; 2 vértices, 1 arista. |
| `Graph`: Arista duplicada | Sí | `DataStructuresAdvancedTests.scala:248` (`Graph: duplicate edge`) | Añadir arista `10 -> 30` dos veces no duplica; 2 vértices, 1 arista. |
| `Graph`: Extremo inexistente sin mutación | Sí | `DataStructuresAdvancedTests.scala:256` (`Graph: missing endpoint without mutation`) | Cuatro fallos al referenciar `98`/`99`; no muta estado previo; 2 vértices, 1 arista. |
| `Graph`: Vecinos ordenados y contadores | Sí | `DataStructuresAdvancedTests.scala:274` (`Graph: sorted neighbors and counts`) | Vértices `10, 30, 50, 70`; adyacencias `[30, 50, 70]`, `[50]`, `Nil`; 4 vértices, 4 aristas. |
| `Graph`: Consulta de arista ausente | Sí | `DataStructuresAdvancedTests.scala:294` (`Graph: missing-edge query`) | `hasEdge(10, 30) == false` sin arista; 2 vértices, 0 aristas, no vacío. |
| `Graph`: Vecinos de vértice inexistente | Sí | `DataStructuresAdvancedTests.scala:301` (`Graph: neighbors of missing vertex`) | `neighbors(99) == None`, diferenciado de `neighbors(10) == Some(Nil)`. |
| `Graph`: Bucle y duplicado | Sí | `DataStructuresAdvancedTests.scala:310` (`Graph: self-loop and duplicate`) | Bucle `10 -> 10` añadido dos veces; `hasEdge` es `true`; 1 vértice, 1 arista. |
| `Graph`: Aislamiento del resultado de vecinos | Sí | `DataStructuresAdvancedTests.scala:319` (`Graph: neighbor-result isolation`) | Resultado guardado `Some(List(30))` no muta tras añadir arista `10 -> 50`. |

**ES:** Mapeo de casos: `unidad/variante → casos aplicables → grupo lógico → archivo/suite → runner`:
- `TreeNode`: 5 casos aplicables (1 omitido por mutabilidad) → grupo lógico "TreeNode" → `DataStructuresAdvancedTests.scala` (`DataStructuresAdvancedTests`) → `sbt test` (ScalaTest `AnyFunSuite`).
- `BinaryTree`: 7 casos aplicables → grupo lógico "BinaryTree" → `DataStructuresAdvancedTests.scala` (`DataStructuresAdvancedTests`) → `sbt test` (ScalaTest `AnyFunSuite`).
- `Graph`: 11 casos aplicables → grupo lógico "Graph" → `DataStructuresAdvancedTests.scala` (`DataStructuresAdvancedTests`) → `sbt test` (ScalaTest `AnyFunSuite`).

**EN:** Case mapping: `unit/variant → applicable cases → logical group → file/suite → runner`:
- `TreeNode`: 5 applicable cases (1 omitted due to mutability) → "TreeNode" logical group → `DataStructuresAdvancedTests.scala` (`DataStructuresAdvancedTests`) → `sbt test` (ScalaTest `AnyFunSuite`).
- `BinaryTree`: 7 applicable cases → "BinaryTree" logical group → `DataStructuresAdvancedTests.scala` (`DataStructuresAdvancedTests`) → `sbt test` (ScalaTest `AnyFunSuite`).
- `Graph`: 11 applicable cases → "Graph" logical group → `DataStructuresAdvancedTests.scala` (`DataStructuresAdvancedTests`) → `sbt test` (ScalaTest `AnyFunSuite`).

---

## ⚠️ Limitaciones conocidas / Known limitations

| Limitación / Limitation | Impacto / Impact | Alternativa o plan / Workaround or plan |
|---|---|---|
| Dominio restringido a enteros primitivos (`Int`) | No admite claves genéricas ni tipos heterogéneos | Cumple la especificación 07; la parametrización genérica corresponde a fases posteriores. |
| Registro de vértices mediante búsqueda lineal $O(V)$ en `Graph` | En grafos con miles de vértices, las operaciones de consulta son lineales en lugar de logarítmicas o constantes | Es una exigencia pedagógica contractual para evitar el uso de mapas hash o índices por etiqueta; algoritmos de grafos optimizados se implementan en fases avanzadas (`structures/16_Graph_Algorithms`). |

---

## 📝 Notas de implementación / Implementation Notes

- **ES:** La base abstracta `Node` declara `val value: Int` con constructor privado al paquete `data_structures_advanced`, impidiendo instancias directas fuera de la jerarquía. `TreeNode` y `GraphNode` heredan directamente de ella sin duplicar el campo de valor.
- **EN:** The abstract base `Node` declares `val value: Int` with a package-private constructor, preventing direct instantiations outside the hierarchy. `TreeNode` and `GraphNode` extend it directly without duplicating the value field.
- **ES:** En `BinaryTree`, las funciones internas recursivas `insertNode` y `containsNode` navegan la estructura garantizando la invariante de orden del ABB ($O(h)$). La inserción de duplicados devuelve `true` sin alterar el contador `_count`.
- **EN:** In `BinaryTree`, internal recursive helpers `insertNode` and `containsNode` traverse the tree ensuring the BST order invariant ($O(h)$). Inserting duplicates returns `true` without altering the `_count` counter.
- **ES:** En `Graph`, el registro de vértices es una lista enlazada simple administrada con el campo `nextVertex` de `GraphNode`. La adyacencia de cada vértice utiliza la lista inmutable `List[Int]` de Scala, cuyos recorridos, comprobación de pertenencia e inserción ordenada se realizan con funciones recursivas puras escritas a mano (`containsValue` e `insertSorted`), sin utilizar primitivas de biblioteca como `contains`, `sorted` o `sortBy`.
- **EN:** In `Graph`, the vertex registry is a singly linked list managed via `GraphNode.nextVertex`. Each vertex's adjacency uses Scala's immutable `List[Int]`, whose traversal, membership check, and sorted insertion are handled via handwritten pure recursive functions (`containsValue` and `insertSorted`), avoiding library sorting or searching primitives.
- **ES:** Manejo del caso nulo: no se emplean referencias `null` ni excepciones para el flujo de control. Los enlaces ausentes se modelan con `Option[TreeNode]` (`None`), y la consulta de vecinos sobre un vértice inexistente devuelve `None`, diferenciándose del vértice aislado que devuelve `Some(Nil)`.
- **EN:** Null handling: neither `null` references nor control-flow exceptions are used. Absent links are modeled with `Option[TreeNode]` (`None`), and querying neighbors for a nonexistent vertex returns `None`, distinct from an isolated vertex returning `Some(Nil)`.

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
| Especificación / Specification | [`07_Data_Structures_Advanced.md`](../../../../docs/core/algorithms/07_Data_Structures_Advanced.md) |
| Primera base del lenguaje / First language reference | `data_structures_basics` — [`../data_structures_basics/`](../data_structures_basics/) |
| Segunda base del lenguaje / Second language reference | `numbers` — [`../../foundations/numbers/`](../../foundations/numbers/) |
| Guía de inicialización / Initialisation guide | [`00_Project_Initialization_Guide.md`](../../../../docs/core/00_Project_Initialization_Guide.md) |
| Adaptaciones idiomáticas / Idiomatic adaptations | [`AGENT_Template.md`](../../../../docs/AGENT_Template.md) |
| Validación de la documentación / Documentation validation | [`WORKFLOW.md`](../../../../docs/WORKFLOW.md) |
| Documentación oficial del lenguaje / Language official docs | [Scala 3 Documentation](https://docs.scala-lang.org/) |

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*[← Volver a Algoritmos Puros](../README.md)*

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
