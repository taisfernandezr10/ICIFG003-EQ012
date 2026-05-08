package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ParentezcoEntity;

@Repository
public interface ParentezcoRepository extends CrudRepository<ParentezcoEntity, Long> {

}