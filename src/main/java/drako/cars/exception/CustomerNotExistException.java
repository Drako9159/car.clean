package drako.cars.exception;

public class CustomerNotExistException extends RuntimeException {

    public CustomerNotExistException() {
        super("El usuario igresado no existe");
    }
}
