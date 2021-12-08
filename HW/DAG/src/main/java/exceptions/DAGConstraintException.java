package exceptions;

public class DAGConstraintException extends Exception{
    public DAGConstraintException(){
        super("No cycles are permitted in a DAG graph!");
    }
    public DAGConstraintException(String errorMessage){
        super(errorMessage);
    }
}
