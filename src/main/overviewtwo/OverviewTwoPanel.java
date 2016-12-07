package main.overviewtwo;

import javax.swing.*;
import java.awt.*;

public class OverviewTwoPanel extends JPanel {
	private JComboBox combox;
	
	public OverviewTwoPanel() {
		String[] Database = {"Abonnoment","Profiel","Voortgang","Programma","Aflevering","Serie","Film"};
		combox = new JComboBox(Database);

		add(combox);
		
	}
}
