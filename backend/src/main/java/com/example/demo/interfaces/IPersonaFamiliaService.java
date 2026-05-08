package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.PersonaFamiliaEntity;
public interface IPersonaFamiliaService {
	
	PersonaFamiliaEntity guardar(PersonaFamiliaEntity asignacion);
    List<PersonaFamiliaEntity> obtenerTodas();
    Optional<PersonaFamiliaEntity> buscarPorId(Long id);
    void eliminar(Long id);
}
