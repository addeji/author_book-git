package guru.springframework.Spring5webApp.exceptions;

public class NewException extends RuntimeException{
    public NewException() {
    }

    public NewException(String message) {
        super(message);
    }

    public NewException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewException(Throwable cause) {
        super(cause);
    }

    public NewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
