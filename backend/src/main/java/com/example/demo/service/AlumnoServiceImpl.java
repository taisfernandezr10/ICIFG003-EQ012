package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AlumnoEntity;
import com.example.demo.interfaces.IAlumnoService;
import com.example.demo.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl
        implements IAlumnoService {

    @Autowired
    private AlumnoRepository repository;

    @Override
    public List<AlumnoEntity> obtenerTodos() {

        List<AlumnoEntity> alumnos =
                new ArrayList<>();

        repository.findAll()
                .forEach(alumnos::add);

        return alumnos;

    }

}