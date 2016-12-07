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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	class ComboListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Object item = e.getItem();
				
				System.out.println("item: " + item.toString());
			}
		}
	}
}
