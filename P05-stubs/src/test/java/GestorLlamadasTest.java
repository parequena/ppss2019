import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;


public class GestorLlamadasTest
{
    @Test
    public void calculaConsumoTest()
    {
        // Creamos el doble
        GestorLlamadasTestable g = new GestorLlamadasTestable();

        g.h = 15;
        int minutos = 10;
        double rEsperado = 208;

        Assertions.assertEquals(rEsperado, g.calculaConsumo(minutos));
    }

    /*
    * Se ha creado una versión parametrizada del test anterior, de la manera estándar.
    * */
    @ParameterizedTest
    @MethodSource("params")
    public void calculaConsumoTestParam(int hora, double rEsperado, int minutos)
    {
        // Creamos el doble
        GestorLlamadasTestable g = new GestorLlamadasTestable();
        g.h = hora;
        Assertions.assertEquals(rEsperado, g.calculaConsumo(minutos));
    }

    private static Stream<Arguments> params()
    {
        return Stream.of(Arguments.of(15, 208, 10),
                         Arguments.of(22, 105, 10));
    }
}
