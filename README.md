# Sistema Básico de Registro de Estudiantes

## Descripción

Este proyecto es un sistema de gestión académica básico desarrollado en Java que permite registrar estudiantes, almacenar sus calificaciones, calcular promedios y determinar si han aprobado o reprobado. La aplicación funciona a través de una interfaz de línea de comandos, con un menú interactivo.

## Funcionalidades

- **Registro de estudiantes**: Permite ingresar el nombre del estudiante y sus tres calificaciones.
- **Visualización de datos**: Muestra la información del estudiante registrado.
- **Cálculo de promedio**: Calcula el promedio de las tres calificaciones del estudiante.
- **Determinación de aprobación**: Indica si el estudiante aprobó (promedio ≥ 60) o reprobó.
- **Borrado de datos**: Permite eliminar los datos del estudiante actual.

## Estructura del Proyecto

El proyecto está organizado en las siguientes carpetas:

- `src`: Contiene el código fuente de la aplicación
  - `App.java`: Clase principal que implementa todas las funcionalidades
- `bin`: Almacena los archivos compilados (.class)
- `lib`: Destinada para gestionar dependencias de bibliotecas externas

## Cómo Ejecutar

1. Asegúrate de tener Java instalado en tu sistema
2. Compila el proyecto usando el comando: `javac -d bin src/App.java`
3. Ejecuta la aplicación: `java -cp bin App`

## Uso del Sistema

Al iniciar la aplicación, se mostrará un menú con las siguientes opciones:

1. **Registrar datos del estudiante**: Permite ingresar nombre y calificaciones
2. **Mostrar datos del estudiante actual**: Muestra la información registrada
3. **Calcular promedio y mostrar aprobación**: Calcula el promedio y determina si aprobó
4. **Borrar datos del estudiante actual**: Elimina los datos registrados
0. **Salir**: Finaliza la aplicación

## Validaciones

El sistema incluye validaciones para:
- Nombres vacíos o nulos
- Calificaciones fuera del rango 0-100
- Entradas no numéricas

