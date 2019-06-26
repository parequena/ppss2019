// SRC/MAIN
public class Calendario{
    public int getHoraActual() { /*...*/ }
}

public class GestorLLamadas
{
    private static int tNoc = 10.5, tDiu = 20.8;

    public Calendario getCalendario()
    {
        Calendario c = new Calendario();
        return c;
    }

    public double calculaConsumo(int mins)
    {
        Calendario c = getCalendario();
        int h = c.getHoraActual();
        if (h < 8 || h > 20)
            return mins *tNoc;
        
        return mins * tDiu;
    }
}

public class Factory
{
    static Calendario hora = null;

    static Calendario create()
    {
        if(hora != null) return hora;
        
        return new Calendario();
    }

}



// SRC/TEST
@Test
public void calculaConsumoTest()
{

}