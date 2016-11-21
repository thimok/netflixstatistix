package main.windowsmenu;

import main.util.WindowsMenuButton;
import main.util.StateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowsMenuButtonGroup extends JPanel {
	private WindowsMenuButton minimizeButton, sizeButton, closeButton;
	private JFrame mainFrame;
	private boolean fullscreen = true;
	
	public WindowsMenuButtonGroup(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(new Color(33,33,33));
		
		add(Box.createHorizontalGlue());
		
		KnopHandler kh = new KnopHandler();
		
		minimizeButton = new WindowsMenuButton("-");
		minimizeButton.addActionListener(kh);
		add(minimizeButton);
		
		sizeButton = new WindowsMenuButton("[]");
		sizeButton.addActionListener(kh);
		add(sizeButton);
		
		closeButton = new WindowsMenuButton("x");
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
