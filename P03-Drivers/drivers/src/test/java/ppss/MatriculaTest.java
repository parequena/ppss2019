package ppss;

import org.junit.jupiter.api.*;

class MatriculaTest
{
    @Test
    public void C1_calculaTasaMatricula()
    {
        // Preparamos datos de entrada.
        int ed = 19;
        boolean fN = false, rep = true;
        // Guardamos resultado esperado.
        float rEsperado = 2000.0f;
        // Llamamos a la SUT.
        float rReal = Matricula.calculaTasaMatricula(ed, fN, rep);
        // Comparamos el resultado esperado con el original.
        Assertions.assertEquals(rEsperado, rReal);
    }

    @Test
    public void C2_calculaTasaMatricula()
    {
        // Preparamos datos de entrada.
        int ed = 68;
        boolean fN = false, rep = true;
        // Guardamos resultado esperado.
        float rEsperado = 250.0f;
        // Llamamos a la SUT.
        float rReal = Matricula.calculaTasaMatricula(ed, fN, rep);
        // Comparamos el resultado esperado con el original.
        Assertions.assertEquals(rEsperado, rReal);
    }

    @Test
    public void C3_calculaTasaMatricula()
    {
        // Preparamos datos de entrada.
        int ed = 19;
        boolean fN = true, rep = true;
        // Guardamos resultado esperado.
        float rEsperado = 250.0f;
        // Llamamos a la SUT.
        float rReal = Matricula.calculaTasaMatricula(ed, fN, rep);
        // Comparamos el resultado esperado con el original.
        Assertions.assertEquals(rEsperado, rReal);
    }

    @Test
    public void C4_calculaTasaMatricula()
    {
        // Preparamos datos de entrada.
        int ed = 19;
        boolean fN = false, rep = false;
        // Guardamos resultado esperado.
        float rEsperado = 500.0f;
        // Llamamos a la SUT.
        float rReal = Matricula.calculaTasaMatricula(ed, fN, rep);
        // Comparamos el resultado esperado con el original.
        Assertions.assertEquals(rEsperado, rReal);
    }

    @Test
    public void C5_calculaTasaMatricula()
    {
        // Preparamos datos de entrada.
        int ed = 61;
        boolean fN = false, rep = false;
        // Guardamos resultado esperado.
        float rEsperado = 400.0f;
        // Llamamos a la SUT.
        float rReal = Matricula.calculaTasaMatricula(ed, fN, rep);
        // Comparamos el resultado esperado con el original.
        Assertions.assertEquals(rEsperado, rReal);
    }

    /*
    *
    * PASAR TODOS ESTOS TESTS A PARAMETRIZADOS, PARA SABER COMO FUNCIONAN.
    *
    * */
}