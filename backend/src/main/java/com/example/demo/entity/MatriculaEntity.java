package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "matricula")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatriculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long id;

    // Cambiamos "año" por "anio" para evitar problemas de caracteres (encoding) en PostgreSQL
    @Column(name = "anio_academico", nullable = false)
    private Integer anioAcademico;

    @Column(name = "fecha_matricula", nullable = false)
    private String fechaMatricula;

    @Column(name = "estado_matricula", nullable = false)
    private String estado;

    /* =========================================================
       RELACIONES DEL NEGOCIO (EL "CORE" DE LA MATRÍCULA)
       ========================================================= */

    // 1. ¿A qué alumno pertenece esta matrícula?
    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private AlumnoEntity alumno;

    // 2. ¿En qué curso se está matriculando?
    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private CursoEntity curso;

    // 3. Asignación de Roles de Responsabilidad (Apoderados)
    // El Sostenedor Económico es obligatorio según tu README
    @ManyToOne
    @JoinColumn(name = "id_sostenedor", nullable = false)
    private PersonaEntity sostenedor;

    @ManyToOne
    @JoinColumn(name = "id_apoderado_titular", nullable = false)
    private PersonaEntity apoderadoTitular;

    @ManyToOne
    @JoinColumn(name = "id_apoderado_suplente") // Puede ser opcional dependiendo de tus reglas
    private PersonaEntity apoderadoSuplente;
}