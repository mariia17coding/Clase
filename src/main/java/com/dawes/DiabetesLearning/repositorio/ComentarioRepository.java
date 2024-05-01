package com.dawes.DiabetesLearning.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dawes.DiabetesLearning.modelo.ComentarioVO;

public interface ComentarioRepository extends JpaRepository<ComentarioVO, Integer> {

}
