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
@Table(name = "comentarios", uniqueConstraints = { @UniqueConstraint(columnNames = { "idcurso", "iduser" }) })

public class ComentarioVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcomentario;
	private String contenido;
	private LocalDate fechaPublicacion;
	@ManyToOne
	@JoinColumn(name = "idcurso")
	private CursoVO curso;
	@ManyToOne
	@JoinColumn(name = "iduser")
	private UsuarioVO user;

	public ComentarioVO(String contenido, LocalDate fechaPublicacion, CursoVO curso, UsuarioVO user) {
		super();
		this.contenido = contenido;
		this.fechaPublicacion = fechaPublicacion;
		this.curso = curso;
		this.user = user;
	}

}
