package hw4.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library, which contains books.
 */
public class Library {
    public List<Book> books;

    public Library(){
        books = new ArrayList<>();
    }
}
