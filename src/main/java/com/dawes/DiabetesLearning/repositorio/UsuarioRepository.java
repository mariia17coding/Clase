package com.dawes.DiabetesLearning.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dawes.DiabetesLearning.modelo.UsuarioVO;

public interface UsuarioRepository extends JpaRepository <UsuarioVO, Integer> {

}
