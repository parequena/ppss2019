package ppss.ejercicio2;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MockEj2
{
    /*
    * 1. Preparamos datos de entrada.
    * 2. Creamos los mocks.
    * 3. Expectativas.
    * */
    @Test
    public void C1_Test()
    {
        float randEsperado = 0.007f;
        String entrada = "Premio", rEsperado = "Final Champions";

        ClienteWebService CWSmock = EasyMock.createMock(ClienteWebService.class);

        Premio pMock = EasyMock.partialMockBuilder(Premio.class).addMockedMethods("generaNumero").createMock();

        EasyMock.expect(CWSmock.obtenerPremio()).andReturn(entrada);
        EasyMock.expect(pMock.generaNumero()).andReturn(randEsperado);

        // Llamamos al cliente.
        pMock.cliente = CWSmock;

        EasyMock.replay(CWSmock, pMock);

        Assertions.assertEquals(rEsperado, pMock.compruebaPremio());

        EasyMock.verify(CWSmock, pMock);
    }
}
