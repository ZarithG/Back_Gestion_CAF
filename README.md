# 🏋️ Back_Gestion_CAF

Backend de la aplicación de gestión de los Centros de Acondicionamiento Físico (CAF). Desarrollado con **Java y Spring Boot**, utilizando una arquitectura de microservicios para organizar las funcionalidades de autenticación, usuarios, centros CAF y turnos.

## 🚀 Funcionalidades

- **Autenticación:** inicio de sesión, gestión de usuarios y validación de permisos mediante JWT.
- **Gestión de usuarios:** registro, consulta y actualización de información.
- **Gestión de centros CAF:** administración de centros, coordinadores e inscripciones.
- **Gestión de turnos:** programación, asignación y control de asistencia.
- **API Gateway:** centralización y enrutamiento de solicitudes.
- **Descubrimiento de servicios:** registro y localización de microservicios mediante Eureka.

## 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Cloud Gateway
- Spring Security y JWT
- Spring Data JPA
- MySQL
- Maven
- Docker y Docker Compose
- Eureka Server
- MapStruct y Lombok

## 📂 Estructura del proyecto

```text
Back_Gestion_CAF/
├── API-GATEWAY/             # Enrutamiento de solicitudes
├── AUTH-MICROSERVICE/       # Autenticación y seguridad
├── CAF-MICROSERVICE/        # Gestión de centros CAF
├── EUREKA-SERVICE/          # Descubrimiento de servicios
├── SHIFT-MICROSERVICE/      # Gestión de turnos
├── SHIFT-MICROSERVICE-UPDATED/
└── USERS-MICROSERVICE/      # Gestión de usuarios
```

## ⚙️ Requisitos previos

Antes de ejecutar el proyecto, necesitas:

- Java JDK 17.
- Maven o el Maven Wrapper incluido en los servicios.
- MySQL.
- Docker y Docker Compose, si deseas utilizar los contenedores configurados.

## 🔧 Instalación y ejecución

**1. Clonar el repositorio:**

```bash
git clone <URL_DEL_REPOSITORIO>
```

**2. Ingresar al directorio del servicio que deseas ejecutar:**

```bash
cd Back_Gestion_CAF-caf-management-actual/EUREKA-SERVICE
```

**3. Ejecutar el servicio con Maven Wrapper:**

En Windows:

```bash
mvnw.cmd spring-boot:run
```

En Linux o macOS:

```bash
./mvnw spring-boot:run
```

Repite el proceso para los demás microservicios, configurando previamente sus conexiones a bases de datos y demás dependencias.

## 🌐 Puertos de los servicios

| Servicio | Puerto |
|---|---:|
| API Gateway | 9093 |
| Autenticación | 9091 |
| Usuarios | 9092 |
| Centros CAF | 9094 |
| Turnos | 9090 |
| Eureka Server | 8761 |

## 🔗 Integración con el frontend

El backend proporciona servicios REST que permiten al frontend consultar y gestionar la información de la aplicación.

El frontend debe configurarse para enviar sus solicitudes al API Gateway, que las redirige al microservicio correspondiente.

## 🔒 Seguridad

Las credenciales, claves JWT y configuraciones de conexión deben gestionarse mediante variables de entorno o mecanismos seguros de configuración. No deben publicarse datos sensibles en el repositorio.

## 📄 Licencia

La licencia debe definirse según las condiciones de uso y distribución del proyecto.
