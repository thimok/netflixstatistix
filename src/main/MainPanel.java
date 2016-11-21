package main;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
	private LeftOverviewPanel leftControl;
	private FooterPanel footerPanel;
	
	public MainPanel() {
		setLayout(new BorderLayout());
		
		leftControl = new LeftOverviewPanel();
		footerPanel = new FooterPanel();
		
		add(leftControl, BorderLayout.WEST);
		add(footerPanel, BorderLayout.SOUTH);
	}
}
