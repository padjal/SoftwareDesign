package exceptions;

public class YamlSerializationException extends RuntimeException{
    public YamlSerializationException(String message, Throwable cause){
        super(message, cause);
    }

    public YamlSerializationException(String message){
        super(message);
    }
}
