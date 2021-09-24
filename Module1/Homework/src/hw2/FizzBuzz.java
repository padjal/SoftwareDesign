package hw2;

/**
 * Solves the classical FizzBuzz problem.
 * Print all numbers from 1 to 100. If the number is divisible by 3,
 * print Fizz, if it is divisible by 5, print Buzz, if it is divisible by both,
 * print FizzBuzz, otherwise print the number.
 */
public class FizzBuzz {
    public static void main(String[] args) {

        StringBuilder output = new StringBuilder();

        for (int i=1; i<=100; i++){
            if(i % 3 == 0)
                output.append("Fizz");
            if(i % 5 == 0)
                output.append("Buzz");

            System.out.println(output.length() < 1 ? i : output);

            output.setLength(0);
        }
    }
}
