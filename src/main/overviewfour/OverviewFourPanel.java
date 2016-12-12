package main.overviewfour;

import main.util.ColorUtil;

import javax.swing.*;
import java.awt.*;

public class OverviewFourPanel extends JPanel {
	private JComboBox combox;
	private FourTransactionResult result;

	public OverviewFourPanel() {
		this.setBackground(ColorUtil.BACKGROUND);
		result = FourTransactionScript.getInformation();
		
		String[] split = result.displayFormat().split("/");
		
		for (String s : split) {
			System.out.println(s);
			//TODO Add all Strings 's' to panel.
		}
	}
}
