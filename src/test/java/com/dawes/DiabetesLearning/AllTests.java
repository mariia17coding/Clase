package com.dawes.DiabetesLearning;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ TestRol.class, TestUsuario.class, TestCurso.class, TestLeccion.class, TestRecurso.class, TestComentario.class, TestInscripcion.class, TestNoticia.class })
public class AllTests {

}
