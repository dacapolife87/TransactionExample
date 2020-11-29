package me.hjjang.example.exception;

public class ForceThrowException extends RuntimeException  {

    public ForceThrowException() {
        super();
    }

    public ForceThrowException(String message) {
        super(message);
    }

    public ForceThrowException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForceThrowException(Throwable cause) {
        super(cause);
    }

    protected ForceThrowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
