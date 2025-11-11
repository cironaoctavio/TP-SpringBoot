# 📝 Gestor de Tareas - Spring Boot

## 📌 Descripción del proyecto
Aplicación de consola basada en Spring Boot que permite gestionar tareas en memoria.

Las tareas tienen:
- Descripción
- Prioridad (BAJA, MEDIA, ALTA)
- Estado (pendiente / completada)

La aplicación incluye:
- Servicio con reglas de negocio para manejar tareas
- Repositorio en memoria (`TareaRepository`)
- Configuración externa mediante `application.properties` y profiles `dev` / `prod`
- Lectura de propiedades con `@Value`
- Estadísticas básicas de tareas



## 🛠 Tecnologías utilizadas

- Java 17
- Spring Boot 3.5.7
- Maven
- Lombok
- Git



## 🚀 Cómo clonar y ejecutar el proyecto


# Clonar el repositorio
git clone https://github.com/TU-USUARIO/TU-REPO.git
cd TU-REPO

# Compilar y ejecutar
mvn spring-boot:run


🔄 Cómo ejecutar el proyecto
    🧭 Paso 1: Clonar el repositorio
        git clone https://github.com/TU-USUARIO/tp-fundamentos-springboot.git
        cd tp-fundamentos-springboot

    🧭 Paso 2: Ejecutar con Maven
        mvn spring-boot:run

    🧭 Paso 3: Cambiar entre perfiles

Podés cambiar el perfil activo desde la terminal o el archivo de configuración.

Por terminal:

    mvn spring-boot:run -Dspring-boot.run.profiles=dev
    mvn spring-boot:run -Dspring-boot.run.profiles=prod


O directamente en el archivo application.properties:

    spring.profiles.active=prod

🖼 Capturas de pantalla

![Captura de pantalla 2025-11-10 a la(s) 11.20.57 p. m..png](Docs/Captura%20de%20pantalla%202025-11-10%20a%20la%28s%29%2011.20.57%E2%80%AFp.%C2%A0m..png)
![Captura de pantalla 2025-11-10 a la(s) 11.20.25 p. m..png](Docs/Captura%20de%20pantalla%202025-11-10%20a%20la%28s%29%2011.20.25%E2%80%AFp.%C2%A0m..png)

💭 Conclusiones personales

Este trabajo me permitió comprender en profundidad el funcionamiento del contenedor 
IoC de Spring, el uso de inyección de dependencias y la importancia de separar las 
capas de una aplicación.
También entendí cómo funcionan los perfiles de configuración y cómo adaptar 
parámetros de ejecución sin modificar el código.
Fue una excelente práctica para afianzar conceptos fundamentales de Spring Boot y 
buenas prácticas de desarrollo en Java.

👤 Autor

Nombre: Octavio Martinez Cirona
Legajo: 51451
Materia: Desarrollo de Software
Año: 2025

