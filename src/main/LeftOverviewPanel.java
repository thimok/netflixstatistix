package main;

import main.util.FontUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import main.util.*;

public class LeftOverviewPanel extends JPanel {
	private MenuButton buttonOverviewOne, buttonOverviewTwo, buttonOverviewThree, buttonOverviewFour, buttonOverviewFive, buttonOverviewSix;
	private MainPanel mainPanel;
	
	public LeftOverviewPanel(MainPanel mp) {
		this.mainPanel = mp;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setBackground(new Color(33, 33, 33));
		
		KnopHandler kh = new KnopHandler();
		
		buttonOverviewOne = new MenuButton("Serie statistix");
		buttonOverviewOne.setFont(FontUtil.FONT_MENU);
		buttonOverviewOne.addActionListener(kh);
		add(buttonOverviewOne);
		
		add(Box.createVerticalStrut(10));
		
		buttonOverviewTwo = new MenuButton("User and serie statistix");
		buttonOverviewTwo.setFont(FontUtil.FONT_MENU);
		buttonOverviewTwo.addActionListener(kh);
		add(buttonOverviewTwo);
		
		add(Box.createVerticalStrut(10));
		
		buttonOverviewThree = new MenuButton("Movies watched by user");
		buttonOverviewThree.setFont(FontUtil.FONT_MENU);
		buttonOverviewThree.addActionListener(kh);
		add(buttonOverviewThree);
		add(Box.createVerticalStrut(10));
		
		buttonOverviewFour = new MenuButton("Longest movies for under 16s");
		buttonOverviewFour.setFont(FontUtil.FONT_MENU);
		buttonOverviewFour.addActionListener(kh);
		add(buttonOverviewFour);
		
		add(Box.createVerticalStrut(10));

		buttonOverviewFive = new MenuButton("Lonely accounts (equals profit)");
		buttonOverviewFive.setFont(FontUtil.FONT_MENU);
		buttonOverviewFive.addActionListener(kh);
		add(buttonOverviewFive);
		add(Box.createVerticalStrut(10));
		
		buttonOverviewSix = new MenuButton("Movie popularity check");
		buttonOverviewSix.setFont(FontUtil.FONT_MENU);
		buttonOverviewSix.addActionListener(kh);
		add(buttonOverviewSix);
	}
	
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
			}
		}
	}
}
