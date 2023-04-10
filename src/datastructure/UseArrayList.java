package datastructure;

import java.util.ArrayList;
import java.util.Iterator;

public class UseArrayList {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 * 
		 */ // create an ArrayList
		ArrayList<String> list = new ArrayList<String>();

		// add elements to the list
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		list.add("date");
		list.add("elderberry");

		// print the list
		System.out.println("ArrayList contents: " + list);

		// peek at the first element
		String firstElement = list.get(0);
		System.out.println("Peek at the first element: " + firstElement);

		// remove an element
		String removedElement = list.remove(2);
		System.out.println("Removed element: " + removedElement);

		// retrieve elements using a for-each loop
		System.out.println("Retrieve elements using for-each loop:");
		for (String element : list) {
			System.out.println(element);
		}

		// retrieve elements using a while loop and an iterator
		System.out.println("Retrieve elements using while loop and iterator:");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);
		}
	}
}




