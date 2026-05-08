package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MatriculaEntity;
import com.example.demo.interfaces.IMatriculaService;
import com.example.demo.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public MatriculaEntity guardar(MatriculaEntity matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public List<MatriculaEntity> obtenerTodas() {
        return (List<MatriculaEntity>) matriculaRepository.findAll();
    }

    @Override
    public Optional<MatriculaEntity> buscarPorId(Long id) {
        return matriculaRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        matriculaRepository.deleteById(id);
    }
}