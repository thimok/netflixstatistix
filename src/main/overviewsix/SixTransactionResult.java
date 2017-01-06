package main.overviewsix;

import main.util.Connectable;

import javax.swing.*;
import java.sql.ResultSet;

public class SixTransactionResult {
	static public void displayResultsSix(JEditorPane ta, Object item, JLabel l) {
		//Prepare SQL query to hit the database
		String QueryOut =   "SELECT COUNT(*) AS watched " +
				"FROM voortgang " +
				"INNER JOIN programma " +
				"ON programma.ID = voortgang.ProgrammaID " +
				"INNER JOIN film " +
				"ON film.ID = programma.ID " +
				"WHERE voortgang.BekekenPercentage = 100 " +
				"AND programma.Titel = '" + item +"' ";
		
		//Catch the results with a resultset
		ResultSet rs = Connectable.executeQuery(QueryOut);
		
		//Try to print out the results in the JEditorPane
		//Otherwise throw SQLException and print out the StackTrace
		if (rs != null) {
			
			l.setText("" + item);
			
			StringBuffer sb = new StringBuffer();
			boolean empty = true;
			try {
				
				while (rs.next()) {
					String naam = "<strong>" + rs.getInt("watched") + "</strong> people have watched <strong>" + item + "</strong> untill the end";
					sb.append(naam + "<br>");
					empty = false;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(empty){
				ta.setText("<div style = 'text-align: center; color: #FAFAFA;'><font face='verdana' size='4'><strong>" + item + " </strong>hasn't watched any movies" + "</font></div>");
			} else {
				ta.setText("<div style = 'text-align: center; color: #FAFAFA;'><font face='verdana' size='4'>" + sb.toString() + "</font></div>");
			}
			
		}
	}
}
