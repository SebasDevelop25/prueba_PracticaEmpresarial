# Prueba Práctica Empresarial

Aplicación de consola en Java para la gestión de productos (CRUD), con persistencia de datos en una base de datos SQLite.

## Descripción

El sistema permite crear, listar, buscar, actualizar y eliminar productos a través de un menú interactivo en consola. Cada producto cuenta con nombre, precio, stock y categoría, y se almacena de forma persistente en un archivo de base de datos SQLite local.

## Tecnologías utilizadas

- **Java** (JDK 8 o superior)
- **SQLite** como motor de base de datos
- **SQLite JDBC** (`sqlite-jdbc-3.53.2.1.jar`) como driver de conexión

## Estructura del proyecto

```
prueba_PracticaEmpresarial/
├── Main.java                  # Punto de entrada y menú de la aplicación
├── Conexion.java               # Manejo de la conexión JDBC con SQLite
├── Producto.java                # Clase modelo (entidad Producto)
├── ProductoDAO.java              # Acceso a datos: creación, lectura, actualización y eliminación
├── database.sql                  # Script SQL de creación de la tabla y datos iniciales
├── database.db                   # Base de datos SQLite (se genera/actualiza en tiempo de ejecución)
└── sqlite-jdbc-3.53.2.1.jar        # Driver JDBC de SQLite
```

## Requisitos previos

- Tener instalado el **JDK** (Java Development Kit) versión 8 o superior.
- Contar con el driver `sqlite-jdbc-3.53.2.1.jar` incluido en el proyecto (ya está presente en el repositorio).

## Cómo compilar y ejecutar

### 1. Compilar

Desde la raíz del proyecto, ejecuta:

```bash
javac -cp sqlite-jdbc-3.53.2.1.jar *.java
```

### 2. Ejecutar

**En Windows:**

```bash
java -cp .;sqlite-jdbc-3.53.2.1.jar Main
```

