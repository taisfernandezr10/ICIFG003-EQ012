package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CursoEntity;

@Repository
public interface CursoRepository extends CrudRepository<CursoEntity, Long> {

}