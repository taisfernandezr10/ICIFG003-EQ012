package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CursoEntity;
import com.example.demo.interfaces.ICursoService;
import com.example.demo.repository.CursoRepository;

@Service
public class CursoServiceImpl
        implements ICursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public CursoEntity guardar(
            CursoEntity curso) {

        return cursoRepository.save(curso);

    }

    @Override
    public List<CursoEntity> obtenerTodos() {

        return cursoRepository.findAll();

    }

    @Override
    public Optional<CursoEntity> buscarPorId(
            Long id) {

        return cursoRepository.findById(id);

    }

    @Override
    public CursoEntity actualizar(
            Long id,
            CursoEntity cursoActualizado
    ) {

        CursoEntity curso = cursoRepository
                .findById(id)
                .orElseThrow();

        curso.setNombreCurso(
                cursoActualizado.getNombreCurso()
        );

        curso.setNivel(
                cursoActualizado.getNivel()
        );

        curso.setAnioAcademico(
                cursoActualizado.getAnioAcademico()
        );

        return cursoRepository.save(curso);

    }

    @Override
    public void eliminar(Long id) {

        cursoRepository.deleteById(id);

    }

}