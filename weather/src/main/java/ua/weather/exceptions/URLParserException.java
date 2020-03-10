package ua.weather.exceptions;

public class URLParserException extends Exception {
    public URLParserException() {
    }

    public URLParserException(String message) {
        super(message);
    }

    public URLParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public URLParserException(Throwable cause) {
        super(cause);
    }
}
