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
@Table(name = "cursos")
public class CursoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcurso;
	@Column(unique = true)
	private String tituloCurso;
	private String descripcion;
	private String nivel;
	@OneToMany(mappedBy = "curso")
	private List<InscripcionVO> users;
	@OneToMany(mappedBy = "curso", cascade = CascadeType.REMOVE)
	private List<LeccionVO> lecciones;
	@OneToMany(mappedBy = "curso", cascade = CascadeType.REMOVE)
	private List<ComentarioVO> comentarios;

	public CursoVO(String tituloCurso, String descripcion, String nivel, List<InscripcionVO> users,
			List<LeccionVO> lecciones, List<ComentarioVO> comentarios) {
		super();
		this.tituloCurso = tituloCurso;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.users = users;
		this.lecciones = lecciones;
		this.comentarios = comentarios;
	}

}
