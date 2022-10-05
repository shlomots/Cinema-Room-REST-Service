package cinema.Exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//this class will give us control over what the user sees when an exception is thrown.
//*it didn't work in the beginning because the apiException class didn't have getter and setters.
@ControllerAdvice()
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value =  ThisSeatIsAllreadyBoughtException.class)
    public ResponseEntity<Object> handleApiRequastException(ThisSeatIsAllreadyBoughtException exception){
        ApiException apiException = new ApiException(exception.getMessage());
        return new ResponseEntity<>(apiException , HttpStatus.BAD_REQUEST );
    }

   @ExceptionHandler(value = SeatOutOfBoundsException.class)
    public ResponseEntity<Object> handleApiRequastException2(SeatOutOfBoundsException exception){
       ApiException apiException = new ApiException(exception.getMessage());
       return new ResponseEntity<>(apiException , HttpStatus.BAD_REQUEST );
   }

    @ExceptionHandler(value = WrongTokenException.class)
    public ResponseEntity<Object> handleApiRequastException2(WrongTokenException exception){
        ApiException apiException = new ApiException(exception.getMessage());
        return new ResponseEntity<>(apiException , HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(value = WrongPasswordException.class)
    public ResponseEntity<Object> handleApiRequastException2(WrongPasswordException exception){
        ApiException apiException = new ApiException(exception.getMessage());
        return new ResponseEntity<>(apiException , HttpStatus.UNAUTHORIZED );
    }



}
