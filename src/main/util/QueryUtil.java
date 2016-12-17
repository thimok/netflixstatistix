package main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryUtil {
	
	public static void addAccount(String name, String address, String town) {
		int maxValue = getMaximumNumberFromColumn("abonnement", "AbonneeNr");
		String query = "INSERT INTO abonnement (AbonneeNr, Naam, Adres, Woonplaats) VALUES (" + (maxValue + 1) + ", '" + name + "', '" + address + "', '" + town + "');";
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/netflix", "root", "");
			Statement s = c.createStatement();
			
			s.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeAccount(String name, String address, String town) {
		String query = "UPDATE abonnement SET Adres = '" + address + "', Woonplaats = '" + town + "' WHERE Naam = '" + name + "';";
		
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/netflix", "root", "");
			Statement s = c.createStatement();
			
			s.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteAccount(int number) {
		String query = "DELETE FROM abonnement WHERE AbonneeNr = " + number;
		
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/netflix", "root", "");
			Statement s = c.createStatement();
			
			s.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getMaximumNumberFromColumn(String table, String column) {
		int ret = -1; //Always check if returned value equals -1, this is an error!
		
		String query = "SELECT MAX(" + column + ") FROM " + table + ";";
		
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/netflix", "root", "");
			Statement s = c.createStatement();
			s.execute(query);
			
			ResultSet rs = s.getResultSet();
			
			if (rs.next()) {
				ret = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
