package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PersonaEntity;
import com.example.demo.interfaces.IPersonaService;
import com.example.demo.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public PersonaEntity guardar(PersonaEntity persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<PersonaEntity> obtenerTodas() {
        return (List<PersonaEntity>) personaRepository.findAll();
    }

    @Override
    public Optional<PersonaEntity> buscarPorId(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        personaRepository.deleteById(id);
    }
}