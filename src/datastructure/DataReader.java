package datastructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.LinkedList;
import java.util.Stack;

public class DataReader {

	public static void main(String[] args) {
		/*
		 * User API to read the below textFile and print to console.
		 * Use BufferedReader class. 
		 * Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
		 * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
		 * order from LinkedList and retrieve as FILO order from Stack.
		 *
		 * Demonstrate how to use Stack that includes push,peek,search,pop elements.
		 * Use For Each loop/while loop/Iterator to retrieve data.
		 */

		String textFile = System.getProperty("user.dir") + "/src/data/self-driving-car.txt";

		// read from file using BufferedReader
		try (BufferedReader reader = new BufferedReader(new FileReader("src/data/self-driving-car"))) {
			String line;
			LinkedList<String> linkedList = new LinkedList<>();
			Stack<String> stack = new Stack<>();
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+");
				for (String word : words) {
					linkedList.add(word);
					stack.push(word);
				}
			}

			// iterate through the list to retrieve as FIFO order
			System.out.println("LinkedList (FIFO order):");
			for (String word : linkedList) {
				System.out.print(word + " ");
			}
			System.out.println();

			// retrieve as FILO order from stack
			System.out.println("Stack (FILO order):");
			while (!stack.empty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();

			// demonstrate how to use Stack
			System.out.println("Demonstrate how to use Stack:");
			stack.push("apple");
			stack.push("banana");
			stack.push("cherry");
			System.out.println("Stack contents: " + stack);
			System.out.println("Peek at the top element: " + stack.peek());
			System.out.println("Search for 'banana': " + stack.search("banana"));
			System.out.println("Pop the top element: " + stack.pop());
			System.out.println("Stack contents: " + stack);

			// demonstrate how to connect to MySQL database
			String url = "jdbc:mysql://localhost/mydatabase";
			String username = "myuser";
			String password = "mypassword";
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				// create a table
				String sql = "CREATE TABLE IF NOT EXISTS words (id INT AUTO_INCREMENT PRIMARY KEY, word VARCHAR(255))";
				try (PreparedStatement stmt = conn.prepareStatement(sql)) {
					stmt.execute();
				}

				// insert data into the table
				sql = "INSERT INTO words (word) VALUES (?)";
				try (PreparedStatement stmt = conn.prepareStatement(sql)) {
					for (String word : linkedList) {
						stmt.setString(1, word);
						stmt.executeUpdate();
					}
				}

				// retrieve data from the table
				sql = "SELECT * FROM words";
				try (PreparedStatement stmt = conn.prepareStatement(sql);
					 ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						System.out.print(rs.getString("word") + " ");
					}
					System.out.println();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

