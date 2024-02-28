package az.etaskify.errors;

import org.springframework.http.HttpStatus;

public interface ErrorResponse {

    String getKey();

    String getMessage();

    HttpStatus getHttpStatus();
}
