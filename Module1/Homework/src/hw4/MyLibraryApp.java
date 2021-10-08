package hw4;

import hw4.services.LibraryService;
import hw4.utilities.Scan;

public class MyLibraryApp {
    private static final LibraryService libraryService = new LibraryService();

    public static void main(String[] args) {
        String[] input;
        do{
            input = Scan.readLine().split(" ");
            switch (input[0]) {
                case "/list" -> libraryService.listTakenBooks();
                case "/get" -> libraryService.takeBook(input);
                case "/put" -> libraryService.addBook();
                case "/all" -> libraryService.listAllBooks();
            }
        }while (!input[0].equals("/q"));

        Exit();
    }

    public static void Exit(){
        Scan.closeScan();
        System.exit(0);
    }
}
