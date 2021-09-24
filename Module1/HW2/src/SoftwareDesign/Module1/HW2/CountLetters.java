package SoftwareDesign.Module1.HW2;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Counts the vowels and consonants of a given string.
 */
public class CountLetters {
    public static void main(String[] args) {
        String example = "This is an example string. You can change it to observe results";

        System.out.printf("There are %d vowels and %d consonants in this string.",
                CountVowels(example), CountConsonants(example));
    }

    public static int CountVowels(String input){
        Pattern pattern = Pattern.compile("[aeiou]");
        Matcher matcher = pattern.matcher(input.toLowerCase(Locale.ROOT));

        int result = 0;

        while (matcher.find()){
            result++;
        }

        return result;
    }

    public static int CountConsonants(String input){
        Pattern pattern = Pattern.compile("[b-df-hj-np-tv-z]");
        Matcher matcher = pattern.matcher(input.toLowerCase(Locale.ROOT));

        int result = 0;

        while (matcher.find()){
            result++;
        }

        return result;
    }
}
