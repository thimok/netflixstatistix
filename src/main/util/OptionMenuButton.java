package main.util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OptionMenuButton extends JButton{
	
	public OptionMenuButton(Icon icon) {
		super(icon);
		super.setContentAreaFilled(false);
		super.setFocusPainted(false);
		super.setForeground(ColorUtil.BUTTON_TEXT);
		super.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Border padding = BorderFactory.createEmptyBorder(5, 30, 5, 30);
		
		super.setBorder(padding);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isPressed()) {
			g.setColor(ColorUtil.BUTTON_HOVER); //<-- knop wordt lichter als je er op klikt
		} else if (getModel().isRollover()) {
			g.setColor(ColorUtil.BUTTON_CLICK); // <-- button highlight wanneer muis erover zweeft
		} else {
			g.setColor(ColorUtil.BACKGROUND); // <--- als er geen muis er overheen zweeft en als er niet op geklikt wordt gebeurt er niks
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	
	@Override
	public void setContentAreaFilled(boolean b) {
	}
}
