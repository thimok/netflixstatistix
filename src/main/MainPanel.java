package main;

import main.overviewfive.OverviewFivePanel;
import main.overviewfour.OverviewFourPanel;
import main.overviewone.OverviewOnePanel;
import main.overviewsix.OverviewSixPanel;
import main.overviewthree.OverviewThreePanel;
import main.overviewtwo.OverviewTwoPanel;
import main.util.FontUtil;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
	private LeftOverviewPanel leftControl;
	private FooterPanel footerPanel;
	private OverviewOnePanel onePanel;
	private OverviewTwoPanel twoPanel;
	private OverviewThreePanel threePanel;
	private OverviewFourPanel fourPanel;
	private OverviewFivePanel fivePanel;
	private OverviewSixPanel sixPanel;
	private JLabel placeholder;
	
	public MainPanel() {
		setLayout(new BorderLayout());
		
		leftControl = new LeftOverviewPanel(this);
		footerPanel = new FooterPanel();
		onePanel = new OverviewOnePanel();
		twoPanel = new OverviewTwoPanel();
		threePanel = new OverviewThreePanel();
		fourPanel = new OverviewFourPanel();
		fivePanel = new OverviewFivePanel();
		sixPanel = new OverviewSixPanel();
		
		placeholder = new JLabel("Click an item on the left...");
		placeholder.setFont(FontUtil.FONT_PLACEHOLDER);
		placeholder.setHorizontalAlignment(JLabel.CENTER);
		
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
