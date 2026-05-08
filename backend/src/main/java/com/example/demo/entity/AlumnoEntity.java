package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "alumno")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AlumnoEntity extends PersonaEntity {
	
	@NonNull
    private Long idCurso; 
    private Integer cantidadAtrasos = 0;
    private Integer cantidadInasistencias = 0;
	

}
