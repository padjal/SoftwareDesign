package hw2;

import java.util.Scanner;

/**
 * Converts degrees from Celsius to Fahrenheit and back.
 */
public class DegreeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double degrees;

        //Demonstrate F to C
        System.out.print("Enter degrees in Fahrenheit:");
        degrees = scanner.nextInt();
        System.out.println();

        System.out.printf("%,.2f in Fahrenheit is equal to %,.2f in Celsius.%n", degrees, FahrenheitToCelsius(degrees));

        //Demonstrate C to F
        System.out.print("Enter degrees in Celsius:");
        degrees = scanner.nextInt();
        System.out.println();

        System.out.printf("%,.2f in Celsius is equal to %,.2f in Fahrenheit.", degrees, CelsiusToFahrenheit(degrees));

    }

    /**
     * Converts degrees from Fahrenheit to Celsius.
     * @param degrees The degrees in Fahrenheit.
     * @return The result of the conversion.
     */
    public static double FahrenheitToCelsius(double degrees){
        return (degrees-32)*5/9;
    }

    /**
     * Converts degrees from Celsius to Fahrenheit.
     * @param degrees The degrees in Celsius.
     * @return The result of the conversion.
     */
    public static double CelsiusToFahrenheit(double degrees){
        return degrees*1.8 + 32;
    }
}
