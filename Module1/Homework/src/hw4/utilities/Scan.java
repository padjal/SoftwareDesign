package hw4.utilities;

import java.util.Scanner;

/**
 * A custom scanner implementation which uses the Singleton pattern.
 */
public class Scan {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Private constructor in order to forbid creating other instances.
     */
    private Scan(){
    }

    public static Scanner getScan(){
        return scanner;
    }

    public static void closeScan(){
        scanner.close();
    }

    public static String readLine(){
        return scanner.nextLine();
    }

    public static int readInt(){
        return scanner.nextInt();
    }
}
