package com.example.coreflexgym.Repositories;

import com.example.coreflexgym.Entities.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciceRepository extends JpaRepository<Exercice, Long> {
}
