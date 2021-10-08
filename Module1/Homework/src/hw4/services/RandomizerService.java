package hw4.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizerService {
    private Random random = new Random();

    private static final ArrayList<String> names = new ArrayList<String>(
            List.of(
                    "John",
                    "Ben",
                    "Oliver"
            )
    );

    private static final ArrayList<String> surnames = new ArrayList<String>(
            List.of(
                    "Steinbeck",
                    "Atwood",
                    "Twist"
            )
    );

    public String getRandomName(){
        return "testName";
    }
}
