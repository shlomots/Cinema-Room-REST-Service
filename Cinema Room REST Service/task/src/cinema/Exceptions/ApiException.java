package cinema.Exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

public class ApiException {
    private String error;
    @JsonIgnore
    private HttpStatus status; //maybe use it later.

    public ApiException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }
}
