package softwareDesign.module4;

public class UserExistsException extends Exception{
    private static final String DEFAULT_MESSAGE = "User already in chat!";

    public UserExistsException(){
        super(DEFAULT_MESSAGE);
    }

    public UserExistsException(Throwable err){
        super(DEFAULT_MESSAGE, err);
    }

    public UserExistsException(String message, Throwable err){
        super(message, err);
    }
}
