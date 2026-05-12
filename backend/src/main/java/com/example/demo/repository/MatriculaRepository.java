package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MatriculaEntity;

@Repository
public interface MatriculaRepository
        extends CrudRepository<MatriculaEntity, Long> {

    boolean existsByAlumnoId(Long alumnoId);

}