package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.UsuarioEntity;
import com.example.demo.entity.CursoEntity;

import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.CursoRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(
            UsuarioRepository repository,
            CursoRepository cursoRepository
    ) {

        return args -> {

            // USUARIO ADMIN

            if (
                repository
                    .findByUsername("admin")
                    .isEmpty()
            ) {

                UsuarioEntity admin =
                    UsuarioEntity.builder()
                        .username("admin")
                        .password("1234")
                        .nombreCompleto(
                            "Administrador Demo"
                        )
                        .build();

                repository.save(admin);

                System.out.println(
                    "Usuario admin creado"
                );

            }

            // CURSOS DEMO

            if (
                cursoRepository.count() == 0
            ) {

                CursoEntity curso1 =
                    new CursoEntity();

                curso1.setNombreCurso("1ero");

                curso1.setNivel("Básico");

                curso1.setAnioAcademico(2026);

                CursoEntity curso2 =
                    new CursoEntity();

                curso2.setNombreCurso("2do");

                curso2.setNivel("Básico");

                curso2.setAnioAcademico(2026);

                CursoEntity curso3 =
                    new CursoEntity();

                curso3.setNombreCurso("3ero");

                curso3.setNivel("Medio");

                curso3.setAnioAcademico(2026);

                cursoRepository.save(curso1);

                cursoRepository.save(curso2);

                cursoRepository.save(curso3);

                System.out.println(
                    "Cursos demo creados"
                );

            }

        };

    }

}