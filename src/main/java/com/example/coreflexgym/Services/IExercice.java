package com.example.coreflexgym.Services;

import com.example.coreflexgym.Entities.Exercice;

import java.util.List;
import java.util.Optional;

public interface IExercice {
    Exercice saveExercice(Exercice exercice); // Create or update

    List<Exercice> getAllExercices(); // Retrieve all Exercices

    Optional<Exercice> getExerciceById(Long id); // Retrieve Exercice by ID

    Exercice updateExercice(Long id, Exercice exercice); // Update Exercice by ID

    void deleteExercice(Long id); // Delete Exercice by ID
}
