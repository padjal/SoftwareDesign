package json_serializer.utils;

import json_serializer.models.Person;
import json_serializer.models.Square;
import json_serializer.models.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonSerializerUtilTest {

    @Test
    void serialize_PersonWithAllFieldsInitialized_SerializesAllFieldsWithJsonElementAnnotation() {
        // Assign
        var personOne = new Person("Pavel", "Dzhalev", "22", "76");

        var serializer = new JsonSerializerUtil();


        try {
            // Act
            var jsonResult = serializer.serialize(personOne);

            // Assert
            assertEquals(
                    "{\"firstName\":\"Pavel\",\"name\":\"Dzhalev\",\"age\":\"22\",\"weight\":\"76\"}",
                    jsonResult);
        } catch (JsonSerializerUtil.JsonSerializeException e) {
            e.printStackTrace();

            fail();
        }
    }

    @Test
    void serialize_PersonWithSomeFieldsInitialized_SerializesAllFieldsWithNullWhenFieldIsNull() {
        // Assign
        var personOne = new Person("Pavel", "Dzhalev", "22");

        var serializer = new JsonSerializerUtil();


        try {
            // Act
            var jsonResult = serializer.serialize(personOne);

            // Assert
            assertEquals(
                    "{\"firstName\":\"Pavel\",\"name\":\"Dzhalev\",\"age\":\"22\",\"weight\":\"null\"}",
                    jsonResult);
        } catch (JsonSerializerUtil.JsonSerializeException e) {
            e.printStackTrace();

            fail();
        }
    }

    @Test
    void serialize_PersonWithNoFieldsInitialized_SerializesAllFieldsWithNullWhenFieldIsNull() {
        // Assign
        var personOne = new Person();

        var serializer = new JsonSerializerUtil();


        try {
            // Act
            var jsonResult = serializer.serialize(personOne);

            // Assert
            assertEquals(
                    "{\"firstName\":\"null\",\"name\":\"null\",\"age\":\"null\",\"weight\":\"null\"}",
                    jsonResult);
        } catch (JsonSerializerUtil.JsonSerializeException e) {
            e.printStackTrace();

            fail();
        }
    }

    @Test
    void serialize_StudentWithAllFieldsInitialized_SerializesAllFieldsWithJsonElementAnnotation() {
        // Assign
        var studentOne = new Student("Pavel", "Dzhalev", "22", "76");

        var serializer = new JsonSerializerUtil();


        try {
            // Act
            var jsonResult = serializer.serialize(studentOne);

            // Assert
            assertEquals(
                    "{\"firstName\":\"Pavel\",\"name\":\"Dzhalev\",\"age\":\"22\",\"weight\":\"76\"}",
                    jsonResult);
        } catch (JsonSerializerUtil.JsonSerializeException e) {
            e.printStackTrace();

            fail();
        }
    }

    @Test
    void serialize_StudentWithoutWeightField_IgnoresWeightField() {
        // Assign
        var studentOne = new Student("Pavel", "Dzhalev", "22");

        var serializer = new JsonSerializerUtil();


        try {
            // Act
            var jsonResult = serializer.serialize(studentOne);

            // Assert
            assertEquals(
                    "{\"firstName\":\"Pavel\",\"name\":\"Dzhalev\",\"age\":\"22\"}",
                    jsonResult);
        } catch (JsonSerializerUtil.JsonSerializeException e) {
            e.printStackTrace();

            fail();
        }
    }

    @Test
    void serialize_ObjectWithNoJsonSerializableAnnotation_ThrowsJsonSerializeException() {
        // Assign
        var square = new Square(5);

        var serializer = new JsonSerializerUtil();

        // Act

        // Assert
        assertThrows(JsonSerializerUtil.JsonSerializeException.class, () -> serializer.serialize(square));
    }
}