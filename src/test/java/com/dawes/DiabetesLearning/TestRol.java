package com.dawes.DiabetesLearning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dawes.DiabetesLearning.modelo.RolVO;
import com.dawes.DiabetesLearning.servicios.ServicioRol;

@TestMethodOrder(MethodOrderer.MethodName.class)

@SpringBootTest
public class TestRol {

	@Autowired
	private ServicioRol sr;

	@Test
	void test01Insertar() {
		RolVO administrador = new RolVO("administrador", new ArrayList<>());
		sr.save(administrador);
		RolVO anonimo = new RolVO("anónimo", new ArrayList<>());
		sr.save(anonimo);
		RolVO registrado = new RolVO("registrado", new ArrayList<>());
		assertNotNull(sr.save(registrado));

	}

	@Test
	public void test02eliminar() {
		RolVO rol = sr.findById(2).get();
		sr.delete(rol);
		// vuelvo a buscarlo
		assertTrue(sr.findById(2).isEmpty());
	}

	@Test
	public void test03modificar() {
		RolVO rol = sr.findById(1).get();
		rol.setNombreRol("Administrador");
		assertEquals("Administrador", sr.save(rol).getNombreRol());
	}

	@Test
	public void test04findbyall() {
		assertEquals(2, sr.findAll().size());
	}

	// findbyNombrerol

	@Test
	public void test05findByNombreRol() {
		assertEquals("registrado", sr.findByNombreRol("registrado").get().getNombreRol());
	}

}
