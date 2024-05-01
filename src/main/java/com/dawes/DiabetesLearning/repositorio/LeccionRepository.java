package com.dawes.DiabetesLearning.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dawes.DiabetesLearning.modelo.LeccionVO;

public interface LeccionRepository extends JpaRepository<LeccionVO, Integer> {

}
