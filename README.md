# InfoSalud-Backend

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-8DD6F9?style=for-the-badge&logo=java&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-000000?style=for-the-badge&logo=java&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

## Descripción

**InfoSalud-Backend** es un proyecto backend desarrollado en Java utilizando Spring Boot 3, diseñado para gestionar la información relacionada con la salud. El proyecto incorpora Hibernate y JPA para la persistencia de datos, Lombok para la reducción del código boilerplate, y Swagger 3 para la documentación automática de la API.

## Características

- **Spring Boot 3**: Utilizado para la construcción de aplicaciones empresariales robustas y escalables.
- **Hibernate & JPA**: Proveen un marco ORM para la persistencia de objetos en bases de datos relacionales.
- **Lombok**: Facilita la escritura de código más limpio y reduce la verbosidad.
- **Swagger 3**: Permite la generación automática de documentación interactiva para la API.
- **Maven**: Herramienta de gestión de proyectos y dependencias.

## Requisitos

- **Java 17** o superior.
- **Maven 3.8** o superior.
- **Base de datos**: Cualquier base de datos soportada por Hibernate (ej. MySQL, PostgreSQL).

## Instalación

1. Clona el repositorio:

    ```bash
    git clone https://github.com/tu-usuario/InfoSalud-Backend.git
    ```

2. Ve al directorio del proyecto:

    ```bash
    cd InfoSalud-Backend
    ```

3. Construye el proyecto usando Maven:

    ```bash
    mvn clean install
    ```

4. Ejecuta la aplicación:

    ```bash
    mvn spring-boot:run
    ```

## Configuración

La configuración de la base de datos y otros parámetros del sistema se pueden ajustar en el archivo `application.yml` o `application.properties` dentro del directorio `src/main/resources`.

## Documentación de la API

Una vez que la aplicación está en ejecución, puedes acceder a la documentación de la API generada por Swagger en la siguiente URL:

