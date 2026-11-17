
# AD05 - Tarea Evaluativa

## Aplicación web: Mi Recetario

Aplicación web desarrollada con Spring Boot para gestionar recetas de cocina y sus pasos de elaboración. Permite crear, consultar, modificar y eliminar recetas y pasos, almacenando la información en una base de datos Oracle.

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.5.7
- Spring Data JPA
- Spring MVC
- Hibernate
- Thymeleaf
- Bootstrap 5
- Oracle Database XE 21c
- Maven
- Eclipse IDE

## Funcionalidades

### Gestión de recetas
- Crear recetas.
- Consultar el listado de recetas.
- Editar recetas existentes.
- Eliminar recetas.

### Gestión de pasos
- Añadir pasos a una receta.
- Consultar los pasos registrados.
- Editar pasos.
- Eliminar pasos.

### Relación entre entidades
La aplicación utiliza dos entidades relacionadas:

- **Receta:** entidad principal.
- **Paso:** entidad dependiente.

Una receta puede tener varios pasos. Al eliminar una receta, también se eliminan sus pasos asociados mediante cascada JPA.

## Estructura del proyecto

```text
src/
├── main/
│   ├── java/
│   │   └── ad05tareaevaluativa/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── service/
│   │       └── Ad05TareaEvaluativaApplication.java
│   └── resources/
│       ├── templates/
│       │   ├── recetas/
│       │   └── pasos/
│       └── application.properties
```

## Configuración de la base de datos

La aplicación utiliza Oracle Database XE 21c.

Para ejecutar el proyecto es necesario configurar las credenciales de acceso a Oracle en el archivo `application.properties`.

No se deben publicar contraseñas ni otros datos privados en el repositorio.

## Ejecución de la aplicación

1. Clonar el repositorio.
2. Importar el proyecto como proyecto Maven en Eclipse.
3. Configurar la conexión con Oracle en `application.properties`.
4. Actualizar las dependencias Maven.
5. Ejecutar `Ad05TareaEvaluativaApplication.java` como Spring Boot App.

La aplicación estará disponible en:

http://localhost:8085/recetas

## Autora

Laura Mediavilla Valdelvira

Desarrollo de Aplicaciones Multiplataforma (DAM)

Curso 2026-2027
