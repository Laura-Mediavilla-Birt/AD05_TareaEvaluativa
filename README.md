# AD05 - Tarea Evaluativa

## Aplicación web: Mi Recetario

Aplicación web desarrollada con Spring Boot para gestionar recetas y sus pasos de elaboración. Permite realizar operaciones CRUD (crear, consultar, modificar y eliminar) sobre ambas entidades.

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
- Listar todas las recetas.
- Añadir nuevas recetas.
- Editar recetas existentes.
- Eliminar recetas.

### Gestión de pasos
- Consultar los pasos de elaboración.
- Añadir pasos asociados a una receta.
- Editar pasos.
- Eliminar pasos individualmente.

### Relación entre entidades

La aplicación utiliza dos entidades relacionadas:

- **Receta:** entidad principal.
- **Paso:** entidad dependiente de una receta.

La relación es de uno a muchos (1:N). Una receta puede tener varios pasos y cada paso pertenece a una única receta.

Se utiliza `CascadeType.ALL` y `orphanRemoval = true` para que, al eliminar una receta, también se eliminen sus pasos asociados.

## Estructura del proyecto

```text
AD05_TareaEvaluativa
│
├── src/main/java/ad05tareaevaluativa
│   ├── controller
│   ├── model
│   ├── repository
│   ├── service
│   └── Ad05TareaEvaluativaApplication.java
│
├── src/main/resources
│   ├── templates
│   │   ├── recetas
│   │   └── pasos
│   ├── application.properties.example
│   └── static
│
├── .gitignore
├── pom.xml
└── README.md
```

## Configuración de la base de datos

La aplicación utiliza Oracle Database XE 21c.

Antes de ejecutar el proyecto, es necesario disponer de una base de datos Oracle XE y configurar el acceso en el archivo `application.properties`.

Los datos de conexión utilizados durante el desarrollo son:

- **Servicio:** XEPDB1
- **Puerto:** 1521
- **Usuario:** LAURA_AD05
- **Contraseña:** la configurada para el usuario de Oracle.

La conexión JDBC tiene el siguiente formato:

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XEPDB1
spring.datasource.username=LAURA_AD05
spring.datasource.password=TU_CONTRASEÑA
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect

server.port=8085
```

El repositorio incluye el archivo `application.properties.example` como plantilla de configuración.

Para utilizarlo:

1. Copiar `application.properties.example`.
2. Renombrar la copia como `application.properties`.
3. Sustituir `TU_CONTRASEÑA` por la contraseña correspondiente al usuario de Oracle.

El archivo `application.properties` real no debe subirse al repositorio para evitar publicar credenciales.

## Ejecución del proyecto

1. Clonar el repositorio de GitHub.
2. Importar el proyecto en Eclipse como proyecto Maven.
3. Configurar la conexión con Oracle en `application.properties`.
4. Actualizar las dependencias Maven.
5. Ejecutar la clase `Ad05TareaEvaluativaApplication.java`.

Una vez iniciada la aplicación, acceder desde el navegador a:

[http://localhost:8085/recetas](http://localhost:8085/recetas)

## Autora

**Laura Mediavilla Valdelvira**

Ciclo formativo: Desarrollo de Aplicaciones Multiplataforma (DAM)  
Curso: 2026-2027