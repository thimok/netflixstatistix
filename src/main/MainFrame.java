package main;

import main.util.StateUtil;
import main.util.StringUtil;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
	
	/**
	 * Constructor for a new Frame class
	 */
	public MainFrame() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {

				JFrame frame = MainFrame.this;
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setSize(1500, 1000);
				frame.setPreferredSize(new Dimension(1500, 1000));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Statistix and chill " + StringUtil.VERSION);
				frame.setContentPane(new MainPanel(frame));
				frame.setUndecorated(true);
				
				FrameDragListener frameDragListener = new FrameDragListener();
				frame.addMouseListener(frameDragListener);
				frame.addMouseMotionListener(frameDragListener);
				frame.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(runnable);
	}
	
	class FrameDragListener extends MouseAdapter {
		private Point mouseDownCompCoords = null;
		
		/**
		 * Empty constructor
		 */
		public FrameDragListener() {
			
		}
		
		/**
		 * Event triggered when mouse button is released
		 * @param e MouseEvent type
		 */
		public void mouseReleased(MouseEvent e) {
			if (StateUtil.CANMOVE) {
				mouseDownCompCoords = null;
			}
		}
		
		/**
		 * Event triggered when mouse button is pressed
		 * @param e MouseEvent type
		 */
		public void mousePressed(MouseEvent e) {
			if (StateUtil.CANMOVE) {
				mouseDownCompCoords = e.getPoint();
			}
		}
		
		/**
		 * Event triggered when mouse is dragged
		 * @param e MouseEvent type
		 */
		public void mouseDragged(MouseEvent e) {
			if (StateUtil.CANMOVE) {
				Point currCoords = e.getLocationOnScreen();
				MainFrame.this.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
			}
		}
	}
}
