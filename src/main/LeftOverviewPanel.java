package main;

import main.util.FontUtil;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.*;
import main.util.*;
import main.util.ColorUtil;
// Left overviewPanel is created here
public class LeftOverviewPanel extends JPanel {
	private MenuButton buttonOverviewOne, buttonOverviewTwo, buttonOverviewThree, buttonOverviewFour, buttonOverviewFive, buttonOverviewSix, buttonAccount, buttonProfile, buttonProgress;
	private MainPanel mainPanel;
	private Dimension sizeSingle = new Dimension(150,30);
	private Dimension sizeDouble = new Dimension(150,50);
	
	public LeftOverviewPanel(MainPanel mp) {
		this.mainPanel = mp;
		
		//Set Layout, background and borders
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 0, 1, ColorUtil.BACKGROUND_MAIN),
				BorderFactory.createEmptyBorder(5, 5, 15, 19)));
		setBackground(ColorUtil.BACKGROUND);
		
		//Create new Handler to repaint the displayframe
		KnopHandler kh = new KnopHandler();
		
		//Create the menubuttons
		//Add vertical struts and glues to enhance the layout
		buttonOverviewOne = new MenuButton(StringUtil.OVERVIEW_ONE, sizeSingle);
		buttonOverviewOne.setFont(FontUtil.FONT_MENU);
		buttonOverviewOne.addActionListener(kh);
		add(buttonOverviewOne);
		
		add(Box.createVerticalStrut(10));
		
		buttonOverviewTwo = new MenuButton(StringUtil.OVERVIEW_TWO, sizeDouble);
		buttonOverviewTwo.setFont(FontUtil.FONT_MENU);
		buttonOverviewTwo.addActionListener(kh);
		add(buttonOverviewTwo);
		
		add(Box.createVerticalStrut(10));
		
		buttonOverviewThree = new MenuButton(StringUtil.OVERVIEW_THREE, sizeDouble);
		buttonOverviewThree.setFont(FontUtil.FONT_MENU);
		buttonOverviewThree.addActionListener(kh);
		add(buttonOverviewThree);
		
		add(Box.createVerticalStrut(10));
		
		buttonOverviewFour = new MenuButton(StringUtil.OVERVIEW_FOUR, sizeDouble);
		buttonOverviewFour.setFont(FontUtil.FONT_MENU);
		buttonOverviewFour.addActionListener(kh);
		add(buttonOverviewFour);
		
		add(Box.createVerticalStrut(10));

		buttonOverviewFive = new MenuButton(StringUtil.OVERVIEW_FIVE, sizeDouble);
		buttonOverviewFive.setFont(FontUtil.FONT_MENU);
		buttonOverviewFive.addActionListener(kh);
		add(buttonOverviewFive);
		
		add(Box.createVerticalStrut(10));
		
		buttonOverviewSix = new MenuButton(StringUtil.OVERVIEW_SIX, sizeDouble);
		buttonOverviewSix.setFont(FontUtil.FONT_MENU);
		buttonOverviewSix.addActionListener(kh);
		add(buttonOverviewSix);
		
		add(Box.createVerticalGlue());
		
		buttonAccount = new MenuButton(StringUtil.OVERVIEW_ACCOUNT, sizeSingle);
		buttonAccount.setFont(FontUtil.FONT_MENU);
		buttonAccount.addActionListener(kh);
		add(buttonAccount);
		
		add(Box.createVerticalStrut(10));
		
		buttonProfile = new MenuButton(StringUtil.OVERVIEW_PROFILE, sizeSingle);
		buttonProfile.setFont(FontUtil.FONT_MENU);
		buttonProfile.addActionListener(kh);
		add(buttonProfile);
		
		add(Box.createVerticalStrut(10));
		
		buttonProgress = new MenuButton(StringUtil.OVERVIEW_PROGRESS, sizeSingle);
		buttonProgress.setFont(FontUtil.FONT_MENU);
		buttonProgress.addActionListener(kh);
		add(buttonProgress);
		
		add(Box.createVerticalStrut(10));
	}
	
	//Repaint to the selected panel when the button is pressed
	class KnopHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonOverviewOne) {
				mainPanel.showOne();
			} else if (e.getSource() == buttonOverviewTwo) {
				mainPanel.showTwo();
			} else if (e.getSource() == buttonOverviewThree) {
				mainPanel.showThree();
			} else if (e.getSource() == buttonOverviewFour) {
				mainPanel.showFour();
			} else if (e.getSource() == buttonOverviewFive) {
				mainPanel.showFive();
			} else if (e.getSource() == buttonOverviewSix) {
				mainPanel.showSix();
			} else if (e.getSource() == buttonAccount) {
				mainPanel.showAccount();
			} else if (e.getSource() == buttonProfile) {
				mainPanel.showProfile();
			} else if (e.getSource() == buttonProgress) {
				mainPanel.showProgress();
			}
		}
	}
}
