package com.example.demo.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "familia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamiliaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Cambiamos @NonNull por la restricción directa en la base de datos
    @Column(name = "nombre_familia", nullable = false)
    private String nombreFamilia;

    @Column(nullable = false)
    private String direccion;

    // Relación bidireccional: Una familia tiene muchos registros en la tabla intermedia (integrantes)
    @OneToMany(mappedBy = "familia", cascade = CascadeType.ALL)
    private List<PersonaFamiliaEntity> integrantes;
}