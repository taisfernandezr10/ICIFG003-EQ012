package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "persona_familia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaFamiliaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* =========================================================
       RELACIONES JPA (LLAVES FORÁNEAS EN POSTGRESQL)
       ========================================================= */

    // 1. ¿Quién es la persona? (Reemplaza al String rutPersona)
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private PersonaEntity persona; 
    
    // 2. ¿A qué núcleo familiar pertenece? (Reemplaza al Long idFamilia)
    @ManyToOne
    @JoinColumn(name = "id_familia", nullable = false)
    private FamiliaEntity familia;

    // 3. ¿Qué rol cumple en esta familia? (Reemplaza al Long idParentezco)
    @ManyToOne
    @JoinColumn(name = "id_parentezco", nullable = false)
    private ParentezcoEntity parentezco; 
}