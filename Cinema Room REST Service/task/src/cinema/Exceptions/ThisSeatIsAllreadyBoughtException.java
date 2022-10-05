package cinema.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ThisSeatIsAllreadyBoughtException extends RuntimeException{
    public ThisSeatIsAllreadyBoughtException(String cause){
        super(cause);
    }

    public ThisSeatIsAllreadyBoughtException(String message, Throwable cause) {
        super(message, cause);
    }
}
