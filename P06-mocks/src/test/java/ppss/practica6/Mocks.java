package ppss.practica6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Mocks {

    @Test
    public void mockTest()
    {
        int hora = 10;
        int min = 22;
        double rEsperado = 457.6;
        // Creamos los mocks.
        GestorLlamadas mockGest = EasyMock.partialMockBuilder(GestorLlamadas.class)
                .addMockedMethod("getCalendario").createMock();

        Calendario mockCalendario = EasyMock.createMock(Calendario.class);

        // Programar las expectativas.
        EasyMock.expect(mockCalendario.getHoraActual()).andReturn(hora);
        EasyMock.expect(mockGest.getCalendario().andReturn(mockCalendario));

        // Altiva los mocks.
        EasyMock.replay(mockCalendario, mockGest);

        // assert
        Assertions.assertEquals(rEsperado, mockGest.calculaConsumo(min));

        // check del comportamiento.
        // Verifica que se ha llamado a la SUT
        EasyMock.verify(mockCalendario, mockGest);
    }

    /*
    * partialMockBuilder    : Cuando vas a llamar métodos de la propia clase.
    * createMock            : No controla el comportamiento.
    * strictMock            : Controla cada una de las iteraciones, controlas las entradas, las salidas.
    *                       : Chequea el orden.
    * */

}
