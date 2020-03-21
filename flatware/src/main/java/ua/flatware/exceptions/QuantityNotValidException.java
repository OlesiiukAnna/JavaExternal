package ua.flatware.exceptions;

public class QuantityNotValidException extends Throwable {
    public QuantityNotValidException() {
    }

    public QuantityNotValidException(String message) {
        super(message);
    }

    public QuantityNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuantityNotValidException(Throwable cause) {
        super(cause);
    }
}
