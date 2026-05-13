# Sistema de Inspectoría: Gestión de Matrículas y Personas (2026)

Este sistema es una evolución del prototipo 2025, ahora desarrollado como una aplicación web.

A diferencia de la versión anterior en NetBeans, este sistema utiliza:

- **Backend:** Java 17 con Spring Boot
- **Frontend:** Angular
- **Base de Datos:** PostgreSQL

---

# Funcionalidades del Sistema

## Gestión de Personas

- Registro de personas
- Edición de información
- Eliminación de personas
- Gestión de roles:
  - Estudiante
  - Padre
  - Madre
  - Abuelo
  - Familiar
  - Otro

---

## Gestión de Matrículas

- Registro de matrículas escolares
- Asignación de estudiante
- Selección de apoderados
- Validación de matrícula existente
- Gestión de cursos académicos

---

## Gestión Familiar

- Visualización de grupos familiares
- Relación entre alumnos y apoderados
- Búsqueda por apellido del alumno

---

# Tecnologías Utilizadas

## Frontend

- Angular
- TypeScript
- Bootstrap
- HTML5
- CSS3

## Backend

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

## Base de Datos

- PostgreSQL

# Instalación del Proyecto

## 1. Clonar el repositorio

Abrir CMD y ejecutar:

```bash
git clone https://github.com/taisfernandezr10/ICIFG003-EQ012.git

# Configuración de Base de Datos PostgreSQL

## 2. Ingresar a PostgreSQL

Abrir CMD y ejecutar:

```bash
psql -U postgres

Ingresar contraseña:
1234

## 3. Crear Base de Datos

Dentro de PostgreSQL ejecutar:

```bash
CREATE DATABASE inspectoria;

## 4. Crear Usuario Administrador para el Login

Conectarse a la base de datos:
```bash
\c inspectoria

Insertar usuario administrador:
```bash
INSERT INTO usuario (username, password)
VALUES ('admin', '1234');

Credenciales de Prueba
Usuario: admin
contraseña: 1234

## Ejecucion del backend

##5. Ejecutar Spring Boot
1. Abrir la carpeta backend en spring tool suite
2. Esperar que Maven cargue las dependencias
3. Ejecutar el proyecto Spring Boot

Backend ejecutándose en:
http://localhost:8212

Ejecución del Frontend
6. Ejecutar Angular
Abrir la carpeta frontend en Visual Studio Code
Abrir una terminal dentro del proyecto
Ejecutar:
npm install
Luego ejecutar:
ng serve

Frontend ejecutándose en:

http://localhost:4200












