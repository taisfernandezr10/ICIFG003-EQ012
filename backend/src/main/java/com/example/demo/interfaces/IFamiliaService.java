package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.FamiliaEntity;

public interface IFamiliaService {
    
	FamiliaEntity guardar(FamiliaEntity familia);
    List<FamiliaEntity> obtenerTodas();
    Optional<FamiliaEntity> buscarPorId(Long id);
    void eliminar(Long id);
}