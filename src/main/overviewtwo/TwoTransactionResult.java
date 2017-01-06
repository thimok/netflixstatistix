package main.overviewtwo;

import main.util.Connectable;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TwoTransactionResult {
	static public void displayResultsTwo(ArrayList<TwoViewItem> results, JEditorPane ta, Object serie, Object acc, JLabel l) {
		//Prepare SQL Query
		String QueryOut =  "SELECT aflevering.Volgnummer, aflevering.SerieTitel, AVG(voortgang.BekekenPercentage)" +
				"AS average_bekeken FROM voortgang " +
				"INNER JOIN profiel " +
				"ON profiel.Naam = voortgang.Profielnaam " +
				"AND profiel.AbonneeNr = voortgang.AbonneeNr " +
				"INNER JOIN programma " +
				"ON voortgang.ProgrammaID = programma.ID " +
				"INNER JOIN abonnement " +
				"ON abonnement.AbonneeNr = profiel.AbonneeNr " +
				"INNER JOIN aflevering " +
				"ON aflevering.ID = programma.ID " +
				"INNER JOIN serie " +
				"ON serie.Titel = aflevering.SerieTitel " +
				"WHERE aflevering.SerieTitel = '"+ serie +"' AND abonnement.Naam = '" + acc + "' " +
				"GROUP BY aflevering.ID ";
		
		//Catch the results with a resultset if both items are set
		if(serie != null && acc != null && serie != "" && acc != "") {
			ResultSet rs = Connectable.executeQuery(QueryOut);
			
			//Try to print out the results in the JEditorPane
			//Otherwise throw SQLException and print out the StackTrace
			try {
				boolean empty = true; //Flag to check if the item has matches
				while (rs.next()) {
					results.add(new TwoViewItem(rs.getInt("Volgnummer"), rs.getDouble("average_bekeken")));
					empty = false;
				}
				
				l.setText(serie + " - " + acc + "\n\n");
				StringBuffer sb = new StringBuffer();
				
				if(empty) {
					sb.append("</strong>Nothing watched of<strong> " + serie);
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
}
