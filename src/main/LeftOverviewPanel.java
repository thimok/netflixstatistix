package main;

import main.util.FontUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftOverviewPanel extends JPanel {
	private JButton buttonOverviewOne, buttonOverviewTwo, buttonOverviewThree, buttonOverviewFour, buttonOverviewFive, buttonOverviewSix;
	private MainPanel mainPanel;
	
	public LeftOverviewPanel(MainPanel mp) {
		this.mainPanel = mp;
		
		GridBagLayout bag = new GridBagLayout();
		setLayout(bag);
		
		GridBagConstraints c = new GridBagConstraints();
		
		Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		setBorder(border);
		
		c.insets = new Insets(10, 10, 10, 10);
		
		KnopHandler kh = new KnopHandler();
		
		buttonOverviewOne = new JButton("Overview 1");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		buttonOverviewOne.setFont(FontUtil.FONT_MENU);
		buttonOverviewOne.addActionListener(kh);
		add(buttonOverviewOne, c);
		
		buttonOverviewTwo = new JButton("Overview 2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		buttonOverviewTwo.setFont(FontUtil.FONT_MENU);
		buttonOverviewTwo.addActionListener(kh);
		add(buttonOverviewTwo, c);
		
		buttonOverviewThree = new JButton("Overview 3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		buttonOverviewThree.setFont(FontUtil.FONT_MENU);
		buttonOverviewThree.addActionListener(kh);
		add(buttonOverviewThree, c);
		
		buttonOverviewFour = new JButton("Overview 4");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		buttonOverviewFour.setFont(FontUtil.FONT_MENU);
		buttonOverviewFour.addActionListener(kh);
		add(buttonOverviewFour, c);
		
		buttonOverviewFive = new JButton("Overview 5");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		buttonOverviewFive.setFont(FontUtil.FONT_MENU);
		buttonOverviewFive.addActionListener(kh);
		add(buttonOverviewFive, c);
		
		buttonOverviewSix = new JButton("Overview 6");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		buttonOverviewSix.setFont(FontUtil.FONT_MENU);
		buttonOverviewSix.addActionListener(kh);
		add(buttonOverviewSix, c);
		
		setBackground(Color.RED);
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
