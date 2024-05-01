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
import com.dawes.DiabetesLearning.servicios.ServicioCurso;

@TestMethodOrder(MethodOrderer.MethodName.class)

@SpringBootTest
public class TestCurso {

	@Autowired
	private ServicioCurso sc;

	@Test
	void test01Insertar() {
		CursoVO c1 = new CursoVO("Diabetes Tipo 1: Fundamentos",
				"Este curso aborda los conceptos básicos de la Diabetes Tipo 1, incluyendo la fisiopatología, tratamiento y recomendaciones de estilo de vida.",
				"BÁSICO", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		sc.save(c1);
		CursoVO c2 = new CursoVO("Diabetes Tipo 2: Gestión",
				"Descubre estrategias efectivas para gestionar la Diabetes Tipo 2, incluyendo consejos nutricionales, manejo de medicamentos y actividades físicas recomendadas.",
				"BÁSICO", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		sc.save(c2);
		CursoVO c3 = new CursoVO("Nutrición y Carbohidratos",
				"Aprende sobre la nutrición específica para personas con diabetes, cómo contar carbohidratos y planificar comidas saludables.",
				"MEDIO", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		sc.save(c3);
		CursoVO c4 = new CursoVO("Uso del Glucagon",
				"Este curso se centra en el uso y administración del glucagón, un aspecto clave en el manejo de situaciones de hipoglucemia severa.",
				"DIFICULTAD ALTA", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		sc.save(c4);
		CursoVO c5 = new CursoVO("Curso 5", "Este curso se está vaco.", "MEDIO", new ArrayList<>(), new ArrayList<>(),
				new ArrayList<>());
		assertNotNull(sc.save(c5));

	}

	@Test
	public void test02eliminar() {
		CursoVO c = sc.findById(5).get();
		sc.delete(c);
		assertTrue(sc.findById(5).isEmpty());
	}

	@Test
	public void test03modificar() {
		CursoVO c = sc.findById(4).get();
		c.setTituloCurso("Uso del Glucagón");
		assertEquals("Uso del Glucagón", sc.save(c).getTituloCurso());
	}

	@Test
	public void test04findbyall() {
		assertEquals(4, sc.findAll().size());
	}

}
