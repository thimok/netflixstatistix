package main;

import javax.swing.*;

public class Main extends JFrame {
	
	public static void main(String[] args) {
		JFrame frame = new Main();
		frame.setBounds(100, 100, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Statistix and chill + test");
		frame.setContentPane(new MainPanel());
		frame.setVisible(true);
	}
}
