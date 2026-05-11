package com.example.demo.dto;

import lombok.Data;

@Data
public class MatriculaRequest {

    private Long alumnoId;

    private Long cursoId;

    private Long sostenedorId;

    private Long apoderadoTitularId;

    private Long apoderadoSuplenteId;

    private Integer anioAcademico;

    private String fechaMatricula;

    private String estado;

}