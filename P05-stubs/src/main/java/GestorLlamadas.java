import java.util.Calendar;

public class GestorLlamadas {

    private static double tNoc = 10.5, tDiu = 20.8;

    public int getHoraActual()
    {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.HOUR);
    }

    public double calculaConsumo(int mins)
    {
        // Este codigo es testable.
        int h = getHoraActual();

        if(h < 8 || h > 20)
            return mins * tNoc;
        else
            return mins * tDiu;
    }

}
