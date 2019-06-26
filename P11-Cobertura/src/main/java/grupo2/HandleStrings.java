package grupo2;

public class HandleStrings
{
    public String extractMiddle(String s)
    {
        int idx1 = s.indexOf(":");
        int idx2 = s.indexOf(":", idx1 + 1);

        return s.substring(idx1 + 1, idx2);
    }
}
