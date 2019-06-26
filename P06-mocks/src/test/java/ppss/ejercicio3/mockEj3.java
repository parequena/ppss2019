package ppss.ejercicio3;

import org.easymock.EasyMock;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class mockEj3
{
    @Test
    public void C1s()
    {
        final String login = "XXXX", pass = "XXXX", socio = "pepe", pEsperado = "Error de permisos";
        boolean ADB = true;
        final String[] isbns = new String[]{"2222"};

        final Reserva rMOck = EasyMock.partialMockBuilder(Reserva.class).addMockedMethods("compruebaPermisos", "getFactoriaBO").createMock();
        FactoriaBOs fMock = EasyMock.createMock(FactoriaBOs.class);

        IOperacionBO oMOck = EasyMock.createStrictMock(IOperacionBO.class);

        EasyMock.expect(rMOck.compruebaPermisos(login, pass, null)).andReturn(false);

        EasyMock.replay(rMOck);

        ReservaException ex = assertThrows(ReservaException.class, ()->rMOck.realizaReserva(login, pass, socio, isbns));
        assertEquals(pEsperado, ex.getMessage());
        EasyMock.verify(rMOck);
    }

    @Test
    public void C2_test() throws IsbnInvalidoException, ReservaException {
        //Preparamos los datos
        String login = "ppss", pass = "ppss", socio = "pepe";
        String[] isbns = new String[]{"2222" ,"3333"};
        //Crear los mocks
        Reserva rMock =  EasyMock.partialMockBuilder(Reserva.class).addMockedMethods("getFactoriaBOs" , "compruebaPermisos").createMock();
        FactoriaBOs fMock = EasyMock.createMock(FactoriaBOs.class);
        IOperacionBO iMock = EasyMock.createStrictMock(IOperacionBO.class);
        //Expectativas
        EasyMock.expect(rMock.compruebaPermisos((login,pass,socio, isbns)));
        EasyMock.expect(rMock.getFactoriaBOs()).andReturn(fMock);
        EasyMock.expect(fMock.getOperacionBO()).andReturn(iMock);
        //Activamos los mock
        EasyMock.replay(rMock,fMock,iMock);
        for(String is :isbns){
            iMock.operacionReserva(socio,is);
        }
        rMock.realizaReserva(login,pass,socio,isbns);
        assertTrue(true);
        EasyMock.verify(rMock,fMock,iMock);
    }
}