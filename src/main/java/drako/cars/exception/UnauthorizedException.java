package drako.cars.exception;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super("No tiene los permisos necesarios");
    }
}
