package hw4.models;

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
}
