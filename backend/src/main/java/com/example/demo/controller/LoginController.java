package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        UsuarioEntity usuario = repository
                .findByUsername(request.getUsername())
                .orElse(null);

        if (usuario == null) {
            return ResponseEntity
                    .status(401)
                    .body("Usuario no encontrado");
        }

        if (!usuario.getPassword().equals(request.getPassword())) {
            return ResponseEntity
                    .status(401)
                    .body("Contraseña incorrecta");
        }

        return ResponseEntity.ok("Login exitoso");
    }
}