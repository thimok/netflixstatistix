package main.overviewsix;

import javax.swing.*;
import java.awt.*;

public class OverviewSixPanel extends JPanel {
	private JComboBox combox;
	public OverviewSixPanel() {
		String[] Database = {"Abonnoment","Profiel","Voortgang","Programma","Aflevering","Serie","Film"};
		combox = new JComboBox(Database);

		add(combox);
	}
}
