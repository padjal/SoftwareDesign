package json_serializer.models;

import json_serializer.annotations.JsonElement;
import json_serializer.annotations.JsonSerializable;

@JsonSerializable
public class Person {
    @JsonElement
    private String firstName;

    @JsonElement("name")
    private String lastName;

    @JsonElement()
    private String age;

    @JsonElement()
    private String weight;

    public Person(String firstName, String lastName, String age, String weight){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
    }

    public Person(String firstName, String lastName, String age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName){
        this.firstName = firstName;
    }

    public Person(){
    }
}
