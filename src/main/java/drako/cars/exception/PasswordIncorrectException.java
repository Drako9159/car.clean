package drako.cars.exception;

public class PasswordIncorrectException extends RuntimeException {
    public PasswordIncorrectException() {
        super("La contraseña es inválida");
    }
}
