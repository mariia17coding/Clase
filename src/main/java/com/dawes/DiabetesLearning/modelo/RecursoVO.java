package com.dawes.DiabetesLearning.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "recursos")
public class RecursoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrecurso;
	@Column(unique = true)
	private String nombreRecurso;
	private String url;
	@ManyToOne
	@JoinColumn(name = "idleccion")
	private LeccionVO leccion;

	public RecursoVO(String nombreRecurso, String url, LeccionVO leccion) {
		super();
		this.nombreRecurso = nombreRecurso;
		this.url = url;
		this.leccion = leccion;
	}

}
