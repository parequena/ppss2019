
// Ejemplo de factoria local del temario de teoría, dependecias 1.s

public class GestorPedidos
{
    // Leer tras lineas 15-17.
    // Una vez hemos creado esta funcion, ahora podremos decir que nuestro codigo es testable.
    // Puesto, que segun el metodo de factoria local, podremos hacer un override de esta función.
    public IService getBuscador()
    {
        return new Buscador();
    }

    public Factura generarFactura(Cliente cli) throws FacturaException
    {
        Factura factura = new Factura();
        // IService bDatos = new Buscador();
        // Este codigo no es TESTABLE, ya que no tenemos forma de controlar que hace elementPendientes.
        // Para usar el método de factoria local, cambiaremos la llamada de la linea 9 por la siguiente,
        IService bDatos = getBuscador();

        int nElems = bDatos.elemPendientes(cli);
        if(nElems > 0)
        {
            int a = 1;
            // Se hara algo con la facutura, y ya está.
            factura = new Factura(nElems);
        }
        else
            throw new FacturaException("No hay nada por facturar");

        return factura;
    }
}
