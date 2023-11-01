package drako.cars.exception;

public class PurchaseNotExistException extends RuntimeException {
    public PurchaseNotExistException() {
        super("La factura no existe");
    }
}
