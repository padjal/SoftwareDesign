package json_serializer.models;

import json_serializer.annotations.IgnoreNull;
import json_serializer.annotations.JsonElement;
import json_serializer.annotations.JsonSerializable;

@JsonSerializable
@IgnoreNull
public class Student {
    @JsonElement
    private String firstName;

    @JsonElement("name")
    private String lastName;

    @JsonElement()
    private String age;

    @JsonElement()
    private String weight;

    public Student(String firstName, String lastName, String age, String weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
    }

    public Student(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName) {
        this.firstName = firstName;
    }

    public Student() {
    }
}