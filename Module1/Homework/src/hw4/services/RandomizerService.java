package hw4.services;

import java.util.Random;

public class RandomizerService {
    private final Random random = new Random();

    private static final String[] names = new String[] {
            "John",
            "Ben",
            "Oliver",
            "Jonatan",
            "Philip",
            "Joe",
            "Barack",
            "Donald"
    };

    private static final String[] surnames = new String[] {
            "Steinbeck",
            "Atwood",
            "Twist",
            "Moritz",
            "Stalin",
            "Biden",
            "Obama",
            "Trump"
    };

    private static final String[] nouns = new String[] {
            "boy",
            "dog",
            "car",
            "man",
            "woman",
            "computer"
    };

    private static final String[] verbs = new String[] {
            "danced",
            "crashed",
            "lied",
            "laughed",
            "went on a vacation",
            "went camping"
    };

    /**
     * Gets a randomly generated string which resembles a human name.
     * @return The generated name.
     */
    public String getRandomName(){
        var nameIndex = random.nextInt(0, names.length-1);
        var surNameIndex = random.nextInt(0, surnames.length-1);

        return names[nameIndex] + " " + surnames[surNameIndex];
    }

    /**
     * Gets a randomly generated string which resembles a book title.
     * @return The generated book title.
     */
    public String getRandomBookTitle(){
        var nounIndex = random.nextInt(0, nouns.length-1);
        var verbIndex = random.nextInt(0, verbs.length-1);

        return "The " + nouns[nounIndex] + " that " + verbs[verbIndex];
    }

    /**
     * Gets a random year between 1600 and 2022.
     * @return The randomly selected year between 1600 and 2022.
     */
    public int getRandomYear(){
        return random.nextInt(1600, 2022);
    }
}
