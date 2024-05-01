package com.dawes.DiabetesLearning.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dawes.DiabetesLearning.modelo.RolVO;

public interface RolRepository extends JpaRepository<RolVO, Integer> {

	Optional<RolVO> findByNombreRol(String nombreRol);
}