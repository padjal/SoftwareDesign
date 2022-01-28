package filedownloader.services;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    @Test
    void changeDestination_nonExistingPath_throwsIllegalArgumentException() {
        // Assign
        var fs = new FileService();
        var newFolder = "test";  // There is actually a slight chance that someone already has such a folder.
        // Act

        // Assert
        assertThrows(IllegalArgumentException.class, () -> fs.changeDestination(newFolder));
    }

    @Test
    void changeDestination_existingPath_nothingHappens() {
        // Assign
        var fs = new FileService();
        var newFolder = Paths.get("").toAbsolutePath().toString();  // There is actually a slight chance that someone already has such a folder.
        // Act

        // Assert
        assertDoesNotThrow(() -> fs.changeDestination(newFolder));
    }

    @Test
    void loadFiles_unauthorizedRequest_throwIOException() {
        // Assign
        var fs = new FileService();
        var list = new ArrayList<String>();
        list.add("https://www.baeldung.com/java-file-directory-exists");
        // Act

        // Assert
        assertThrows(IOException.class, () -> {fs.loadFiles(list);});
    }
}