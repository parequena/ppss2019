// Repaso stubs
// src/main
public class Examen()
{
    public int esDificil()
    {
        // Codigo ofuscado.
    }
}

// Va a src/main
public class Pablo
{
    public int notaPPSS(int horas)
    {
        Examen ex = new Examen();
        int dificutad = ex.esDificil();

        switch(dificutad)
        {
            case 1:
                return 8;
            case 2:
                return 5;
            case 3:
                return 3;
        }
    }
}

// 1. Tipo argumentos.
public int notaPPSS(int horas, Examen ex) { /*...*/ };

// src/test
@Test
public void notaPPSSTest()
{
    Examen ex = new Examen(); // Aqui creamos el doble.
    // Seteamos la dificultad que queremos.
    int horas = 40, rEsperado = 8; // Datos de entrada, resultado esperado.
    Pablo pablo = new Pablo();
    int rReal = pablo.notaPPSS(horas, ex); // Llamamos a la SUT.
    Assertions.assertEquals(rEsperado, rReal); // Assert.
}
// Inconvenientes: Modificamos código de terceros, haciendo que los demás programadores tengan
// que parsear su código para llamar a esta función.

// 2. Ctor.
// src/main
public class Pablo
{
    private Examen ex;
    public Pablo(Examen ex) { this.ex = ex; }
    public int notaPPSS(int hora)
    {
        Examen ex = this.ex;
        // ...
    }
}

// src/test
@Test
public void notaPPSSTest()
{
    Examen ex = new Examen(); // Aqui creamos el doble.
    // Seteamos la dificultad que queremos.
    int horas = 40, rEsperado = 8; // Datos de entrada, resultado esperado.
    Pablo pablo = new Pablo(ex);
    int rReal = pablo.notaPPSS(horas); // Llamamos a la SUT.
    Assertions.assertEquals(rEsperado, rReal); // Assert.
}
// Inconvenientes: Modificamos código de terceros, haciendo que los demás programadores tengan
// que parsear su código para llamar a esta función.

// 3. Setter.
public 

// 4. Facoria Local.
// 5. Clase Factoria.