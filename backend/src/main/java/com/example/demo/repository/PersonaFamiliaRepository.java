package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonaFamiliaEntity;

@Repository
public interface PersonaFamiliaRepository extends CrudRepository<PersonaFamiliaEntity, Long> {

}