package by.zercomp.processor.exception;

public class InvalidDataException extends Exception{

    String message;

    public InvalidDataException() {
        super();
    }

    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDataException(Throwable cause) {
        super(cause);
    }

    public InvalidDataException(String msg) {
        super(msg);
        this.message = msg;
    }

}
