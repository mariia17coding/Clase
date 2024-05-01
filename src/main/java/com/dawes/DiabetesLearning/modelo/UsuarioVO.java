package com.dawes.DiabetesLearning.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UsuarioVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iduser;
	private String nombreUser;
	@Column(unique = true)
	private String dniUser;
	private String correo;
	private String password;
	@ManyToOne
	@JoinColumn(name = "idrol")
	private RolVO rol;

//	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
//	private List<InscripcionVO> cursos;
//	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
//	private List<ComentarioVO> comentarios;

	public UsuarioVO(String nombreUser, String dniUser, String correo, String password, RolVO rol,
			List<InscripcionVO> cursos, List<ComentarioVO> comentarios) {
		super();
		this.nombreUser = nombreUser;
		this.dniUser = dniUser;
		this.correo = correo;
		this.password = password;
		this.rol = rol;
//		this.cursos = cursos;
//		this.comentarios = comentarios;
	}

//	public UsuarioVO(String nombreUser, String dniUser, String correo, String password) {
//		super();
//		this.nombreUser = nombreUser;
//		this.dniUser = dniUser;
//		this.correo = correo;
//		this.password = password;
//	}
	
	

}
