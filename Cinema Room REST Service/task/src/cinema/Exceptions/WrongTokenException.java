package cinema.Exceptions;

public class WrongTokenException extends RuntimeException {
    public WrongTokenException(String cause){
        super(cause);
    }

    public WrongTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
