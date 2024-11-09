package com.example.coreflexgym.Services;

import com.example.coreflexgym.Entities.Exercice;
import com.example.coreflexgym.Repositories.ExerciceRepository;
import com.example.coreflexgym.Services.IExercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciceServiceImpl implements IExercice {

    private final ExerciceRepository exerciceRepository;

    @Autowired
    public ExerciceServiceImpl(ExerciceRepository exerciceRepository) {
        this.exerciceRepository = exerciceRepository;
    }

    @Override
    public Exercice saveExercice(Exercice exercice) {
        // Save or update the Exercice entity and return the saved entity
        return exerciceRepository.save(exercice);
    }

    @Override
    public List<Exercice> getAllExercices() {
        // Retrieve all Exercice entities from the repository
        return exerciceRepository.findAll();
    }

    @Override
    public Optional<Exercice> getExerciceById(Long id) {
        // Retrieve Exercice by ID from the repository
        return exerciceRepository.findById(id);
    }

    @Override
    public Exercice updateExercice(Long id, Exercice exercice) {
        // Find the Exercice by ID and update if present
        Optional<Exercice> existingExercice = exerciceRepository.findById(id);
        if (existingExercice.isPresent()) {
            Exercice updatedExercice = existingExercice.get();
            updatedExercice.setNom(exercice.getNom());
            updatedExercice.setType(exercice.getType());
            updatedExercice.setDescription(exercice.getDescription());
           updatedExercice.setProgramme(exercice.getProgramme()); // Update related program
            return exerciceRepository.save(updatedExercice); // Save and return the updated entity
        }
        return null; // Return null if the Exercice is not found
    }

    @Override
    public void deleteExercice(Long id) {
        // Delete the Exercice by ID
        exerciceRepository.deleteById(id);
    }
}