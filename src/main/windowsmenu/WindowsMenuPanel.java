package main.windowsmenu;

import main.util.FontUtil;
import main.util.StringUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WindowsMenuPanel extends JPanel {
	private JLabel title;
	private WindowsMenuButtonGroup buttonGroup;
	private JFrame mainFrame;
	
	public WindowsMenuPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		setLayout(new BorderLayout());
		
		Border b = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		setBorder(b);
		
		title = new JLabel("Statistix and chill " + StringUtil.VERSION + " (for " + System.getProperty("os.name") + ") | Welcome back, " + System.getProperty("user.name") + "!");
		title.setFont(FontUtil.FONT_MENUBAR);
		title.setForeground(Color.BLACK);
		add(title, BorderLayout.WEST);
		
		buttonGroup = new WindowsMenuButtonGroup(mainFrame);
		add(buttonGroup, BorderLayout.EAST);
		
		setBackground(Color.LIGHT_GRAY);
	}
}
