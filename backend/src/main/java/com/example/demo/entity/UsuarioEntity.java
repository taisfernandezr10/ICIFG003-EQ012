package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quitamos @NonNull y bajamos la restricción directo a la base de datos.
    // unique = true es vital aquí para que no existan dos usuarios con el mismo username.
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    // Forzamos el nombre con guion bajo para evitar conflictos de camelCase en PostgreSQL
    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;
}