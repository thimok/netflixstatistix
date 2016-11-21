package main.util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WindowsMenuButton extends JButton {
	private Color hover = new Color(211, 47, 47, 230);
	private Color clicked = new Color(211, 47, 47);
	private Color standard = new Color(33, 33, 33);
	private Color textColor = new Color(240, 240, 240);
	private Dimension size = new Dimension(70,30);
	
	public WindowsMenuButton() {
		this(null);
	}
	
	public WindowsMenuButton(String text) {
		super(text);
		super.setContentAreaFilled(false);
		super.setFocusPainted(false);
		super.setForeground(textColor);
		super.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		super.setPreferredSize(size);
		super.setMinimumSize(size);
		super.setMaximumSize(size);
		Border padding = BorderFactory.createEmptyBorder(5, 30, 5, 30);
		
		super.setBorder(padding);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isPressed()) {
			g.setColor(clicked);
		} else if (getModel().isRollover()) {
			g.setColor(hover);
		} else {
			g.setColor(standard);
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	
	@Override
	public void setContentAreaFilled(boolean b) {
	}
}
