# Sistema de Inspectoría  
## Gestión de Matrículas y Personas (2026)
Sistema web desarrollado para la administración de matrículas escolares y gestión de personas dentro del área de inspectoría.

Esta aplicación corresponde a la evolución del prototipo desarrollado en 2025, migrando desde una solución de escritorio en NetBeans hacia una arquitectura web moderna.

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

---

# Funcionalidades del Sistema
## Gestión de Personas
- Registro de personas
- Edición de información
- Eliminación de personas
- Administración de roles:
  - Estudiante
  - Padre
  - Madre
  - Abuelo
  - Familiar
  - Otro

---

## Gestión de Matrículas
- Registro de matrículas escolares
- Asignación de estudiantes
- Selección de apoderados
- Validación de matrícula existente
- Gestión de cursos académicos

---

## Gestión Familiar
- Visualización de grupos familiares
- Relación entre alumnos y apoderados
- Búsqueda por apellido del estudiante

---

# Arquitectura del Proyecto
```bash
/frontend   -> Aplicación Angular
/backend    -> API REST Spring Boot
/database   -> PostgreSQL
```

---

# Instalación y Configuración
## 1. Clonar el Repositorio

Abrir CMD o terminal y ejecutar:
```bash
git clone https://github.com/taisfernandezr10/ICIFG003-EQ012.git
```

---

# Configuración de PostgreSQL
## 2. Ingresar a PostgreSQL
```bash
psql -U postgres
```
Ingresar contraseña:
```bash
1234
```

---

## 3. Crear la Base de Datos
Dentro de PostgreSQL ejecutar:
```sql
CREATE DATABASE inspectoria;
```

---

## 4. Crear Usuario Administrador
Conectarse a la base de datos:
```sql
\c inspectoria
```

Insertar usuario administrador:
```sql
INSERT INTO usuario (username, password)
VALUES ('admin', '1234');
```

---

# Credenciales de Prueba
| Usuario | Contraseña |
|----------|-------------|
| admin | 1234 |

---

# Ejecución del Backend
## 5. Ejecutar Spring Boot
1. Abrir la carpeta `backend` en Spring Tool Suite (STS)
2. Esperar que Maven descargue las dependencias
3. Ejecutar el proyecto Spring Boot

Backend disponible en:
```bash
http://localhost:8212
```

---

# Ejecución del Frontend
## 6. Ejecutar Angular

1. Abrir la carpeta `frontend` en Visual Studio Code
2. Abrir una terminal dentro del proyecto
3. Ejecutar:
```bash
npm install
```

Luego iniciar Angular con:
```bash
ng serve
```

Frontend disponible en:
```bash
http://localhost:4200
```

---

