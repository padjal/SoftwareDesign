package hw4.models;

import java.util.Objects;

public class Book {
    private static int idCounter = 1;

    public String author;
    public int id;
    public String title;
    public int publishYear;

    public Book(String title, String author, int publishYear){
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.id = idCounter;
        idCounter++;
    }

    @Override
    public String toString() {
        return author + " \"" + title + "\"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
