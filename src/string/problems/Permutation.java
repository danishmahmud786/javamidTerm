package string.problems;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {

        /*
         * Permutation of String "ABC" is "ABC" "BAC" "BCA" "ACB" "CAB" "CBA".
         * Write Java program to compute all Permutation of a String
         *
         */

        String st = "ABC";

        List<String> permutations = getPermutations(st);

        System.out.println("All permutations of the string:");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<String> getPermutations(String inputString) {
        List<String> result = new ArrayList<>();
        getPermutationsHelper("", inputString, result);
        return result;
    }
    private static void getPermutationsHelper(String prefix, String suffix, List<String> result) {
        if (suffix.length() == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                String newPrefix = prefix + suffix.charAt(i);
                String newSuffix = suffix.substring(0, i) + suffix.substring(i + 1);
                getPermutationsHelper(newPrefix, newSuffix, result);
            }
        }
    }
}
