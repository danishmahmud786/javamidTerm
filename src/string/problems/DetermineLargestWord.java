package string.problems;

import java.util.HashMap;
import java.util.Map;

public class DetermineLargestWord {
    public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below.
         Should return "10 biological".
         */
        String s="Human brain is a biological learning machine";

        Map<Integer, String> wordNLength = findTheLargestWord(s);
        //implement

        String[] words = s.split(" ");
        int maxLength = 0;
        String longestWord = "";

        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWord = word;
            }
        }

        System.out.println("Length of the sentence: " + s.length());
        System.out.println("Longest word in the sentence: " + longestWord + ", length: " + maxLength);


    }

    public static Map<Integer, String> findTheLargestWord(String wordGiven){
        Map<Integer, String> map = new HashMap<Integer, String>();
        String st = "";
        //implement

        return map;
    }
}
