package main;

import main.util.StringUtil;

import javax.swing.*;

public class Main extends JFrame {
	
	public static void main(String[] args) {
		JFrame frame = new Main();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Statistix and chill " + StringUtil.VERSION);
		frame.setContentPane(new MainPanel());
		frame.setVisible(true);
	}
}
