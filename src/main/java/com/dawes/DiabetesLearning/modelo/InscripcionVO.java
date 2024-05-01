package com.dawes.DiabetesLearning.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "inscripciones", uniqueConstraints = { @UniqueConstraint(columnNames = { "iduser", "idcurso" }) })
public class InscripcionVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idinscripcion;
	private LocalDate fechaInscripcion;
	@ManyToOne
	@JoinColumn(name = "iduser")
	private UsuarioVO user;
	@ManyToOne
	@JoinColumn(name = "idcurso")
	private CursoVO curso;

	private boolean tieneDiploma;

	public InscripcionVO(LocalDate fechaInscripcion, UsuarioVO user, CursoVO curso, boolean tieneDiploma) {
		super();
		this.fechaInscripcion = fechaInscripcion;
		this.user = user;
		this.curso = curso;
		this.tieneDiploma = tieneDiploma;
	}

}
