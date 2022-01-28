package filedownloader.utils;

import filedownloader.services.FileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class CommandsUtil {
    private final FileService fileService;
    private final Scanner scanner;
    public boolean exit = false;

    public CommandsUtil(){
        fileService = new FileService();
        scanner = new Scanner(System.in);
    }

    private void displayHelp(){
        System.out.println("Available commands:\n" +
                "/help \t\t\t\t\t- display help\n" +
                "/load [url] \t\t\t- download the content of the file located at [url]. Please specify a destination first.\n" +
                "/load [url1] [url2] ... - download the content of all specified files located at the given [url1], [url2], etc. Please specify a destination first.\n" +
                "/dest [path] \t\t\t- set the destination folder for download\n" +
                "/exit \t\t\t\t\t- exit application");
    }

    public void readCommand(){
        System.out.print("Enter command: ");

        var input = scanner.nextLine();
        var command = input.split(" ")[0];

        switch (command) {
            case "/help" -> displayHelp();
            case "/load" -> loadFiles(input);
            case "/dest" -> setDestination(input);
            case "/exit" -> exit = true;
            default -> System.out.println("Command not recognised. Please type /help to view available commands.");
        }
    }

    private void loadFiles(String input){
        var params = input.split(" ");

        var urls = new ArrayList<String>();

        for (int i = 1; i < params.length; i++) {
            urls.add(params[i]);
        }

        try {
            fileService.loadFiles(urls);
        }catch (NullPointerException nullPointerException){
            System.out.println(nullPointerException.getMessage());
        }catch (IOException ioException){
            System.out.println("There has been an error while trying to download the specified file: " +
                    ioException.getMessage());
        }

    }

    private void setDestination(String input){
        if(Arrays.stream(input.split(" ")).count() != 2){
            System.out.println("Only one parameter is allowed with the /dest command");
            return;
        }

        var path = input.split(" ")[1];

        try{
            fileService.changeDestination(path);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }

    }
}
