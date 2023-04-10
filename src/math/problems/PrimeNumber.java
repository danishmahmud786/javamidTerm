package math.problems;

public class PrimeNumber {

	public static void main(String[] args) {
		/*
		 * Find list of Prime numbers from number 2 to 1 million.
		 * Try the best solution as possible.Which will take less CPU life cycle.
		 * Out put number of Prime numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */
		int limit = 1000000; // set the upper limit

		// loop through all numbers from 2 to 1 million
		for (int i = 2; i <= limit; i++) {
			boolean isPrime = true;

			// check if i is divisible by any number between 2 and i-1
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			// if i is prime, print it to the console
			if (isPrime) {
				System.out.print(i + " ");
			}
		}

	}

}
