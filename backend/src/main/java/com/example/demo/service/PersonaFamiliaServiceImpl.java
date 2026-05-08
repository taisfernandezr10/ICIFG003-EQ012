package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PersonaFamiliaEntity;
import com.example.demo.interfaces.IPersonaFamiliaService;
import com.example.demo.repository.PersonaFamiliaRepository;

@Service
public class PersonaFamiliaServiceImpl implements IPersonaFamiliaService {

    @Autowired
    private PersonaFamiliaRepository personaFamiliaRepository;

    @Override
    public PersonaFamiliaEntity guardar(PersonaFamiliaEntity asignacion) {
        return personaFamiliaRepository.save(asignacion);
    }

    @Override
    public List<PersonaFamiliaEntity> obtenerTodas() {
        return (List<PersonaFamiliaEntity>) personaFamiliaRepository.findAll();
    }

    @Override
    public Optional<PersonaFamiliaEntity> buscarPorId(Long id) {
        return personaFamiliaRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        personaFamiliaRepository.deleteById(id);
    }
}