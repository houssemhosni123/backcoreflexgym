package com.example.coreflexgym.Controllers;

import com.example.coreflexgym.Entities.Programme;
import com.example.coreflexgym.Services.IProgramme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/programmes")
public class ProgrammeController {

    private final IProgramme programmeService;

    @Autowired
    public ProgrammeController(IProgramme programmeService) {
        this.programmeService = programmeService;
    }

    // Create a new Programme
    @PostMapping
    public ResponseEntity<Programme> createProgramme(@RequestBody Programme programme) {
        Programme savedProgramme = programmeService.saveProgramme(programme);
        return new ResponseEntity<>(savedProgramme, HttpStatus.CREATED);
    }

    // Get all Programmes
    @GetMapping
    public ResponseEntity<List<Programme>> getAllProgrammes() {
        List<Programme> programmes = programmeService.getAllProgrammes();
        return new ResponseEntity<>(programmes, HttpStatus.OK);
    }

    // Get Programme by ID
    @GetMapping("/{id}")
    public ResponseEntity<Programme> getProgrammeById(@PathVariable Long id) {
        Optional<Programme> programme = programmeService.getProgrammeById(id);
        if (programme.isPresent()) {
            return new ResponseEntity<>(programme.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update a Programme
    @PutMapping("/{id}")
    public ResponseEntity<Programme> updateProgramme(@PathVariable Long id, @RequestBody Programme programme) {
        Programme updatedProgramme = programmeService.updateProgramme(id, programme);
        if (updatedProgramme != null) {
            return new ResponseEntity<>(updatedProgramme, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a Programme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramme(@PathVariable Long id) {
        programmeService.deleteProgramme(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
