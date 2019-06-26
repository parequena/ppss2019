public class GestorPedidosTestable extends GestorPedidos
{
    public IService is;

    // Aqui, podremos insertarle el buscador a la SUT.
    @Override
    public IService getBuscador()
    {
        return is;
    }
}
