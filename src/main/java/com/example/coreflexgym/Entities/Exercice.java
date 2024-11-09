package com.example.coreflexgym.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exercice")
public class Exercice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExercie;

    @Column(name = "nom", nullable = false)
    private String nom; // Name of the exercise

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ExerciseType type; // Type of the exercise (using Enum)

    @Column(name = "description")
    private String description; // Description of the exercise

    @ManyToOne
    @JoinColumn(name = "programme_id", nullable = false)
    private Programme programme;
}