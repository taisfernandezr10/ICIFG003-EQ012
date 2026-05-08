package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AlumnoEntity;
import com.example.demo.interfaces.IAlumnoService;
import com.example.demo.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public AlumnoEntity guardar(AlumnoEntity alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public List<AlumnoEntity> obtenerTodos() {
        return (List<AlumnoEntity>) alumnoRepository.findAll();
    }

    @Override
    public Optional<AlumnoEntity> buscarPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        alumnoRepository.deleteById(id);
    }
}