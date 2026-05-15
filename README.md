# Sistema de Inspectoría Escolar 2026

Sistema web desarrollado para la gestión de personas, matrículas, familias y cursos dentro del área de inspectoría escolar.

Este proyecto es la evolución del prototipo desarrollado en 2025. Transformamos una aplicación de escritorio creada en NetBeans en una plataforma web moderna.

## Tecnologías Utilizadas

- Backend: Spring Boot + Java 17
- Frontend: Angular
- Base de datos: PostgreSQL

---

# Funcionalidades del Sistema

## Gestión de Personas

- Registro de estudiantes y apoderados
- Edición de registros
- Eliminación controlada
- Gestión de roles familiares

---

## Gestión de Matrículas

- Registro de matrículas escolares
- Asociación de alumno y curso
- Selección de apoderados
- Gestión de sostenedor y responsables
- Edición y eliminación de matrículas

---

## Gestión Familiar

- Visualización de relaciones familiares
- Búsqueda por apellido del estudiante

---

## Gestión de Cursos

- Registro de cursos académicos
- Asociación de nivel y año académico
- Edición y eliminación de cursos

---

# Instalación y Configuración

## 1. Configuración Base de Datos

Crear una base de datos PostgreSQL llamada:

```sql
CREATE DATABASE inspectoria;
```

---

## 2. Ejecutar Backend

Abrir una terminal dentro de la carpeta:

```plaintext
backend
```

Ejecutar:

```bash
mvnw.cmd spring-boot:run
```

El backend quedará disponible en:

```plaintext
http://localhost:8212
```

---

## 3. Ejecutar Frontend

Abrir Visual Studio Code y luego abrir una terminal dentro de la carpeta:

```plaintext
frontend
```

Instalar dependencias:

```bash
npm install
```

Ejecutar Angular:

```bash
ng serve
```

El frontend quedará disponible en:

```plaintext
http://localhost:4200
```

---

## 4. Credenciales Demo

El sistema crea automáticamente un usuario administrador al iniciar el backend.

### Usuario

```plaintext
admin
```

### Contraseña

```plaintext
1234
```

---

## 5. Cursos Demo

Al iniciar el backend se crean automáticamente cursos de prueba:

- 1ero Básico
- 2do Básico
- 3ero Medio

---

# Integrantes

- Tais Fernandez
- Carlos Ignacio Pino
