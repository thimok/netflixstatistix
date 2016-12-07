package main.overviewfour;

import javax.swing.*;
import java.awt.*;

public class OverviewFourPanel extends JPanel {
	private JComboBox combox;

	public OverviewFourPanel() {
		String[] Database = {"Abonnoment","Profiel","Voortgang","Programma","Aflevering","Serie","Film"};
		combox = new JComboBox(Database);

		add(combox);
	}
}
