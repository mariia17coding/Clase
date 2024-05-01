package com.dawes.DiabetesLearning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dawes.DiabetesLearning.modelo.LeccionVO;
import com.dawes.DiabetesLearning.modelo.RecursoVO;
import com.dawes.DiabetesLearning.servicios.ServicioLeccion;
import com.dawes.DiabetesLearning.servicios.ServicioRecurso;

@TestMethodOrder(MethodOrderer.MethodName.class)

@SpringBootTest
public class TestRecurso {

	@Autowired
	private ServicioRecurso sr;

	@Autowired
	private ServicioLeccion sl;

	@Test
	void test01Insertar() {
		LeccionVO l1 = sl.findById(1).get();
		LeccionVO l2 = sl.findById(2).get();
		LeccionVO l3 = sl.findById(3).get();
		LeccionVO l4 = sl.findById(4).get();

		RecursoVO r1 = new RecursoVO("Diabetes Info PDF", "https://ejemplo.com/diabetes_info.pdf", l1);
		sr.save(r1);
		RecursoVO r2 = new RecursoVO("Factores de Riesgo Imagen", "https://ejemplo.com/factores_riesgo.jpg", l2);
		sr.save(r2);
		RecursoVO r3 = new RecursoVO("Pruebas de Glucosa Documento", "https://ejemplo.com/pruebas_glucosa.docx", l3);
		sr.save(r3);
		RecursoVO r4 = new RecursoVO("Alimentación Video", "https://ejemplo.com/alimentacion_video.mp4", l4);
		sr.save(r4);
		RecursoVO r5 = new RecursoVO("Ejercicio PDF", "https://ejemplo.com/ejercicio_diabetes.pdf", l4);
		sr.save(r5);
		RecursoVO r6 = new RecursoVO("Tratamiento Glucosa Imagen", "https://ejemplo.com/tratamiento_medicamentos.png", l3);
		assertNotNull(sr.save(r6));

	}

	@Test
	public void test02eliminar() {
		RecursoVO r = sr.findById(5).get();
		sr.delete(r);
		assertTrue(sr.findById(5).isEmpty());
	}

	@Test
	public void test03modificar() {
		RecursoVO r= sr.findById(4).get();
		r.setNombreRecurso("Alimentación Saludable Video");
		assertEquals("Alimentación Saludable Video", sr.save(r).getNombreRecurso());
	}

	@Test
	public void test04findbyall() {
		assertEquals(5, sr.findAll().size());
	}

}
