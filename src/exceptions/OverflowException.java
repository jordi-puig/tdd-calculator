
package exceptions;

public class OverflowException extends Exception {

    private static final long serialVersionUID = 1L;

    public OverflowException() {
    }

    public OverflowException(String msg) {
        super(msg);
    }

}
