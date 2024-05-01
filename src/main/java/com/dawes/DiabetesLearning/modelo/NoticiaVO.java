package com.dawes.DiabetesLearning.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "noticias")
public class NoticiaVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idnoticia;
	@Column(unique = true)
	private String encabezado;
	private String asunto;
	private String multimedia;

	public NoticiaVO(String encabezado, String asunto, String multimedia) {
		super();
		this.encabezado = encabezado;
		this.asunto = asunto;
		this.multimedia = multimedia;
	}

}
