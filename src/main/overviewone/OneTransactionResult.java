package main.overviewone;

import main.util.Connectable;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OneTransactionResult {
	
	static public void displayResultsOne(ArrayList<OneViewItem> results, JEditorPane ta, Object item, JLabel l) {
		//Prepare SQL query to hit the database
		String QueryOut =   "SELECT aflevering.Volgnummer, aflevering.SerieTitel, AVG(voortgang.BekekenPercentage) " +
				"AS average_bekeken FROM voortgang " +
				"INNER JOIN profiel " +
				"ON profiel.Naam = voortgang.Profielnaam AND profiel.AbonneeNr = voortgang.AbonneeNr " +
				"INNER JOIN programma " +
				"ON programma.ID = voortgang.ProgrammaID " +
				"INNER JOIN aflevering " +
				"ON aflevering.ID = programma.ID " +
				"WHERE aflevering.SerieTitel = '" + item + "' " +
				"GROUP BY aflevering.ID;";
		
		//Catch the results with a resultset
		ResultSet rs = Connectable.executeQuery(QueryOut);
		
		//Try to print out the results in the JEditorPane
		//Otherwise throw SQLException and print out the StackTrace
		try {
			
			boolean empty = true;
			while (rs.next()) {
				results.add(new OneViewItem(rs.getInt("Volgnummer"), rs.getDouble("average_bekeken")));
				empty = false;
			}
			
			l.setText("" + item);
			StringBuffer sb = new StringBuffer();
			
			if(empty) {
				sb.append("</strong>Nothing watched of<strong> " + item);
			} else {
				for (int i = 0; i < results.size(); i++) {
					String season = results.get(i).getSeasonEpisode().substring(0, 1);
					String episode = results.get(i).getSeasonEpisode().substring(2, 3);
					String aflevering = "<strong>Season:</strong> " + season + " <strong>Episode:</strong> " + episode + "</strong>";
					String percentage = "<font color='#D32F2F'>" + String.format("%3.0f", results.get(i).getGemiddeldbekeken()) + "%</font>";
					
					String f = aflevering + "<br>" + percentage;
					sb.append(f + "<br><br>");
				}
			}
			ta.setText("<div style = 'text-align: center; color: #FAFAFA;'><font face='verdana' size='4'>" + sb.toString() + "</font></div>");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
