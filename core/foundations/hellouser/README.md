# Hello, User! — Scala

Implementación de la especificación [02_Hello_User](https://yorche3.github.io/programming_languages/core/foundations/02_Hello_User/) en **Scala**, con un enfoque manual y minimalista.

Solicita el nombre del usuario mediante entrada estándar y muestra un saludo personalizado.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo | Propósito |
|---------|-----------|
| [`hellouser.scala`](hellouser.scala) | Código fuente: solicita un nombre y lo usa para mostrar un saludo. |

**Estructura de directorios esperada:**

```text
hellouser/
├── hellouser.scala   # Código fuente
└── README.md        # Este archivo
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** Este programa amplía el ejemplo anterior con una interacción simple con el usuario. El flujo básico es:

1. Leer una línea desde la entrada estándar con `scala.io.StdIn.readLine(...)`.
2. Guardar el valor en una variable.
3. Concatenar el nombre con el texto `Hello, ...!` y lo imprimir con `println`.

**EN:** This program extends the previous example with a simple interaction with the user. The basic flow is:

1. Read a line from standard input using `scala.io.StdIn.readLine(...)`.
2. Store that value in a variable.
3. Concatenate the name with `Hello, ...!` and print it using `println`.

### Inicialización / Initialization

1. Crear la estructura de directorios:

   ```bash
   mkdir -p scala/core/foundations/hellouser
   ```

2. Escribir el archivo `hellouser.scala` con el código fuente.

3. Ejecutar el archivo con `scala-cli` o compilarlo manualmente con `scalac`.

---

## 📄 Archivos de configuración clave / Key Configuration Files

No se requieren archivos de configuración de sbt para este ejercicio. Un único archivo `.scala` es suficiente.

```scala
object HelloUser {
  def main(args: Array[String]): Unit = {
    var name = scala.io.StdIn.readLine("Enter your name: ")
    println("Hello, " + name + "!")
  }
}
```

| Elemento | Propósito |
|----------|-----------|
| `object HelloUser` | Declara un singleton object con el punto de entrada del programa. |
| `def main(args: Array[String]): Unit` | Define la función principal ejecutada por la JVM. |
| `scala.io.StdIn.readLine(...)` | Lee una línea de la entrada estándar y devuelve una cadena. |
| `var name` | Almacena el nombre introducido por el usuario. |
| `println(...)` | Muestra el saludo final en la salida estándar. |
| `+` | Concatena la cadena con el nombre y el signo de exclamación. |

> **ES:** En Scala 3 se puede usar una sintaxis más moderna sin `object` y `main`, pero este ejemplo mantiene el estilo clásico y expresivo para que el flujo sea sencillo de seguir.
> **EN:** Scala 3 can use more modern top-level syntax, but this example keeps the classic style to make the execution flow clear and easy to follow.

---

## 🚀 Compilación y ejecución / Build & Run

### Requisitos / Requirements

- **JDK** compatible con Scala/JVM.
- **Coursier** para instalar y gestionar Scala.
- **Scala 3.9.0** y **scala-cli** en el entorno utilizado para esta implementación.

Cargar las herramientas del entorno:

```bash
source ~/.bash_profile
scala -version
scalac -version
scala-cli version
```

### Ejecutar con scala-cli / Run with scala-cli

```bash
cd scala/core/foundations/hellouser
scala-cli run hellouser.scala
```

Durante la ejecución, el programa solicita el nombre y escribe el saludo al terminar la entrada.

### Ejecutar con entrada redirigida / Run with redirected input

```bash
cd scala/core/foundations/hellouser
printf 'Ada\n' | scala-cli run hellouser.scala
```

### Compilar manualmente / Compile manually

```bash
cd scala/core/foundations/hellouser
scalac hellouser.scala
```

> **ES:** `scala-cli run` es la opción recomendada para un archivo independiente porque compila y ejecuta el programa en un solo paso. `scalac` también funciona y genera artefactos JVM en el directorio actual.
> **EN:** `scala-cli run` is the recommended option for a standalone file because it compiles and runs the program in one step. `scalac` also works and generates JVM artifacts in the current directory.

### Salida esperada / Expected output

Con la entrada `Ada`, la salida esperada es:

```text
Enter your name: Ada
Hello, Ada!
```

> **ES:** La llamada a `readLine("Enter your name: ")` imprime el mensaje de solicitud y luego toma la línea introducida por el usuario. El `println` siguiente escribe el saludo final en una nueva línea.
> **EN:** Calling `readLine("Enter your name: ")` prints the prompt and then reads the line entered by the user. The following `println` writes the final greeting on a new line.

---

## 📝 Notas de implementación / Implementation Notes

- **ES:** Scala requiere un `object` con `main` para definir el punto de entrada clásico.
- **EN:** Scala requires an `object` with `main` to define the classic entry point.
- **ES:** `readLine` devuelve un `String` y no necesita convertir el valor manualmente para concatenarlo.
- **EN:** `readLine` returns a `String`, so no manual conversion is needed before concatenation.
- **ES:** Los archivos `.class` o bytecode generados por `scalac` son artefactos de compilación y no forman parte del ejercicio.
- **EN:** The `.class` files or bytecode generated by `scalac` are build artifacts and are not part of the exercise.

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
