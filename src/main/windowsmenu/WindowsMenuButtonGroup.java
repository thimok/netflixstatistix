package main.windowsmenu;

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
	private JFrame mainFrame;
	private boolean fullscreen = true;
	
	public WindowsMenuButtonGroup(JFrame mainFrame) {
		IconFontSwing.register(FontAwesome.getIconFont());
		Icon wr = IconFontSwing.buildIcon(FontAwesome.WINDOW_RESTORE, 10, new Color(250, 250, 250));
		Icon min = IconFontSwing.buildIcon(FontAwesome.WINDOW_MINIMIZE, 10, new Color(250, 250, 250));
		Icon close = IconFontSwing.buildIcon(FontAwesome.TIMES, 10, new Color(250, 250, 250));
		
		
		this.mainFrame = mainFrame;
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(new Color(33,33,33));
		
		add(Box.createHorizontalGlue());
		
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
	
	class KnopHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == minimizeButton) {
				mainFrame.setState(Frame.ICONIFIED);
			} else if (e.getSource() == sizeButton) {
				mainFrame.dispose();
				if (WindowsMenuButtonGroup.this.fullscreen) {
					mainFrame.setExtendedState(Frame.NORMAL);
					WindowsMenuButtonGroup.this.fullscreen = false;
					StateUtil.CANMOVE = true;
					
				} else {
					mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
					WindowsMenuButtonGroup.this.fullscreen = true;
					StateUtil.CANMOVE = false;
				}
				mainFrame.pack();
				mainFrame.setVisible(true);
			} else if (e.getSource() == closeButton) {
				System.exit(0);
			}
		}
	}
}
