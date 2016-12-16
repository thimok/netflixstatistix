package main;

import main.overviewfive.OverviewFivePanel;
import main.overviewfour.OverviewFourPanel;
import main.overviewone.OverviewOnePanel;
import main.overviewsix.OverviewSixPanel;
import main.overviewthree.OverviewThreePanel;
import main.overviewtwo.OverviewTwoPanel;
import main.util.ColorUtil;
import main.util.FontUtil;
import main.windowsmenu.WindowsMenuPanel;

import javax.swing.*;
import java.awt.*;
// Hier worden de panels gemaakt
public class MainPanel extends JPanel {
	private LeftOverviewPanel leftControl;
	private FooterPanel footerPanel;
	private WindowsMenuPanel windowsMenuPanel;
	private OverviewOnePanel onePanel;
	private OverviewTwoPanel twoPanel;
	private OverviewThreePanel threePanel;
	private OverviewFourPanel fourPanel;
	private OverviewFivePanel fivePanel;
	private OverviewSixPanel sixPanel;
	private JLabel placeholder;
	private JFrame mainFrame;

	public MainPanel(JFrame mainFrame) {
		setLayout(new BorderLayout());
		setBackground(ColorUtil.BACKGROUND);
		
		this.mainFrame = mainFrame;
		//Nieuwe panels worden hieronder gemaakt
		leftControl = new LeftOverviewPanel(this);
		footerPanel = new FooterPanel();
		windowsMenuPanel = new WindowsMenuPanel(mainFrame);
		onePanel = new OverviewOnePanel();
		twoPanel = new OverviewTwoPanel();
		threePanel = new OverviewThreePanel();
		fourPanel = new OverviewFourPanel();
		fivePanel = new OverviewFivePanel();
		sixPanel = new OverviewSixPanel();

		//Hieronder komt wordt een label gemaakt
		placeholder = new JLabel("Click an item on the left to view the statistix...");
		placeholder.setFont(FontUtil.FONT_PLACEHOLDER);
		placeholder.setForeground(ColorUtil.MAIN_TEXT);
		placeholder.setHorizontalAlignment(JLabel.CENTER);

		//Hier wordt de worden de panels toegevoegd aan de mainpanel
		add(windowsMenuPanel, BorderLayout.NORTH);
		add(leftControl, BorderLayout.WEST);
		add(footerPanel, BorderLayout.SOUTH);
		add(placeholder, BorderLayout.CENTER);
	}

	public void reset() {
		remove(onePanel);
		remove(twoPanel);
		remove(threePanel);
		remove(fourPanel);
		remove(fivePanel);
		remove(sixPanel);
		remove(placeholder);
		
		revalidate();
		repaint();
	}
	
	public void showOne() {
		reset();
		add(onePanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	public void showTwo() {
		reset();
		add(twoPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	public void showThree() {
		reset();
		add(threePanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	public void showFour() {
		reset();
		add(fourPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	public void showFive() {
		reset();
		add(fivePanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	public void showSix() {
		reset();
		add(sixPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
}
