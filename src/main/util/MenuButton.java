package main.util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuButton extends JButton {
	private Color hover = new Color(240, 240, 240, 20);
	private Color clicked = new Color(240, 240, 240, 80);
	private Color standard = new Color(33, 33, 33);
	private Color textColor = new Color(240, 240, 240, 230);
	
	public MenuButton() {
		this(null);
	}
	
	public MenuButton(String text) {
		super(text);
		super.setContentAreaFilled(false);
		super.setFocusPainted(false);
		super.setForeground(textColor);
		super.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
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
