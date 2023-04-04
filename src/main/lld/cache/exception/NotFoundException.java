package main.lld.cache.exception;

public class NotFoundException extends RuntimeException {
    private String message;

    public NotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
