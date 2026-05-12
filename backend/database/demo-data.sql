-- =========================================
-- DEMO DATA - SISTEMA INSPECTORIA ESCOLAR
-- EQ012
-- =========================================

-- =========================================
-- CURSOS
-- =========================================

INSERT INTO curso(
    id,
    anio_academico,
    nivel,
    nombre_curso
)
VALUES
(1, 2026, 'Basica', '1° Basico A'),

(2, 2026, 'Basica', '2° Basico A'),

(3, 2026, 'Basica', '3° Basico A'),

(4, 2026, 'Media', '1° Medio A'),

(5, 2026, 'Media', '2° Medio A');

-- =========================================
-- PERSONAS
-- =========================================

INSERT INTO persona(
    id,
    apellido_materno,
    apellido_paterno,
    direccion,
    nombre,
    rut
)
VALUES

(1,
'Perez',
'Gonzalez',
'Los Aromos 123',
'Matias',
'11.111.111-1'),

(2,
'Muñoz',
'Fernandez',
'Las Palmas 456',
'Camila',
'22.222.222-2'),

(3,
'Rojas',
'Diaz',
'Av Central 789',
'Ignacio',
'33.333.333-3'),

(4,
'Lopez',
'Morales',
'Pasaje Norte 321',
'Valentina',
'44.444.444-4'),

(5,
'Soto',
'Herrera',
'Villa Sur 741',
'Benjamin',
'55.555.555-5');

-- =========================================
-- ALUMNOS
-- =========================================

INSERT INTO alumno(
    cantidad_atrasos,
    cantidad_inasistencias,
    id,
    curso_id
)
VALUES

(0, 0, 1, 1),

(2, 1, 2, 2);

-- =========================================
-- USUARIOS
-- =========================================

INSERT INTO usuario(
    id,
    nombre_completo,
    password,
    username
)
VALUES

(1,
'Administrador Sistema',
'1234',
'admin');

-- =========================================
-- MATRICULAS
-- =========================================

INSERT INTO matricula(
    id_matricula,
    anio_academico,
    estado_matricula,
    fecha_matricula,
    id_alumno,
    id_apoderado_suplente,
    id_apoderado_titular,
    id_curso,
    id_sostenedor
)
VALUES

(
1,
2026,
'ACTIVA',
'2026-05-11',
1,
4,
3,
1,
5
),

(
2,
2026,
'ACTIVA',
'2026-05-11',
2,
5,
4,
2,
3
);

-- =========================================
-- FIN DEMO DATA
-- =========================================