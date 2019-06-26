public class Factura {

    private int precioFactura;
    public static int tarifa = 150;

    public Factura()
    {
        precioFactura = 0;
    }

    public Factura(int nElems)
    {
        precioFactura = nElems * tarifa;
    }
}
