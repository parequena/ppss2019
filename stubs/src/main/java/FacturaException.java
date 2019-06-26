public class FacturaException extends Exception {

    private String msg;

    public FacturaException(String msg)
    {
        this.msg = msg;
    }

    public String getMessage() { return msg; }
}