package com.dawes.DiabetesLearning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dawes.DiabetesLearning.modelo.CursoVO;
import com.dawes.DiabetesLearning.modelo.LeccionVO;
import com.dawes.DiabetesLearning.servicios.ServicioCurso;
import com.dawes.DiabetesLearning.servicios.ServicioLeccion;

@TestMethodOrder(MethodOrderer.MethodName.class)

@SpringBootTest
public class TestLeccion {

	@Autowired
	private ServicioLeccion sl;
	
	@Autowired
	private ServicioCurso sc;

	@Test
	void test01Insertar() {
		CursoVO curso1 =sc.findById(1).get();
		
		LeccionVO l1 = new LeccionVO("¿QUÉ ES LA DIABETES?",
				"Introducción a la diabetes, tipos y su impacto en el cuerpo.",
				1, curso1, new ArrayList<>());
		sl.save(l1);
		LeccionVO l2 = new LeccionVO("FACTORES DE RIESGO Y SÍNTOMA",
				"Factores que aumentan riesgo y síntomas de la diabetes.",
				2, curso1, new ArrayList<>());
		sl.save(l2);
		LeccionVO l3 = new LeccionVO("PRUEBAS DE GLUCOSA EN SANGRE",
				"Tipos de pruebas y su importancia en el control.",
				3, curso1, new ArrayList<>());
		sl.save(l3);
		LeccionVO l4 = new LeccionVO("ALIMENTACION SALUDABLE",
				"Guía para una alimentación adecuada y control de glucosa.",
				4, curso1, new ArrayList<>());
		sl.save(l4);
		LeccionVO l5 = new LeccionVO("leccion5",
				"Leccion 5 curso 1.",
			5, curso1, new ArrayList<>());
				assertNotNull(sl.save(l5));

	}

	@Test
	public void test02eliminar() {
		LeccionVO l = sl.findById(5).get();
		sl.delete(l);
		assertTrue(sl.findById(5).isEmpty());
	}

	@Test
	public void test03modificar() {
		LeccionVO l = sl.findById(4).get();
		l.setTituloLeccion("ALIMENTACIÓN SALUDABLE");
		assertEquals("ALIMENTACIÓN SALUDABLE", sl.save(l).getTituloLeccion());
	}

	@Test
	public void test04findbyall() {
		assertEquals(4, sc.findAll().size());
	}

}
