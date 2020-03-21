package ua.flatware.exceptions;

public class WithNotValidException extends Throwable {
    public WithNotValidException() {
    }

    public WithNotValidException(String message) {
        super(message);
    }

    public WithNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public WithNotValidException(Throwable cause) {
        super(cause);
    }
}
