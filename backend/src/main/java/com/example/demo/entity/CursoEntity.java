package com.example.demo.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreCurso;

    @Column(nullable = false)
    private String nivel; 

    @Column(name = "anio_academico", nullable = false)
    private Integer anioAcademico; 

    // Relación bidireccional: Un curso tiene muchos alumnos (1 a N)
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<AlumnoEntity> alumnos;
}