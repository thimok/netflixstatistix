package main.overviewone;


import main.util.Connectable;
import main.util.OverviewPanel;
import main.util.ResultPanel;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OverviewOnePanel extends OverviewPanel {
	
	public OverviewOnePanel() {
		String QueryIn = "SELECT Titel FROM serie;";
		String Option = "Titel";
		boolean typ_string = true;
		
		ResultPanel rp = new ResultPanel(QueryIn, Option, typ_string, this);
		this.add(rp);
	}
	
	@Override
	public void displayResultsOne(ArrayList<OneViewItem> results, JEditorPane ta, Object item, JLabel l) {
		String QueryOut =   "SELECT aflevering.Volgnummer, aflevering.SerieTitel, AVG(voortgang.BekekenPercentage) " +
				"AS average_bekeken FROM voortgang " +
				"INNER JOIN profiel " +
				"ON profiel.Naam = voortgang.Profielnaam AND profiel.AbonneeNr = voortgang.AbonneeNr " +
				"INNER JOIN programma " +
				"ON programma.ID = voortgang.ProgrammaID " +
				"INNER JOIN aflevering " +
				"ON aflevering.ID = programma.ID " +
				"WHERE aflevering.SerieTitel = '" + item + "' GROUP BY aflevering.ID;";
		
		ResultSet rs = Connectable.executeQuery(QueryOut);
		
		try {
			
			while (rs.next()) {
				results.add(new OneViewItem(rs.getString("SerieTitel"), rs.getInt("Volgnummer"), rs.getDouble("average_bekeken")));
			}
			
			l.setText(item + "\n\n");
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < results.size(); i++) {
				String season = results.get(i).getSeasonEpisode().substring(0, 1);
				String episode = results.get(i).getSeasonEpisode().substring(2, 3);
				String aflevering = "<strong>Season:</strong> " + season + " <strong>Episode:</strong> " + episode + "</strong>";
				String percentage = "<font color='#D32F2F'>" + String.format("%3.0f", results.get(i).getGemiddeldbekeken()) + "%</font>";
				
				String f = aflevering + "<br>" + percentage;
				sb.append(f + "<br><br>");
			}
			ta.setText("<div style = 'text-align: center; color: #FAFAFA;'><font face='verdana' size='4'>" + sb.toString() + "</font></div>");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
