package main.util;

import java.sql.*;
import java.util.ArrayList;

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
	
	public static ArrayList fillComboBox(String query, boolean s, String item) {
		ArrayList<String> rs_list = new ArrayList<>();
		
		rs_list.add("");
		
		try {
			ResultSet rs = Connectable.executeQuery(query);
			if (s) {
				while (rs.next()) {
					rs_list.add(rs.getString(item));
				}
			} else {
				while (rs.next()) {
					rs_list.add("" + rs.getInt(item));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs_list;
	}
}
