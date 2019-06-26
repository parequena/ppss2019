package ppss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatriculaTest {
    int edad;
    boolean familiaNumerosa;
    boolean repetidor;
    float resultadoReal, resultadoEsperado;
    Matricula mat= new Matricula();

    @Test
    public void testCalculaTasaMatricula() {
        edad = 23;
        familiaNumerosa = true;
        repetidor = true;
        resultadoEsperado = 250.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        //el tercer parámetro del método Assert.assertEquals es necesario si estamos comparando "floats"
        //en este caso el método devuelve cierto si:
        //resultadoEsperado = resultadoReal +/- 0.002
        assertEquals(resultadoEsperado, resultadoReal,0.002f);
    }

    @Test
    public void C1Test()
    {
        edad = 23; familiaNumerosa=true; repetidor=true;
        resultadoEsperado = 500.0f;
        resultadoReal = mat.calculaTasaMatricula(edad, familiaNumerosa, repetidor);
        assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }

    @Test
    public void C3Test()
    {
        edad=23; familiaNumerosa=false; repetidor=false;
        resultadoEsperado = 500.0f;
        resultadoReal = mat.calculaTasaMatricula(edad, familiaNumerosa, repetidor);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void C5Test()
    {
        edad=30; familiaNumerosa=false; repetidor=false;
        resultadoEsperado = 500.0f;
        resultadoReal = mat.calculaTasaMatricula(edad, familiaNumerosa, repetidor);
        assertEquals(resultadoEsperado, resultadoReal);
    }
}
