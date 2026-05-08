package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.MatriculaEntity;

public interface IMatriculaService {
   
	MatriculaEntity guardar(MatriculaEntity matricula);
    List<MatriculaEntity> obtenerTodas();
    Optional<MatriculaEntity> buscarPorId(Long id);
    void eliminar(Long id);
}