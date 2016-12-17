package main.overviewprofile;

import main.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ProfilePanel extends JPanel {
	private int state = 0;
	private GridBagConstraints c;
	
	public ProfilePanel() {
		setBackground(ColorUtil.BACKGROUND);
		
		setLayout(new GridBagLayout());
		
		c = new GridBagConstraints();
		
		updateState();
	}
	
	public void setState(int state) {
		this.state = state;
		updateState();
	}
	
	public void updateState() {
		if (state == 0) {
			removeAll();
			JButton buttonAdd = new MenuButton("Add profile", new Dimension(150, 50));
			buttonAdd.setFont(FontUtil.FONT_MENU);
			buttonAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ProfilePanel.this.state = 1;
					removeAll();
					updateState();
				}
			});
			this.add(buttonAdd);
			
			JButton buttonChange = new MenuButton("Change profile", new Dimension(150, 50));
			buttonChange.setFont(FontUtil.FONT_MENU);
			buttonChange.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ProfilePanel.this.state = 2;
					removeAll();
					updateState();
				}
			});
			this.add(buttonChange);
			
			JButton buttonDelete = new MenuButton("Delete profile", new Dimension(150, 50));
			buttonDelete.setFont(FontUtil.FONT_MENU);
			buttonDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ProfilePanel.this.state = 3;
					removeAll();
					updateState();
				}
			});
			this.add(buttonDelete);
		} else if (state == 1) {
			JLabel header = new JLabel("Add profile");
			header.setFont(FontUtil.FONT_TITLE);
			header.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			this.add(header, c);
			
			JLabel labelUsername = new JLabel("Profile name");
			labelUsername.setFont(FontUtil.FONT_HEADER);
			labelUsername.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			this.add(labelUsername, c);
			
			JTextField fieldUsername = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			this.add(fieldUsername, c);
			
			JLabel labelDate = new JLabel("Birthday (yyyy-MM-dd)");
			labelDate.setFont(FontUtil.FONT_HEADER);
			labelDate.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			this.add(labelDate, c);
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			JFormattedTextField fieldDate = new JFormattedTextField(df);
			fieldDate.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9') ||
							(c == KeyEvent.VK_BACK_SPACE) ||
							(c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_MINUS))) {
						JOptionPane.showMessageDialog(null, "Please enter a valid date format.", "Error", JOptionPane.ERROR_MESSAGE);
						e.consume();
					}
				}
			});
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			this.add(fieldDate, c);
			
			JLabel labelAccountID = new JLabel("Account ID");
			labelAccountID.setFont(FontUtil.FONT_HEADER);
			labelAccountID.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			this.add(labelAccountID, c);
			
			JTextField fieldAccountID = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			this.add(fieldAccountID, c);
			
			JLabel labelSubmit = new JLabel("Submit");
			labelSubmit.setFont(FontUtil.FONT_HEADER);
			labelSubmit.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 4;
			this.add(labelSubmit, c);
			
			JButton buttonSubmit = new MenuButton("Submit", new Dimension(150, 50));
			buttonSubmit.setFont(FontUtil.FONT_MENU);
			buttonSubmit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String profileName = fieldUsername.getText();
					String profileDate = fieldDate.getText();
					int profileID = NumberUtil.parseInt(fieldAccountID.getText());
					
					if (!profileName.isEmpty()) {
						if (!profileDate.isEmpty()) {
							if (!fieldAccountID.getText().isEmpty()) {
								QueryUtil.addProfile(profileName, profileDate, profileID);
								JOptionPane.showMessageDialog(null, "Profile has been added.", "Success", JOptionPane.PLAIN_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "Account ID cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Profile birthday cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Profile name cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
					}
					
					ProfilePanel.this.state = 0;
					removeAll();
					updateState();
				}
			});
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 4;
			this.add(buttonSubmit, c);
		} else if (state == 2) {
			JLabel header = new JLabel("Change profile");
			header.setFont(FontUtil.FONT_TITLE);
			header.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			this.add(header, c);
			
			JLabel labelUsername = new JLabel("Current profile name");
			labelUsername.setFont(FontUtil.FONT_HEADER);
			labelUsername.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			this.add(labelUsername, c);
			
			JTextField fieldUsername = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			this.add(fieldUsername, c);
			
			JLabel labelDate = new JLabel("New birthday (yyyy-MM-dd)");
			labelDate.setFont(FontUtil.FONT_HEADER);
			labelDate.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			this.add(labelDate, c);
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			JFormattedTextField fieldDate = new JFormattedTextField(df);
			fieldDate.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9') ||
							(c == KeyEvent.VK_BACK_SPACE) ||
							(c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_MINUS))) {
						JOptionPane.showMessageDialog(null, "Please enter a valid date format.", "Error", JOptionPane.ERROR_MESSAGE);
						e.consume();
					}
				}
			});
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			this.add(fieldDate, c);
			
			JLabel labelAccountID = new JLabel("Current account ID");
			labelAccountID.setFont(FontUtil.FONT_HEADER);
			labelAccountID.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			this.add(labelAccountID, c);
			
			JTextField fieldAccountID = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			this.add(fieldAccountID, c);
			
			JLabel labelSubmit = new JLabel("Submit");
			labelSubmit.setFont(FontUtil.FONT_HEADER);
			labelSubmit.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 4;
			this.add(labelSubmit, c);
			
			JButton buttonSubmit = new MenuButton("Submit", new Dimension(150, 50));
			buttonSubmit.setFont(FontUtil.FONT_MENU);
			buttonSubmit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String profileName = fieldUsername.getText();
					String profileDate = fieldDate.getText();
					int profileID = NumberUtil.parseInt(fieldAccountID.getText());
					
					if (!profileName.isEmpty()) {
						if (!profileDate.isEmpty()) {
							if (!fieldAccountID.getText().isEmpty()) {
								QueryUtil.changeProfile(profileName, profileDate, profileID);
								JOptionPane.showMessageDialog(null, "Profile has been changed.", "Success", JOptionPane.PLAIN_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "Account ID cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Profile birthday cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Profile name cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
					}
					
					ProfilePanel.this.state = 0;
					removeAll();
					updateState();
				}
			});
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 4;
			this.add(buttonSubmit, c);
		} else if (state == 3) {
			JLabel header = new JLabel("Delete profile");
			header.setFont(FontUtil.FONT_TITLE);
			header.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			this.add(header, c);
			
			JLabel labelUsername = new JLabel("Profile name");
			labelUsername.setFont(FontUtil.FONT_HEADER);
			labelUsername.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			this.add(labelUsername, c);
			
			JTextField fieldUsername = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			this.add(fieldUsername, c);
			
			JLabel labelAccountID = new JLabel("Account ID");
			labelAccountID.setFont(FontUtil.FONT_HEADER);
			labelAccountID.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			this.add(labelAccountID, c);
			
			JTextField fieldAccountID = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			this.add(fieldAccountID, c);
			
			JLabel labelSubmit = new JLabel("Submit");
			labelSubmit.setFont(FontUtil.FONT_HEADER);
			labelSubmit.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			this.add(labelSubmit, c);
			
			JButton buttonSubmit = new MenuButton("Submit", new Dimension(150, 50));
			buttonSubmit.setFont(FontUtil.FONT_MENU);
			buttonSubmit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String profileName = fieldUsername.getText();
					int profileID = NumberUtil.parseInt(fieldAccountID.getText());
					
					if (!profileName.isEmpty()) {
						if (!fieldAccountID.getText().isEmpty()) {
							QueryUtil.deleteProfile(profileName, profileID);
							JOptionPane.showMessageDialog(null, "Profile has been deleted.", "Success", JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Account ID cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Profile name cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
					}
					
					ProfilePanel.this.state = 0;
					removeAll();
					updateState();
				}
			});
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			this.add(buttonSubmit, c);
		}
		
		revalidate();
		repaint();
	}
}
