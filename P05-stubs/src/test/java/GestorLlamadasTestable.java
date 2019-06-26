import static org.junit.jupiter.api.Assertions.*;

class GestorLlamadasTestable extends GestorLlamadas
{
    public int h;

    @Override
    public int getHoraActual()
    {
        return h;
    }
}