package main.windowsmenu;

import main.util.FontUtil;
import main.util.StringUtil;
import main.util.ColorUtil;

import javax.swing.*;
import java.awt.*;

public class WindowsMenuPanel extends JPanel {
	private JLabel title, version, user;
	private WindowsMenuButtonGroup buttonGroup;
	private JFrame mainFrame;
	
	public WindowsMenuPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		setBackground(ColorUtil.BACKGROUND_MAIN);
		
		buttonGroup = new WindowsMenuButtonGroup(mainFrame);
		add(buttonGroup);
		
		title = new JLabel("STATISTIX AND CHILL");
		title.setFont(FontUtil.FONT_TITLE);
		title.setForeground(ColorUtil.TITLE);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(title);
		
		version = new JLabel(StringUtil.VERSION + " (for " + System.getProperty("os.name") + ")");
		version.setForeground(ColorUtil.SUBTITLE);
		version.setFont(FontUtil.FONT_VERSION);
		version.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(version);
		
		add(Box.createVerticalStrut(10));
		
		user = new JLabel("Welcome back, " + System.getProperty("user.name") + "!");
		user.setForeground(ColorUtil.MAIN_TEXT);
		user.setFont(FontUtil.FONT_SUBTITLE);
		user.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(user);
	}
}
