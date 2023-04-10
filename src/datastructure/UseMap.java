package datastructure;

import java.sql.*;
import java.util.*;

public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */
		// Create a HashMap with String keys and List<String> values
		Map<String, List<String>> map = new HashMap<>();

		// Create some example data to put into the map
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("orange");

		List<String> vegetables = new ArrayList<>();
		vegetables.add("carrot");
		vegetables.add("celery");
		vegetables.add("spinach");

		// Add the data to the map, associating each list with a string key
		map.put("fruits", fruits);
		map.put("vegetables", vegetables);

		// Retrieve the data from the map using a for-each loop
		for (String key : map.keySet()) {
			List<String> value = map.get(key);
			System.out.println(key + ": " + value);
		}

		// Retrieve the data from the map using a while loop and iterator
		Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, List<String>> entry = iterator.next();
			String key = entry.getKey();
			List<String> value = entry.getValue();
			System.out.println(key + ": " + value);
		}

		// Store the data in MySQL
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String user = "myuser";
		String password = "mypassword";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO mytable (key, value) VALUES (?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);

			for (String key : map.keySet()) {
				List<String> value = map.get(key);
				statement.setString(1, key);
				statement.setString(2, value.toString());
				statement.executeUpdate();
			}

			System.out.println("Data stored in database.");

			conn.close();
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}

		// Retrieve the data from MySQL
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM mytable";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			Map<String, List<String>> retrievedMap = new HashMap<>();

			while (result.next()) {
				String key = result.getString("key");
				String valueStr = result.getString("value");
				List<String> value = new ArrayList<>(Arrays.asList(valueStr.substring(1, valueStr.length()-1).split(", ")));
				retrievedMap.put(key, value);
			}

			System.out.println("Retrieved data:");
			for (String key : retrievedMap.keySet()) {
				List<String> value = retrievedMap.get(key);
				System.out.println(key + ": " + value);
			}

			conn.close();
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}
	}
}



