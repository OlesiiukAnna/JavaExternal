package ua.flatware.exceptions;

public class LengthNotValidException extends Throwable {
    public LengthNotValidException() {
    }

    public LengthNotValidException(String message) {
        super(message);
    }

    public LengthNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public LengthNotValidException(Throwable cause) {
        super(cause);
    }
}
