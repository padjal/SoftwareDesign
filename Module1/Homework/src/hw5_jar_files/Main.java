package hw5_jar_files;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a:");
        int a = scanner.nextInt();
        System.out.print("b:");
        int b = scanner.nextInt();

        System.out.println("The sum of " + a + " and " + b + " is " + sum(a, b));
    }

    public static int sum(int n1, int n2){
        return n1 + n2;
    }
}
