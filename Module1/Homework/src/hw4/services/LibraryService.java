package hw4.services;

import hw4.models.Book;
import hw4.models.Library;
import hw4.utilities.Scan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;

public class LibraryService {
    private final ArrayList<Book> takenBooks = new ArrayList<Book>();
    private final Library library = new Library();
    private final int RANDOM_BOOKS_COUNT = 10;

    public LibraryService(){
        generateBooks();
    }

    private void generateBooks(){


        String title, author;

        for (int i=0; i<RANDOM_BOOKS_COUNT; i++){

        }
    }

    public void addBook(){
        //TODO: Add some checks?
        System.out.print("Enter book author: ");
        var author = Scan.readLine();

        System.out.print("Enter book title: ");
        var title = Scan.readLine();

        System.out.print("Enter book publish date: ");
        var publishDate = Scan.readInt();

        library.books.add(new Book(title, author, publishDate));
    }

    public void takeBook(String[] input){
        //TODO:Validate input and add taken book to takenBooks
    }

    public void listTakenBooks(){
        for (var book : takenBooks){
            System.out.println(book);
        }
    }

    public void listAllBooks(){
        var uniqueBooks = new HashSet<Book>(library.books);
        var test = library.books.stream().collect(Collectors.groupingBy(b -> b.title));
        for (var book : uniqueBooks){
            System.out.println(book);
        }
    }
}
