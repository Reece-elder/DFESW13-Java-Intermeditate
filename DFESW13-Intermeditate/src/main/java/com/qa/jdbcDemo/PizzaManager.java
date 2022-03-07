package com.qa.jdbcDemo;

import java.sql.Connection;
import java.sql.Statement;

// Object manager - contains methods to achieve CRUD functionality 
public class PizzaManager {
	
	// Creating my DBManager object for use in the code
	DBManager manager = new DBManager();
	
	// this method returns an empty query statement
	// by setting the query in this object we can send MySQL queries
	public Statement databaseSetup() {
		Statement statement = null;
		try {
			Connection conn = manager.connectDB();
			
			// Statement is an object, which includes the MySQL query to make
			// Setup an empty statement object, so we can eventually add the query
			statement = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statement;
	}
	
	public boolean addSetPizza() {
		try {
			// the MySQL Query we send to the database to add some data
			String query = "INSERT INTO pizzas (flavour, slices, stuffed_crust) VALUES (\"Pepperoni\", 12, true);";
			databaseSetup().executeUpdate(query); // Puts our query into the statement object, and runs the query
			return true; 
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		// if there is no issue, returns true
		// if there is an exception returns false
		
	}

}