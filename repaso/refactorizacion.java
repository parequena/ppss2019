public class Calendario
{

}

public class Ticket
{

}

public class AlquilaCoches
{
    protected Calendario cal = new Calendario();

    // Por el metodo de Factoria local, creariamos el getServicio.
    public IService getServicio()
    {
        return new Servicio();
    }

    public Ticket calculaPrecio(TipoCoche tipo, LocalDate init, int nDias) throws MensajeException
    {
        Ticket tick = new Ticket();
        float precioDia, precioTotal = 0.0f;
        float porcentaje = 0.25f;

        String observaciones = "";
        // IService servicio = new Servicio();
        // Esa linea hace que el codigo no sea testeable. La pasamos a:
        IService servicio = getServicio();
        precioDia = servicio.consultaPrecio(tipo);

        for(int i = 0; i < nDias; i++)
        {
            LocalDate otroDia = init.plusDays(i);


            try
            {
                if(calendario.es_festivo(otroDia))
                    precioTotal += (1 + porcentaje) * precioDia;
                else
                    precioTotal += (1 - porcentaje) * precioDia;
            }
            catch (CalendarioException ex)
            {
                observaciones += "dia =" + otroDia + " no contablizado ;";
            }
        }

        if(observaciones.isEmpty())
            tick.setObservaciones(null);
        else
            throw new MensajeException(observaciones);

        tick.setPrecio_final(precioTotal);
        return tick;
    }
}

public class CalendarioTestable extends Calendario
{
    public boolean festivo;

    @Override
    boolean es_festivo(LocalDate dia)
    {
        return festivo;
    }
}

public class ServicioTestable implements IServicio
{
    // Esta clase va al path: src/test
    // Lo hacemos publico para evitarnos hacer un setter.
    public float precio;

    @Override
    public float consultaPrecio(TipoCoche tipo)
    {
        return precio;
    }
}

public class AlquilaCochesTestable extends AlquilaCoches
{
    // Esta clase va al path: src/test
    // Lo hacemos publico para evitarnos hacer un setter.
    public IService is;

    @Override
    public IService getServicio()
    {
        return is;
    }

    // Al ser de tipo protected, con herencia, podremos acceder a el.
    void setCalendario(Calendario cal)
    {
        this.cal = cal;
    }    
}

public class AlquilaCochesTest
{
    @Test
    public void C1Test()
    {
        // Creamos el doble de Servicio.
        ServicioTestable st = new ServicioTestable();
        st.precio = 0.0f;

        CalendarioTestable cal = new CalendarioTestable();
        cal.festivo = false;

        // Creamos el doble de AlquilaCoches
        AlquilaCochesTestable at = new AlquilaCochesTestable();
        at.is = st;
        at.setCalendario(cal);

        // Creamos el resultado esperado.
        Ticket rEsperado = new Ticket();

        // Llamamos a la SUT.
        Ticket rReal = at.calculaPrecio(null, null, 0);

        // Comprobamos que sean iguales.
        Assertions.assertEquals(rEspeado, rReal);
    }
}