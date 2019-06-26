// src/test
@Test
public void testC1()
{
	int rEsperado = 0;
	int rReal = metodoSUT(); // La sut puede lanzar excepción.
	Assertions.assertEquals(rEsperado, rReal);

	/*
		En este caso, dará passed si el rReal == 0, si no, dará failed.
		---
		Si por el contrario, queremos comprobar la excepción, debemos hacer lo siguiente:
	*/
	String rEsperado = "EXCEPCION!";
	Throwable e = Assertions.assertThows(miException.class, ()->metodoSUT());
	// Si no salta la excepción que indicamos, dará un error.
	Assertions.assertEquals(rEsperado, e.getMessage());
}

