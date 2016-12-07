package main.overviewthree;

import javax.swing.*;
import java.awt.*;

public class OverviewThreePanel extends JPanel {
	private JComboBox combox;
	public OverviewThreePanel() {
		String[] Database = {"Abonnoment","Profiel","Voortgang","Programma","Aflevering","Serie","Film"};
		combox = new JComboBox(Database);

		add(combox);
	}
}
