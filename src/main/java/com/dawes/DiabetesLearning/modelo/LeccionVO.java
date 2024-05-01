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
@Table(name = "lecciones")
public class LeccionVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idleccion;
	@Column(unique = true)
	private String tituloLeccion;
	private String contenido;
	private int orden;
	@ManyToOne
	@JoinColumn(name = "idcurso")
	private CursoVO curso;
	@OneToMany(mappedBy = "leccion", cascade = CascadeType.REMOVE)
	private List<RecursoVO> recursos;

	public LeccionVO(String tituloLeccion, String contenido, int orden, CursoVO curso, List<RecursoVO> recursos) {
		super();
		this.tituloLeccion = tituloLeccion;
		this.contenido = contenido;
		this.orden = orden;
		this.curso = curso;
		this.recursos = recursos;
	}

}
