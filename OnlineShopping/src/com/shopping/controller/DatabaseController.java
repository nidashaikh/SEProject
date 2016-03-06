package com.shopping.controller;
import java.sql.*;

public class DatabaseController {

	private static DatabaseController databaseController;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/shopping";
	static final String USER = "root";
	static final String PASS = "123456";
	
	//override default constructor to prevent object creation
	private DatabaseController(){}

	//Singleton access to Database Controller
	public static DatabaseController getDatabaseController(){
		if(databaseController == null){
			databaseController = new DatabaseController();
			return databaseController;
		} else {
			return databaseController;
		}
	}
	
	
	//return Connection on request
	public Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//close database related objects
	public void close(final Object... objects) {
		try {
			for (Object object : objects) {
				if (object != null && object instanceof ResultSet) {
					final ResultSet result = (ResultSet) object;
					if (!result.isClosed()) {
						result.close();
					}
				} else if (object != null && object instanceof PreparedStatement) {
					final PreparedStatement stmt = (PreparedStatement) object;
					if (!stmt.isClosed()) {
						stmt.close();
					}
				} else if (object != null && object instanceof Connection) {
					final Connection conn = (Connection) object;
					if (!conn.isClosed()) {
						conn.close();
					}
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return databaseController;
	}
	
	

}