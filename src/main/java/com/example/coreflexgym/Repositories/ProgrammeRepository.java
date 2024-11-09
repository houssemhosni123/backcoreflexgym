package com.example.coreflexgym.Repositories;

import com.example.coreflexgym.Entities.Programme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammeRepository extends JpaRepository<Programme, Long> {
}
