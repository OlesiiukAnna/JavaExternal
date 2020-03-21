package ua.flatware.exceptions;

public class VolumeNotValidException extends Throwable {
    public VolumeNotValidException() {
    }

    public VolumeNotValidException(String message) {
        super(message);
    }

    public VolumeNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public VolumeNotValidException(Throwable cause) {
        super(cause);
    }
}
