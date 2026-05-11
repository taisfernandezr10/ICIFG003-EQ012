package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PersonaEntity;
import com.example.demo.interfaces.IPersonaService;

@RestController
@CrossOrigin(
    origins = "http://localhost:4200",
    allowedHeaders = "*",
    methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS
    }
)
@RequestMapping("/api/v1/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping("")
    public ResponseEntity<?> readPersonas() {

        try {

            return ResponseEntity.ok(
                    service.obtenerTodas());

        } catch (Exception e) {

            return ResponseEntity
                    .status(404)
                    .body(e);

        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(
            @PathVariable Long id) {

        try {

            return ResponseEntity.ok(
                    service.buscarPorId(id));

        } catch (Exception e) {

            return ResponseEntity
                    .status(404)
                    .body(e);

        }

    }

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody PersonaEntity persona) {

        try {

            return ResponseEntity.ok(
                    service.guardar(persona));

        } catch (Exception e) {

            return ResponseEntity
                    .status(400)
                    .body(e);

        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody PersonaEntity persona) {

        try {

            Optional<PersonaEntity> optionalPersona =
                    service.buscarPorId(id);

            if (optionalPersona.isEmpty()) {

                return ResponseEntity
                        .status(404)
                        .body("Persona no encontrada");

            }

            PersonaEntity personaActual =
                    optionalPersona.get();

            personaActual.setRut(
                    persona.getRut());

            personaActual.setNombre(
                    persona.getNombre());

            personaActual.setApellidoPaterno(
                    persona.getApellidoPaterno());

            personaActual.setApellidoMaterno(
                    persona.getApellidoMaterno());

            personaActual.setDireccion(
                    persona.getDireccion());

            return ResponseEntity.ok(
                    service.guardar(personaActual));

        } catch (Exception e) {

            return ResponseEntity
                    .status(400)
                    .body(e);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id) {

        try {

            service.eliminar(id);

            return ResponseEntity.ok("[]");

        } catch (Exception e) {

            return ResponseEntity
                    .status(404)
                    .body(e);

        }

    }

}