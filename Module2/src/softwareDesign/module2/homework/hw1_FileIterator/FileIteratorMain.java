package softwareDesign.module2.homework.hw1_FileIterator;

import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class FileIteratorMain {
    final static String FILE_PATH = "resources/input.txt";

    public static void main(String[] args) {
        FileIterator fileIterator;

        try {
            fileIterator= new FileIterator(FILE_PATH);
        }catch (IOException e) {
            System.out.println("There has been a problem while reading the file.\n" + Arrays.toString(e.getStackTrace()));

            return;
        }

        while (fileIterator.hasNext()){
            try {
                System.out.println(fileIterator.next());
            }catch (NoSuchElementException noSuchElementException){
                return;
            }
        }
    }
}