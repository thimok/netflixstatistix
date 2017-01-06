package main.windowsmenu;

import main.util.ColorUtil;
import main.util.FontUtil;
import main.util.WindowsMenuButton;
import main.util.StateUtil;
import main.util.jiconfont.icons.FontAwesome;
import main.util.jiconfont.swing.IconFontSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowsMenuButtonGroup extends JPanel {
	private WindowsMenuButton minimizeButton, sizeButton, closeButton;
	private JLabel header;
	private JFrame mainFrame;
	private Icon max, wr, min, close, favicon;
	
	public WindowsMenuButtonGroup(JFrame mainFrame) {
		//Load icons for the buttons
		IconFontSwing.register(FontAwesome.getIconFont());
		this.min = IconFontSwing.buildIcon(FontAwesome.WINDOW_MINIMIZE, 10, ColorUtil.MAIN_TEXT);
		this.close = IconFontSwing.buildIcon(FontAwesome.TIMES, 10, ColorUtil.MAIN_TEXT);
		this.wr = IconFontSwing.buildIcon(FontAwesome.WINDOW_RESTORE, 10, ColorUtil.MAIN_TEXT);
		this.max = IconFontSwing.buildIcon(FontAwesome.WINDOW_MAXIMIZE, 10, ColorUtil.MAIN_TEXT);
		this.favicon = IconFontSwing.buildIcon(FontAwesome.BAR_CHART, 15, ColorUtil.TITLE);
		
		this.mainFrame = mainFrame;
		
		//Set the layout and background
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(ColorUtil.BACKGROUND_MAIN);
		
		//Add horizontalstrut
		add(Box.createHorizontalStrut(5));
		
		//Create the application Title + (fav)icon
		header = new JLabel("STATISTIX AND CHILL");
		header.setIcon(favicon);
		header.setForeground(ColorUtil.HEADER_TEXT);
		header.setFont(FontUtil.FONT_FOOTER);
		add(header);
		
		add(Box.createHorizontalGlue());
		
		//Create new handler and buttons to operate window functions (Closing, minimizing and resizing)
		KnopHandler kh = new KnopHandler();
		
		minimizeButton = new WindowsMenuButton(min);
		minimizeButton.addActionListener(kh);
		add(minimizeButton);
		
		sizeButton = new WindowsMenuButton(wr);
		sizeButton.addActionListener(kh);
		add(sizeButton);
		
		closeButton = new WindowsMenuButton(close);
		closeButton.addActionListener(kh);
		add(closeButton);
	}
	
	//Handler to operate closing, minimizing and resizing of the frame
	class KnopHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == minimizeButton) {
				mainFrame.setState(Frame.ICONIFIED);
			} else if (e.getSource() == sizeButton) {
				mainFrame.dispose();
				if (StateUtil.FULLSCREEN) {
					mainFrame.setExtendedState(Frame.NORMAL);
					StateUtil.FULLSCREEN = false;
					StateUtil.CANMOVE = true;
					sizeButton.setIcon(max);
					
				} else {
					mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
					StateUtil.FULLSCREEN = true;
					StateUtil.CANMOVE = false;
					sizeButton.setIcon(wr);
				}
				mainFrame.pack();
				mainFrame.setVisible(true);
			} else if (e.getSource() == closeButton) {
				System.exit(0);
			}
		}
	}
}
