package exceptions;

public class NotExportedException extends RuntimeException{
    public NotExportedException(String message, Throwable cause){
        super(message, cause);
    }

    public NotExportedException(String message){
        super(message);
    }
}
