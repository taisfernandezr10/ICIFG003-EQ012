package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PersonaFamiliaEntity;
import com.example.demo.interfaces.IPersonaFamiliaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/entities/persona-familia")
public class PersonaFamiliaController {

    @Autowired
    private IPersonaFamiliaService service;

    @GetMapping("")
    public ResponseEntity<?> readAsignaciones() {
        try {
            return ResponseEntity.ok(service.obtenerTodas());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PersonaFamiliaEntity asignacion){
        try {
            return ResponseEntity.ok(service.guardar(asignacion));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            service.eliminar(id);
            return ResponseEntity.ok("[]");
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }
}