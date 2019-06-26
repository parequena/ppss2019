package grupo1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MultipathExampleTest
{
    MultipathExample m = new MultipathExample();

    @Test
    void multiPath1()
    {
        int a = 10;
        int b = 10;
        int c = 0;
        int exp = 20;
        int obt = m.multiPath(a, b, c);

        // Assert if are equals.
        assertEquals(exp, obt);
    }

    /*@Test
    void multiPath2()
    {
        int a = 0;
        int b = 10;
        int c = 0;
        int exp = 0;
        int obt = m.multiPath(a, b, c);

        // Assert if are equals.
        assertEquals(exp, obt);
    }*/
}