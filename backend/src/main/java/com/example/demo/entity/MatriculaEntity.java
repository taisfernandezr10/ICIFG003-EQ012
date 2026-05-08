package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class MatriculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long id;

    @Column(name = "año_academico")
    private Integer anoAcademico;

    @Column(name = "fecha_matricula")
    private String fechaMatricula;

    @Column(name = "estado_matricula")
    private String estado;

    // Getters y Setters...
}