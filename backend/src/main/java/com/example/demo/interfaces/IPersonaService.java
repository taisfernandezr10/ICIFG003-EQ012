package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.PersonaEntity;

public interface IPersonaService {
    PersonaEntity guardar(PersonaEntity persona);
    List<PersonaEntity> obtenerTodas();
    Optional<PersonaEntity> buscarPorId(Long id);
    void eliminar(Long id);
}