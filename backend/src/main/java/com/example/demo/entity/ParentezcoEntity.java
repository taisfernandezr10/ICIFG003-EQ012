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
@Table(name = "parentezco") 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParentezcoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quitamos @NonNull y bajamos la restricción directo a PostgreSQL. 
    // Además, agregamos unique = true para que no se repitan los roles.
    @Column(name = "nombre_parentezco", nullable = false, unique = true)
    private String nombreParentezco; 
}