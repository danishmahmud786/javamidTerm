package math.problems;

public class FindLowestDifference {
    public static void main(String[] args) {
        /*
         Implement in java.
         Read this below two array. Find the lowest difference between the two array cell.
         The lowest difference between cells is 1
        */
        //int [] array1 = {30,12,5,9,2,20,33,1};
        //int [] array2 = {18,25,41,47,17,36,14,19};

        int[] array = {30,12,5,9,2,20,33,1};
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                int diff = Math.abs(array[i] - array[j]);
                if (diff < minDiff) {
                    minDiff = diff;
                }
            }
        }
        System.out.println("The lowest difference between two cells is: " + minDiff);




    }

}
