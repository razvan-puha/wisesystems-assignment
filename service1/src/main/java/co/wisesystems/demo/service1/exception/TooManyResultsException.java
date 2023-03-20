package co.wisesystems.demo.service1.exception;

public class TooManyResultsException extends RuntimeException {

    public TooManyResultsException(String message) {
        super(message);
    }
}