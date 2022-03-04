import annotations.Exported;
import annotations.Ignored;
import model.BookingForm;
import model.Guest;
import model.Preference;
import model.TestClass;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.Console;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.logging.ConsoleHandler;

import static org.junit.jupiter.api.Assertions.*;

class YamlMapperTest {

    @Test
    @Disabled
    void getRetainIdentity() {
    }

    @Test
    @Disabled
    void setRetainIdentity() {
    }

    @Test
    @Disabled
    void readFromString() {
    }

    @Test
    @Disabled
    void read() {
    }

    @Test
    @Disabled
    void testRead() {
    }

    @Test
    void writeToString_PreferenceNonNullDescription_ValidString() {
        // Assign
        var preference = new Preference("Test description");
        var yamlMapper = new YamlMapper();

        // Act
        var yamlResult = yamlMapper.writeToString(preference);

        // Assert
        assertEquals("description: Test description\n", yamlResult);
    }

    @Test
    void writeToString_GuestNonNullDescription_ValidString() {
        // Assign
        var preferences = new HashSet<Preference>();
        preferences.add(new Preference("Test description1"));
        preferences.add(new Preference("Test description2"));
        var guest = new Guest("TestGuess", preferences);
        var yamlMapper = new YamlMapper();

        // Act
        var yamlResult = yamlMapper.writeToString(guest);
        //System.out.println(yamlResult);

        // Assert
        assertEquals("name: TestGuess\n" +
                "preferences: \n" +
                "  description: Test description1\n" +
                "  description: Test description2\n", yamlResult);
    }

    @Test
    void writeToString_PreferenceNullDescription_ValidString() {
        // Assign
        var preference = new Preference(null);
        var yamlMapper = new YamlMapper();

        // Act
        var yamlResult = yamlMapper.writeToString(preference);

        // Assert
        assertEquals("", yamlResult);
    }

    @Test
    void writeToString_BookingFormAllFields_ValidString() {
        // Assign
        var preferences = new HashSet<Preference>();
        preferences.add(new Preference("Test description1"));
        preferences.add(new Preference("Test description2"));

        var guest1 = new Guest("TestGuess1", preferences);
        var guest2 = new Guest("TestGuess2", preferences);
        var bookingForm = new BookingForm(List.of(guest1, guest2));

        var yamlMapper = new YamlMapper();

        // Act
        var yamlResult = yamlMapper.writeToString(bookingForm);
        System.out.println(yamlResult);

        // Assert
        assertEquals("name: TestGuess\n" +
                "preferences: \n" +
                "  description: Test description1\n" +
                "  description: Test description2\n", yamlResult);
    }

    @Test
    @Disabled
    void write() {
    }

    @Test
    @Disabled
    void testWrite() {
    }

    @Test
    void test(){
        var test = new TestClass();
        var yamlMapper = new YamlMapper();
        var res = yamlMapper.writeToString(test);
        System.out.println(res);
        assertEquals(1, 1);
    }
}