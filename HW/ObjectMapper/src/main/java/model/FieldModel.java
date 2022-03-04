package model;

public class FieldModel {
    String name;
    Object value;

    public FieldModel(String name, Object value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public Object getValue(){
        return value;
    }
}
