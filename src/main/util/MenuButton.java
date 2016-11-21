package main.util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuButton extends JButton {
<<<<<<< HEAD
	private Color hover = new Color(240, 240, 240, 20);
	private Color clicked = new Color(240, 240, 240, 80);
	private Color standard = new Color(33, 33, 33);
	private Color textColor = new Color(240, 240, 240, 230);
=======
	protected Color hover = new Color(239, 83, 80);
	protected Color clicked = new Color(229, 57, 53);
	protected Color standard = new Color(244, 67, 54);
	protected Color textColor = new Color(33, 33, 33);
>>>>>>> 51edb7352f96c310338de3d2568ce94536ab0b21
	
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
