package main.util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuButton extends JButton {
	
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
	
	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isPressed()) {
			g.setColor(ColorUtil.BUTTON_CLICK);
		} else if (getModel().isRollover()) {
			g.setColor(ColorUtil.BUTTON_HOVER);
		} else {
			g.setColor(ColorUtil.BACKGROUND);
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	
	@Override
	public void setContentAreaFilled(boolean b) {
	}
}
