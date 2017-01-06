package main.overviewfour;

import main.util.Connectable;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FourTransactionResult {
	static public void displayResultsFour(JEditorPane ta) {
		//Prepare SQL query to hit the database
		String query = "SELECT programma.Titel" +
				" FROM programma" +
				" INNER JOIN film" +
				" ON film.ID = programma.ID" +
				" WHERE film.Leeftijdsindicatie < 16" +
				" ORDER BY programma.Tijdsduur DESC;";
		
		//Catch the results with a resultset
		ResultSet rs = Connectable.executeQuery(query);
		StringBuffer sb = new StringBuffer();
		ArrayList results = new ArrayList<>();
		
		//Try to print out the results in the JEditorPane
		//Otherwise throw SQLException and print out the StackTrace
		if (rs != null) {
			try {
				while (rs.next()) {
					results.add(rs.getString("programma.Titel"));
				}
				
				for(int i=0; i < results.size(); i++) {
					if(i==0) {
						String titel = "<font size='5' color='#D32F2F'><strong>" + (i + 1) + ". " + results.get(i).toString() + "</strong></font>";
						sb.append(titel + "<br>");
					} else {
						String titel = "<strong>" + (i + 1) + ". " + results.get(i).toString() + "</strong>";
						sb.append(titel + "<br>");
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			ta.setText("<div style = 'text-align: center; color: #FAFAFA;'><font face='verdana' size='4'>" + sb.toString() + "</font></div>");
		}
	}
}
