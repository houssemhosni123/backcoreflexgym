package com.example.coreflexgym.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "programme")
public class Programme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgramme;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private EProgram type;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "programme", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercice> exercices;
}
