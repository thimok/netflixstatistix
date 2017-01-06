package main.util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WindowsMenuButton extends JButton {
	private Dimension size = new Dimension(70,30);
	
	//Create and set WindowsMenuButton properties
	public WindowsMenuButton(Icon icon) {
		super(icon);
		super.setContentAreaFilled(false);
		super.setFocusPainted(false);
		super.setForeground(ColorUtil.WINDOW_BUTTON_TEXT);
		super.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		super.setPreferredSize(size);
		super.setMinimumSize(size);
		super.setMaximumSize(size);
		Border padding = BorderFactory.createEmptyBorder(5, 30, 5, 30);
		
		super.setBorder(padding);
	}
	
	//Override the looks of the states of the button
	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isPressed()) {
			g.setColor(ColorUtil.WINDOW_BUTTON_CLICK); //<-- Button changes color when it is pressed
		} else if (getModel().isRollover()) {
			g.setColor(ColorUtil.WINDOW_BUTTON_HOVER); // <-- Button changes color when it is hovered over
		} else {
			g.setColor(ColorUtil.BACKGROUND_MAIN); // <--- Button is set to default set background color
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	
	//Overide needed to change JButton
	@Override
	public void setContentAreaFilled(boolean b) {
	}
}
