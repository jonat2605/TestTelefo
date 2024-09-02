package com.nttdata.testTelefonica.repository;

import com.nttdata.testTelefonica.model.entities.PruebaEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaEstudianteRepository extends JpaRepository<PruebaEstudiante, Integer> {}
