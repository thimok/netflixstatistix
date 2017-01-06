package main;

import main.overviewaccount.AccountPanel;
import main.overviewfive.OverviewFivePanel;
import main.overviewfour.OverviewFourPanel;
import main.overviewone.OverviewOnePanel;
import main.overviewprofile.ProfilePanel;
import main.overviewprogress.ProgressPanel;
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
	private AccountPanel accountPanel;
	private ProfilePanel profilePanel;
	private ProgressPanel progressPanel;
	private JLabel placeholder;
	private JFrame mainFrame;

	public MainPanel(JFrame mainFrame) {
		//Set Layout and Background
		setLayout(new BorderLayout());
		setBackground(ColorUtil.BACKGROUND);
		
		this.mainFrame = mainFrame;
		
		//Create all Panels
		leftControl = new LeftOverviewPanel(this);
		footerPanel = new FooterPanel();
		windowsMenuPanel = new WindowsMenuPanel(mainFrame);
		onePanel = new OverviewOnePanel();
		twoPanel = new OverviewTwoPanel();
		threePanel = new OverviewThreePanel();
		fourPanel = new OverviewFourPanel();
		fivePanel = new OverviewFivePanel();
		sixPanel = new OverviewSixPanel();
		accountPanel = new AccountPanel();
		profilePanel = new ProfilePanel();
		progressPanel = new ProgressPanel();

		//Create welcome/placeholder label
		placeholder = new JLabel("<html><center>Welcome to Netflixstatistix<br>Feel free to select an overview on the left</center></html>");
		placeholder.setFont(FontUtil.FONT_PLACEHOLDER);
		placeholder.setForeground(ColorUtil.MAIN_TEXT);
		placeholder.setHorizontalAlignment(JLabel.CENTER);

		//Add all panels to the borderlayout
		add(windowsMenuPanel, BorderLayout.NORTH);
		add(leftControl, BorderLayout.WEST);
		add(footerPanel, BorderLayout.SOUTH);
		add(placeholder, BorderLayout.CENTER);
	}

	//Reset all panels and revalidate and repaint the mainframe
	public void reset() {
		remove(onePanel);
		remove(twoPanel);
		remove(threePanel);
		remove(fourPanel);
		remove(fivePanel);
		remove(sixPanel);
		remove(accountPanel);
		remove(profilePanel);
		remove(progressPanel);
		remove(placeholder);
		
		accountPanel.setState(0);
		profilePanel.setState(0);
		progressPanel.setState(0);
		
		revalidate();
		repaint();
	}
	
	//Show overviewpanel one
	public void showOne() {
		reset();
		add(onePanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	//Show overviewpanel two
	public void showTwo() {
		reset();
		add(twoPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	//Show overviewpanel three
	public void showThree() {
		reset();
		add(threePanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	//Show overviewpanel four
	public void showFour() {
		reset();
		add(fourPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	//Show overviewpanel five
	public void showFive() {
		reset();
		add(fivePanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	//Show overviewpanel six
	public void showSix() {
		reset();
		add(sixPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	//Show account-overviewpanel
	public void showAccount() {
		reset();
		add(accountPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	//Show profile-overviewpanel
	public void showProfile() {
		reset();
		add(profilePanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	//Show progress-overviewpanel
	public void showProgress() {
		reset();
		add(progressPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
}
