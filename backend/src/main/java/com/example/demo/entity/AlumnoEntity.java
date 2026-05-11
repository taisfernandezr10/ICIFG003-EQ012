package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoEntity extends PersonaEntity {
	
	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false) // <-- CORRECCIÓN: Sin espacios (curso_id)
	private CursoEntity curso;
	
	private Integer cantidadAtrasos = 0;
	private Integer cantidadInasistencias = 0;
}