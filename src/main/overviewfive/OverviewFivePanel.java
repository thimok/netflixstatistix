package main.overviewfive;

import javax.swing.*;
import java.awt.*;

public class OverviewFivePanel extends JPanel {
	private JComboBox combox;
	
	public OverviewFivePanel() {
		String[] Database = {"Abonnoment","Profiel","Voortgang","Programma","Aflevering","Serie","Film"};
		combox = new JComboBox(Database);

		add(combox);
		
	}
}
