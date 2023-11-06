package asm02.exception;

public class FileReadException extends RuntimeException {
    public FileReadException(Throwable cause) {
        super(cause);
    }

    public FileReadException() {
        super();
    }

    public FileReadException(String message) {
        super(message);
    }

    public FileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
