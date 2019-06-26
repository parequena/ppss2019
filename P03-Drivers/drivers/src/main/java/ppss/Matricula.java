package ppss;

public class Matricula
{
    public static float calculaTasaMatricula(int edad, boolean fNumerosa, boolean rep)
    {
        float tasa = 500.0f;

        if(edad < 25 && !fNumerosa && rep)
        {
            tasa += 1500.0f;
        }
        else
        {
            if(fNumerosa || edad >= 65)
            {
                tasa /= 2;
            }
            if(edad > 50 && edad < 65)
            {
                tasa -= 100.0f;
            }
        }

        return tasa;
    }
}
