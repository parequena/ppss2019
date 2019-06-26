package grupo1;

public class MultipathExample
{
    public int multiPath(int a, int b, int c)
    {
        if(a > 5)
            c += a;

        if(b > 5)
            c += b;

        return c;
    }
}
