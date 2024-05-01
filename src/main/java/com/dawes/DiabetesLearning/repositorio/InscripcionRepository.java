package com.dawes.DiabetesLearning.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dawes.DiabetesLearning.modelo.InscripcionVO;

public interface InscripcionRepository extends JpaRepository<InscripcionVO, Integer> {

}
