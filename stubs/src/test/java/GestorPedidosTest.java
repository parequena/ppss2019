import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorPedidosTest {

    @Test
    public void C1Test() throws FacturaException
    {
        // Praramos los datos de entrada.
        Cliente cli = new Cliente();

        // Resultado esperado
        Factura rEsperado = new Factura(1);

        // Insertamos el doble.
        BuscadorTestable busc = new BuscadorTestable();
        busc.ePendientes = 1;
        GestorPedidosTestable gp = new GestorPedidosTestable();
        gp.is = busc;

        // Llamamos al SUT y hacemos el assert.
        assertEquals(rEsperado, gp.generarFactura(cli));


        // Es posible que el codigo falle, puesto que creado las clases incompletas para poder seguir con el ejercicio.
    }
}
