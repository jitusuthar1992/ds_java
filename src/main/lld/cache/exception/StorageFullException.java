package main.lld.cache.exception;

public class StorageFullException extends RuntimeException {

    private String message;

    public StorageFullException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
