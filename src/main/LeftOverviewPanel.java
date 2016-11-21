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
		
		setLayout(new GridLayout(6,1,0,2));
		setBorder(BorderFactory.createEmptyBorder(0, 5, 300, 0));
		setBackground(new Color(20, 20, 20));
		
		KnopHandler kh = new KnopHandler();
		
		buttonOverviewOne = new MenuButton("Overview 1");
		buttonOverviewOne.setFont(FontUtil.FONT_MENU);
		buttonOverviewOne.addActionListener(kh);
		add(buttonOverviewOne);
		
		buttonOverviewTwo = new MenuButton("Overview 2");
		buttonOverviewTwo.setFont(FontUtil.FONT_MENU);
		buttonOverviewTwo.addActionListener(kh);
		add(buttonOverviewTwo);
		
		buttonOverviewThree = new MenuButton("Overview 3");
		buttonOverviewThree.setFont(FontUtil.FONT_MENU);
		buttonOverviewThree.addActionListener(kh);
		add(buttonOverviewThree);
		
		buttonOverviewFour = new MenuButton("Overview 4");
		buttonOverviewFour.setFont(FontUtil.FONT_MENU);
		buttonOverviewFour.addActionListener(kh);
		add(buttonOverviewFour);
		
		buttonOverviewFive = new MenuButton("Overview 5");
		buttonOverviewFive.setFont(FontUtil.FONT_MENU);
		buttonOverviewFive.addActionListener(kh);
		add(buttonOverviewFive);
		
		buttonOverviewSix = new MenuButton("Overview 6");
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
