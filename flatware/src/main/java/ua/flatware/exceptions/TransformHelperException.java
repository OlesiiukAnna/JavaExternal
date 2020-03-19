package ua.flatware.exceptions;

public class TransformHelperException extends Throwable {
    public TransformHelperException() {
        super();
    }

    public TransformHelperException(String message) {
        super(message);
    }

    public TransformHelperException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransformHelperException(Throwable cause) {
        super(cause);
    }
}
