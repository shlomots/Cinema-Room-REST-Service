package cinema.Exceptions;

public class SeatOutOfBoundsException extends RuntimeException {
    public SeatOutOfBoundsException(String cause){
        super(cause);
    }

    public SeatOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }
}


