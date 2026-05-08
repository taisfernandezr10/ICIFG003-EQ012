package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FamiliaEntity;
import com.example.demo.interfaces.IFamiliaService;
import com.example.demo.repository.FamiliaRepository;

@Service
public class FamiliaServiceImpl implements IFamiliaService {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Override
    public FamiliaEntity guardar(FamiliaEntity familia) {
        return familiaRepository.save(familia);
    }

    @Override
    public List<FamiliaEntity> obtenerTodas() {
        return (List<FamiliaEntity>) familiaRepository.findAll();
    }

    @Override
    public Optional<FamiliaEntity> buscarPorId(Long id) {
        return familiaRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        familiaRepository.deleteById(id);
    }
}