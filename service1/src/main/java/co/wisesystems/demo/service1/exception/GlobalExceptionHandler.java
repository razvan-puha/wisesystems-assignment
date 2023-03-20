package co.wisesystems.demo.service1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TooManyResultsException.class)
    public ResponseEntity<String> handleTooManyResourcesException(TooManyResultsException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(ResourceCreatedException.class)
    public ResponseEntity<String> handleResourceCreatedException(ResourceCreatedException exception) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exception.getMessage());
    }
}