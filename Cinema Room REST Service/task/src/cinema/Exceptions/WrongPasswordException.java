package cinema.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String cause){
        super(cause);
    }

    public WrongPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
