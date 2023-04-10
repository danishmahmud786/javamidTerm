package math.problems;

public class Factorial {
    // factorial using recursion
    public static int factorialUsingRecursion(int n) {
        if(n == 0) {
            return 1;
        } else {
            return n * factorialUsingRecursion(n-1);
        }
    }

    // factorial using iteration
    public static int factorialUsingIteration(int n) {
        int result = 1;
        for(int i=1; i<=n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        /*
         * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
         * Write a java program to find Factorial of a given number using Recursion as well as Iteration.
         *
         */
        int num = 5;

        // using recursion
        int resultRecursion = factorialUsingRecursion(num);
        System.out.println("Factorial of " + num + " using recursion: " + resultRecursion);

        // using iteration
        int resultIteration = factorialUsingIteration(num);
        System.out.println("Factorial of " + num + " using iteration: " + resultIteration);
    }

}

