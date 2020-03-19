package ua.flatware.exceptions;

public class FlatwareXmlParserException extends Throwable {
    public FlatwareXmlParserException() {
    }

    public FlatwareXmlParserException(String message) {
        super(message);
    }

    public FlatwareXmlParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlatwareXmlParserException(Throwable cause) {
        super(cause);
    }
}
