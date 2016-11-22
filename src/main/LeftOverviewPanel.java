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
	private Dimension sizeSingle = new Dimension(200,30);
	private Dimension sizeDouble = new Dimension(200,60);
	
	public LeftOverviewPanel(MainPanel mp) {
		this.mainPanel = mp;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setBackground(new Color(33, 33, 33));
		
		KnopHandler kh = new KnopHandler();
		
		buttonOverviewOne = new MenuButton(StringUtil.OVERVIEW_ONE, sizeSingle);
		buttonOverviewOne.setFont(FontUtil.FONT_MENU);
		buttonOverviewOne.addActionListener(kh);
		//buttonOverviewOne.setToolTipText(StringUtil.OVERVIEW_ONE);
		add(buttonOverviewOne);
		
		add(Box.createVerticalStrut(10));
		
		buttonOverviewTwo = new MenuButton(StringUtil.OVERVIEW_TWO, sizeDouble);
		buttonOverviewTwo.setFont(FontUtil.FONT_MENU);
		buttonOverviewTwo.addActionListener(kh);
		//buttonOverviewTwo.setToolTipText(StringUtil.OVERVIEW_TWO);
		add(buttonOverviewTwo);
		
		add(Box.createVerticalStrut(10));
		
		buttonOverviewThree = new MenuButton(StringUtil.OVERVIEW_THREE, sizeDouble);
		buttonOverviewThree.setFont(FontUtil.FONT_MENU);
		buttonOverviewThree.addActionListener(kh);
		//buttonOverviewThree.setToolTipText(StringUtil.OVERVIEW_THREE);
		add(buttonOverviewThree);
		
		add(Box.createVerticalStrut(10));
		
		buttonOverviewFour = new MenuButton(StringUtil.OVERVIEW_FOUR, sizeDouble);
		buttonOverviewFour.setFont(FontUtil.FONT_MENU);
		buttonOverviewFour.addActionListener(kh);
		//buttonOverviewFour.setToolTipText(StringUtil.OVERVIEW_FOUR);
		add(buttonOverviewFour);
		
		add(Box.createVerticalStrut(10));

		buttonOverviewFive = new MenuButton(StringUtil.OVERVIEW_FIVE, sizeDouble);
		buttonOverviewFive.setFont(FontUtil.FONT_MENU);
		buttonOverviewFive.addActionListener(kh);
		//buttonOverviewFive.setToolTipText(StringUtil.OVERVIEW_FIVE);
		add(buttonOverviewFive);
		
		add(Box.createVerticalStrut(10));
		
		buttonOverviewSix = new MenuButton(StringUtil.OVERVIEW_SIX, sizeSingle);
		buttonOverviewSix.setFont(FontUtil.FONT_MENU);
		buttonOverviewSix.addActionListener(kh);
		//buttonOverviewSix.setToolTipText(StringUtil.OVERVIEW_SIX);
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
