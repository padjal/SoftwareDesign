package hw4.services;

import hw4.models.Book;
import hw4.models.Library;
import hw4.utilities.Scan;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Contains and provides functionality to work with a library.
 */
public class LibraryService {
    private final List<Book> takenBooks;
    private final Library library = new Library();
    private final int RANDOM_BOOKS_COUNT = 20;
    private final RandomizerService randomizerService;

    public LibraryService(){
        takenBooks = new ArrayList<>();
        randomizerService = new RandomizerService();

        generateBooksRandomly();
    }

    /**
     * Generate random books. Should be called while initializing the library service.
     */
    private void generateBooksRandomly(){
        String title, author;
        int publishYear;

        for (int i=0; i<RANDOM_BOOKS_COUNT; i++){
            title = randomizerService.getRandomBookTitle();
            author = randomizerService.getRandomName();
            publishYear = randomizerService.getRandomYear();

            var newBook = new Book(title, author, publishYear);

            // If a book with such title already exists.
            if(library.books.contains(newBook)){
                var originalBook = library.books.stream().filter(b -> Objects.equals(b.title, newBook.title)).findAny();

                library.books.add(originalBook.get());

                return;
            }

            // Otherwise add the new book.
            library.books.add(newBook);
        }
    }

    /**
     * Provides a user interface for adding a book to the library.
     */
    public void addBook(){
        System.out.print("Enter book author: ");
        var author = Scan.readLine();

        System.out.print("Enter book title: ");
        var title = Scan.readLine();

        System.out.print("Enter book publish year: ");
        int publishDate;

        try {
            publishDate = Scan.readInt();
        }catch (Exception e){
            System.out.println("Error parsing publish date. Book was not added to the collection.");
            return;
        }

        library.books.add(new Book(title, author, publishDate));
    }

    /**
     * Provides functionality for getting a book from the library.
     * @param input Contains the book title.
     */
    public void takeBook(String[] input){

        String title = String.join(" ", Arrays.copyOfRange(input, 1, input.length));

        if(library.books.stream().noneMatch(b -> Objects.equals(b.title, title))){
            System.out.println("Could not find this book in the library. Please check spelling.");
            return;
        }

        var foundBook = library.books.stream().filter(b -> Objects.equals(b.title, title)).findFirst();

        takenBooks.add(foundBook.get());

        library.books.remove(foundBook.get());
    }

    /**
     * Displays all taken books from the library.
     */
    public void listTakenBooks(){
        for (var book : takenBooks){
            System.out.println(book);
        }
    }

    /**
     * Displays all books in the library.
     */
    public void listAllBooks(){
        var distinctBooks = new HashMap<Book, Integer>();

        for (var book : library.books){
            if (!distinctBooks.containsKey(book)){
                distinctBooks.put(book, 1);
            }else{
                distinctBooks.put(book, distinctBooks.get(book) + 1);
            }
        }

        for (var book : distinctBooks.keySet()){
            System.out.println(distinctBooks.get(book) + " book(s) " + book);
        }
    }
}
