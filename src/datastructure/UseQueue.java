package datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */
		// Create a Queue of String elements using LinkedList implementation
		Queue<String> queue = new LinkedList<>();

		// Add elements to the Queue
		queue.add("apple");
		queue.add("banana");
		queue.add("orange");

		// Peek at the next element in the Queue without removing it
		String nextElement = queue.peek();
		System.out.println("Next element in the queue: " + nextElement);

		// Remove the next element from the Queue
		String removedElement = queue.remove();
		System.out.println("Removed element from the queue: " + removedElement);

		// Poll the next element from the Queue (returns null if Queue is empty)
		String polledElement = queue.poll();
		System.out.println("Polled element from the queue: " + polledElement);

		// Retrieve the remaining elements from the Queue using a for-each loop
		System.out.println("Remaining elements in the queue:");
		for (String element : queue) {
			System.out.println(element);
		}

		// Retrieve the remaining elements from the Queue using a while loop and iterator
		Iterator<String> iterator = queue.iterator();
		System.out.println("Remaining elements in the queue (using iterator):");
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);
		}
	}


}


