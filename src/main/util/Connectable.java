package main.util;

import java.sql.*;

public class Connectable {
	
	private static Connection getConnection() {
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost/netflix", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	private static Statement getStatement() {
		Statement s = null;
		try {
			s = getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	public static ResultSet executeQuery(String query) {
		ResultSet rs = null;
		
		try {
			rs = getStatement().executeQuery(query);
			getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
