package math.problems;

public class MakePyramid {
    public static void main(String[] args) {

        /*   Implement a large Pyramid of stars in the screen with java.

                              *
                             * *
                            * * *
                           * * * *
                          * * * * *
                         * * * * * *

        */
        int height = 6; // adjust the height of the pyramid as needed
        printPyramid(height);
    }

    public static void printPyramid(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height-i; j++) {
                System.out.print(" "); // print spaces to align the pyramid
            }
            for (int k = 1; k <= 2*i-1; k++) {
                System.out.print("*"); // print stars to form the pyramid
            }
            System.out.println(); // move to next line after each row
        }


        }
  }
