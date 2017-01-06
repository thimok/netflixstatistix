package main.util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuButton extends JButton {
	
	//Create and set OptionMenuButton properties
	public MenuButton(String text, Dimension size) {
		super(text);
		super.setContentAreaFilled(false);
		super.setFocusPainted(false);
		super.setForeground(ColorUtil.BUTTON_TEXT);
		super.setHorizontalAlignment(JButton.LEFT);
		super.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		super.setPreferredSize(size);
		super.setMinimumSize(size);
		super.setMaximumSize(size);
		Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		super.setBorder(padding);
	}
	
	//Override the looks of the states of the button
	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isPressed()) {
			g.setColor(ColorUtil.BUTTON_CLICK); //<-- Button changes color when it is pressed
		} else if (getModel().isRollover()) {
			g.setColor(ColorUtil.BUTTON_HOVER); // <-- Button changes color when it is hovered over
		} else {
			g.setColor(ColorUtil.BACKGROUND); // <--- Button is set to default set background color
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	
	//Overide needed to change JButton
	@Override
	public void setContentAreaFilled(boolean b) {
	}
}
