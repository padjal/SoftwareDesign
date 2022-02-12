package json_serializer;

import json_serializer.models.Person;
import json_serializer.models.Square;
import json_serializer.models.Student;
import json_serializer.utils.JsonSerializerUtil;

public class Main {
    public static void main(String[] args) {
        var personOne = new Person("Pavel", "Dzhalev", "22", "76");
        var personTwo = new Person("Pavel", "Dzhalev", "22");
        var personThree = new Person("Pavel", "Dzhalev");

        var studentOne = new Student("Pavel", "Dzhalev", "22", "76");
        var studentTwo = new Student("Pavel", "Dzhalev", "22");
        var studentThree = new Student("Pavel", "Dzhalev");

        var test = new Square(5);

        var serializer = new JsonSerializerUtil();

        try {
            System.out.println(serializer.serialize(personOne));
            System.out.println(serializer.serialize(personTwo));
            System.out.println(serializer.serialize(personThree));

            System.out.println("============== @IgnoreNull ==============");
            System.out.println(serializer.serialize(studentOne));
            System.out.println(serializer.serialize(studentTwo));
            System.out.println(serializer.serialize(studentThree));

            System.out.println(serializer.serialize(test));
        } catch (JsonSerializerUtil.JsonSerializeException e) {
            System.out.println("There was an error while serializing the object.");
        }
    }
}
