package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.AlumnoEntity;

public interface IAlumnoService {
    
	AlumnoEntity guardar(AlumnoEntity alumno);
    List<AlumnoEntity> obtenerTodos();
    Optional<AlumnoEntity> buscarPorId(Long id);
    void eliminar(Long id);
}