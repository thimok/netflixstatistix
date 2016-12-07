package main.overviewone;

import javax.swing.*;
import java.awt.*;

public class OverviewOnePanel extends JPanel {
	private JComboBox combox;
	
	public OverviewOnePanel() {
		String[] Database = {"Abonnoment","Profiel","Voortgang","Programma","Aflevering","Serie","Film"};
		combox = new JComboBox(Database);

		add(combox);
	}
}
