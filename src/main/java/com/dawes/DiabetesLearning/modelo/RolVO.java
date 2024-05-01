package com.dawes.DiabetesLearning.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class RolVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrol;
	@Column(unique = true)
	private String nombreRol;
//	@OneToMany(mappedBy = "rol", cascade = CascadeType.REMOVE)
//	private List<UsuarioVO> usuarios;

	public RolVO(String nombreRol, List<UsuarioVO> usuarios) {
		super();
		this.nombreRol = nombreRol;
//		this.usuarios = usuarios;
	}

}
