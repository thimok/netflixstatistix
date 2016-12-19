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
	
	/**
	 * Constructor for the panel in the main frame
	 * @param mainFrame Frame instance
	 */
	public MainPanel(JFrame mainFrame) {
		setLayout(new BorderLayout());
		setBackground(ColorUtil.BACKGROUND);
		
		this.mainFrame = mainFrame;
		
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
		
		placeholder = new JLabel("Click an item on the left to view the statistix...");
		placeholder.setFont(FontUtil.FONT_PLACEHOLDER);
		placeholder.setForeground(ColorUtil.MAIN_TEXT);
		placeholder.setHorizontalAlignment(JLabel.CENTER);
		
		add(windowsMenuPanel, BorderLayout.NORTH);
		add(leftControl, BorderLayout.WEST);
		add(footerPanel, BorderLayout.SOUTH);
		add(placeholder, BorderLayout.CENTER);
	}
	
	/**
	 * Reset the panel (remove everything)
	 */
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
	
	/**
	 * Show panel 1
	 */
	public void showOne() {
		reset();
		add(onePanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	/**
	 * Show panel 2
	 */
	public void showTwo() {
		reset();
		add(twoPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	/**
	 * Show panel 3
	 */
	public void showThree() {
		reset();
		add(threePanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	/**
	 * Show panel 4
	 */
	public void showFour() {
		reset();
		add(fourPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	/**
	 * Show panel 5
	 */
	public void showFive() {
		reset();
		add(fivePanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	/**
	 * Show panel 6
	 */
	public void showSix() {
		reset();
		add(sixPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	/**
	 * Show account CRUD
	 */
	public void showAccount() {
		reset();
		add(accountPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	/**
	 * Show profile CRUD
	 */
	public void showProfile() {
		reset();
		add(profilePanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	/**
	 * Show progress CRUD
	 */
	public void showProgress() {
		reset();
		add(progressPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
}
