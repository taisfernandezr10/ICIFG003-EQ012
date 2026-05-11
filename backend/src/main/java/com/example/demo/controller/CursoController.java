package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

            return ResponseEntity
                    .status(404)
                    .body(e);

        }

    }

}