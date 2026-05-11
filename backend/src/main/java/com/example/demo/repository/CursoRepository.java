package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CursoEntity;

public interface CursoRepository
        extends JpaRepository<CursoEntity, Long> {

}