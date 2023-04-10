package string.problems;

import java.util.HashMap;
import java.util.Map;

public class DuplicateWord {

    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         *
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";



        String[] words = st.split(" ");
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        System.out.println("Duplicate words and their number of occurrences:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        //Also Find the average length of the words:

        int totalLength = 0;

        for (String word : words) {
            totalLength += word.length();
        }

        double averageLength = (double) totalLength / words.length;

        System.out.println("The average length of the words in the sentence is: " + averageLength);


    }

}
