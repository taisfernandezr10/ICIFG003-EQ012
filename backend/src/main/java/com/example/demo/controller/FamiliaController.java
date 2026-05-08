package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.FamiliaEntity;
import com.example.demo.interfaces.IFamiliaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/entities/familia")
public class FamiliaController {

    @Autowired
    private IFamiliaService service;

    @GetMapping("")
    public ResponseEntity<?> readFamilias() {
        try {
            return ResponseEntity.ok(service.obtenerTodas());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody FamiliaEntity familia){
        try {
            return ResponseEntity.ok(service.guardar(familia));
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