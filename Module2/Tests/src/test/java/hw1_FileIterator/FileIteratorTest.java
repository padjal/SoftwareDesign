package hw1_FileIterator;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FileIteratorTest {
    @Test
    void fileIterator_NonExistingFile_ThrowsFileNotFoundException() {
        assertThrows(FileNotFoundException.class, () -> {
            var fi = new FileIterator("noSuchFile.txt");
        });
    }

    @Test
    void hasNext_IterationHasNoMoreElements_False() {
        FileIterator fi;
        try{
            fi = new FileIterator(getClass().getResource("/emptyFile.txt").getPath());

            assertFalse(fi.hasNext());
        }catch (IOException ignored){

        }
    }

    @Test
    void hasNext_IterationHasMoreElements_True() {
        FileIterator fi;
        try{
            fi = new FileIterator(getClass().getResource("/test01.txt").getPath());
            assertTrue(fi.hasNext());
        }catch (IOException ignored){

        }
    }

    @Test
    void next_IterationHasNoMoreElements_ThrowsNoSuchElementException() {
        FileIterator fi;
        try{
            fi = new FileIterator(getClass().getResource("/emptyFile.txt").getPath());
            assertThrows(NoSuchElementException.class, ()-> fi.next());
        }catch (IOException ignored){

        }
    }

    @Test
    void next_IterationHasMoreElements_NotNull() {
        FileIterator fi;
        try{
            fi = new FileIterator(getClass().getResource("/test01.txt").getPath());
            assertNotNull(fi.next());
        }catch (IOException ignored){

        }
    }
}