package main.overviewone;

import main.util.Connectable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OverviewOnePanel extends JPanel {
	private JComboBox combox;
	private JScrollPane sp;
	private JTextArea ta;
	
	public OverviewOnePanel() {
		try {
			String serie_overview_query = "SELECT Titel FROM serie;";
			ResultSet serie_overview_result = Connectable.executeQuery(serie_overview_query);
			ArrayList<String> serie_overview_list = new ArrayList<>();
			
			while (serie_overview_result.next()) {
				serie_overview_list.add(serie_overview_result.getString("Titel"));
			}
			combox = new JComboBox(serie_overview_list.toArray());
			ComboListener cl = new ComboListener();
			combox.addItemListener(cl);
			
			add(combox);
			
			ta = new JTextArea(20, 100);
			ta.setEditable(false);
			sp = new JScrollPane(ta);
			
			add(sp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	class ComboListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Object item = e.getItem();
				
				OverviewOnePanel.this.ta.setText("");
				
				System.out.println("item: " + item.toString());
				
				try {
					String query = "SELECT aflevering.Volgnummer, aflevering.SerieTitel, AVG(voortgang.BekekenPercentage) AS average_bekeken FROM voortgang INNER JOIN profiel ON profiel.Naam = voortgang.Profielnaam AND profiel.AbonneeNr = voortgang.AbonneeNr INNER JOIN programma ON programma.ID = voortgang.ProgrammaID INNER JOIN aflevering ON aflevering.ID = programma.ID WHERE aflevering.SerieTitel = '" + item.toString() + "' GROUP BY aflevering.ID;";
					ResultSet rs = Connectable.executeQuery(query);
					
					ArrayList<OneViewItem> items = new ArrayList<>();
					
					while (rs.next()) {
						items.add(new OneViewItem(rs.getString("SerieTitel"), rs.getInt("Volgnummer"), rs.getDouble("average_bekeken")));
					}
					
					int i = 0;
					
					for (OneViewItem it : items) {
						String st = "Serie: " + it.getSerieNaam() + " / Aflevering: " + it.getSeasonEpisode() + " / Gemiddeld: " + it.getGemiddeldbekeken();
						OverviewOnePanel.this.ta.append(st + "\n");
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
