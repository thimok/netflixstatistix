package main.overviewone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class OverviewOnePanel extends JPanel {
	private JComboBox combox;
	
	public OverviewOnePanel() {
		String[] Database = {"Abonnoment","Profiel","Voortgang","Programma","Aflevering","Serie","Film"};
		combox = new JComboBox(Database);
		ComboListener cl = new ComboListener();
		combox.addItemListener(cl);

		add(combox);
	}
	
	class ComboListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Object item = e.getItem();
				
				System.out.println("f: " + item.toString());
			}
		}
	}
}
