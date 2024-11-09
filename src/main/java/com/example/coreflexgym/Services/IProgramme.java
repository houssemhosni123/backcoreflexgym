package com.example.coreflexgym.Services;

import com.example.coreflexgym.Entities.Programme;

import java.util.List;
import java.util.Optional;

public interface IProgramme {
    Programme saveProgramme(Programme programme); // Create or update

    List<Programme> getAllProgrammes(); // Retrieve all Programmes

    Optional<Programme> getProgrammeById(Long id); // Retrieve Programme by ID

    Programme updateProgramme(Long id, Programme programme); // Update Programme by ID

    void deleteProgramme(Long id); // Delete Programme by ID
}
