package main.overviewthree;

import main.overviewone.OneViewItem;
import main.util.Connectable;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ThreeTransactionResult {
	static public void displayResultsThree(JEditorPane ta, Object item, JLabel l) {
		String QueryOut =   "SELECT DISTINCT programma.Titel " +
				"FROM voortgang " +
				"INNER JOIN programma " +
				"ON programma.ID = voortgang.ProgrammaID " +
				"INNER JOIN film " +
				"ON programma.ID = film.ID " +
				"INNER JOIN profiel " +
				"ON profiel.Naam = voortgang.Profielnaam AND profiel.AbonneeNr = voortgang.AbonneeNr " +
				"INNER JOIN abonnement " +
				"ON abonnement.AbonneeNr = profiel.AbonneeNr " +
				"WHERE abonnement.Naam = '" + item + "';";
		
		
		ResultSet rs = Connectable.executeQuery(QueryOut);
		
		
		if (rs != null) {
			
			l.setText("Movies watched by: " + item);
			
			StringBuffer sb = new StringBuffer();
			boolean empty = true;
			try {
								
				while (rs.next()) {
					String naam = "<strong>" + rs.getString("programma.Titel") + "</strong>";
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
