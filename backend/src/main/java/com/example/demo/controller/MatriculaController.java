package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.MatriculaRequest;
import com.example.demo.entity.AlumnoEntity;
import com.example.demo.entity.CursoEntity;
import com.example.demo.entity.PersonaEntity;
import com.example.demo.entity.MatriculaEntity;
import com.example.demo.interfaces.IMatriculaService;
import com.example.demo.repository.MatriculaRepository;

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
@RequestMapping("/api/v1/matriculas")
public class MatriculaController {

    @Autowired
    private IMatriculaService service;

    @Autowired
    private MatriculaRepository repository;

    @GetMapping("")
    public ResponseEntity<?> readMatriculas() {

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
            @RequestBody MatriculaRequest request) {

        try {

        	boolean existeMatricula =
        	        repository.existsByAlumnoId(
        	                request.getAlumnoId());

            if (existeMatricula) {

                return ResponseEntity
                        .status(400)
                        .body(
                          "El alumno ya posee una matrícula registrada");

            }

            AlumnoEntity alumno =
                    new AlumnoEntity();

            alumno.setId(
                    request.getAlumnoId());

            CursoEntity curso =
                    new CursoEntity();

            curso.setId(
                    request.getCursoId());

            PersonaEntity sostenedor =
                    new PersonaEntity();

            sostenedor.setId(
                    request.getSostenedorId());

            PersonaEntity titular =
                    new PersonaEntity();

            titular.setId(
                    request.getApoderadoTitularId());

            PersonaEntity suplente =
                    new PersonaEntity();

            suplente.setId(
                    request.getApoderadoSuplenteId());

            MatriculaEntity matricula =
                    MatriculaEntity.builder()

                    .alumno(alumno)

                    .curso(curso)

                    .sostenedor(sostenedor)

                    .apoderadoTitular(titular)

                    .apoderadoSuplente(suplente)

                    .anioAcademico(
                            request.getAnioAcademico())

                    .fechaMatricula(
                            request.getFechaMatricula())

                    .estado(
                            request.getEstado())

                    .build();

            return ResponseEntity.ok(
                    service.guardar(matricula));

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