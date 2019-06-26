public class BuscadorTestable implements IService
{
    public int ePendientes;

    // Creamos el testable para devolver la parte que queremos dentro del elemPendientes, ahora ahora que inyectarselo
    // a la SUT.

    @Override
    public int elemPendientes(Cliente cli)
    {
        return ePendientes;
    }
}
