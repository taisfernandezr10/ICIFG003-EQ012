package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CursoEntity;
import com.example.demo.interfaces.ICursoService;

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
@RequestMapping("/api/v1/cursos")
public class CursoController {

    @Autowired
    private ICursoService service;

    @GetMapping("")
    public ResponseEntity<?> obtenerCursos() {

        try {

            return ResponseEntity.ok(
                    service.obtenerTodos());

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());

        }

    }

    @PostMapping("")
    public ResponseEntity<?> guardarCurso(
            @RequestBody CursoEntity curso
    ) {

        try {

            return ResponseEntity.ok(
                    service.guardar(curso)
            );

        } catch (Exception e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());

        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCurso(
            @PathVariable Long id,
            @RequestBody CursoEntity curso
    ) {

        try {

            return ResponseEntity.ok(
                    service.actualizar(id, curso)
            );

        } catch (Exception e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(
            @PathVariable Long id
    ) {

        try {

            service.eliminar(id);

            return ResponseEntity.ok(
                    "Curso eliminado"
            );

        } catch (Exception e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());

        }

    }

}