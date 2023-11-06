package asm02.exception;

public class FileWriteException extends RuntimeException {
    public FileWriteException(Throwable cause) {
        super(cause);
    }

    public FileWriteException() {
        super();
    }

    public FileWriteException(String message) {
        super(message);
    }

    public FileWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
