package com.example.coreflexgym.Controllers;

import com.example.coreflexgym.Entities.Exercice;
import com.example.coreflexgym.Services.IExercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exercices")
public class ExerciceController {

    private final IExercice exerciceService;

    @Autowired
    public ExerciceController(IExercice exerciceService) {
        this.exerciceService = exerciceService;
    }

    @PostMapping
    public ResponseEntity<Exercice> createExercice(@RequestBody Exercice exercice) {
        Exercice savedExercice = exerciceService.saveExercice(exercice);
        return new ResponseEntity<>(savedExercice, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Exercice>> getAllExercices() {
        List<Exercice> exercices = exerciceService.getAllExercices();
        return new ResponseEntity<>(exercices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercice> getExerciceById(@PathVariable Long id) {
        Optional<Exercice> exercice = exerciceService.getExerciceById(id);
        if (exercice.isPresent()) {
            return new ResponseEntity<>(exercice.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercice> updateExercice(@PathVariable Long id, @RequestBody Exercice exercice) {
        Exercice updatedExercice = exerciceService.updateExercice(id, exercice);
        if (updatedExercice != null) {
            return new ResponseEntity<>(updatedExercice, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercice(@PathVariable Long id) {
        exerciceService.deleteExercice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
