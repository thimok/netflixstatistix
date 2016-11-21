package main;

import main.util.StringUtil;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		JFrame frame = this;
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(750, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Statistix and chill " + StringUtil.VERSION);
		frame.setContentPane(new MainPanel(this));
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	
	public void test() {
		System.out.println("Test");
	}
}
