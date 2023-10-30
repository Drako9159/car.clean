package drako.cars.exception;

public class EmailValidationException extends RuntimeException {
    public EmailValidationException() {
        super("Email format is invalid");
    }
}
