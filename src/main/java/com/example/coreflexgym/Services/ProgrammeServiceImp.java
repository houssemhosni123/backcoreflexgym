package com.example.coreflexgym.Services;


import com.example.coreflexgym.Entities.Programme;
import com.example.coreflexgym.Repositories.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammeServiceImp implements IProgramme {

    private final ProgrammeRepository programmeRepository;

    @Autowired
    public ProgrammeServiceImp(ProgrammeRepository programmeRepository) {
        this.programmeRepository = programmeRepository;
    }

    @Override
    public Programme saveProgramme(Programme programme) {
        return programmeRepository.save(programme);
    }

    @Override
    public List<Programme> getAllProgrammes() {
        return programmeRepository.findAll();
    }

    @Override
    public Optional<Programme> getProgrammeById(Long id) {
        return programmeRepository.findById(id);
    }

    @Override
    public Programme updateProgramme(Long id, Programme programme) {
        Optional<Programme> existingProgramme = programmeRepository.findById(id);
        if (existingProgramme.isPresent()) {
            Programme updatedProgramme = existingProgramme.get();
            updatedProgramme.setType(programme.getType());
            updatedProgramme.setTitre(programme.getTitre());
            updatedProgramme.setDescription(programme.getDescription());
            updatedProgramme.setExerciseType(programme.getExerciseType());

            return programmeRepository.save(updatedProgramme);
        }
        return null;
    }

    @Override
    public void deleteProgramme(Long id) {
        programmeRepository.deleteById(id);
    }
}
