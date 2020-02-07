package com.game.ecxeption;

public class WrongValueException extends RuntimeException {
    public WrongValueException() {
        super();
    }

    public WrongValueException(String message) {
        super(message);
    }

    public WrongValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
