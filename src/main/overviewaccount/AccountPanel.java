package main.overviewaccount;

import main.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountPanel extends JPanel {
	private int state = 0;
	private GridBagConstraints c;
	
	public AccountPanel() {
		setBackground(ColorUtil.BACKGROUND);
		
		setLayout(new GridBagLayout());
		
		c = new GridBagConstraints();
		
		updateState();
	}
	
	/**
	 * Set state of the panel
	 * @param state state integer
	 */
	public void setState(int state) {
		this.state = state;
		updateState();
	}
	
	/**
	 * Update state. Checks which state is active, then shows the correct items on the screen.
	 */
	public void updateState() {
		if (state == 0) {
			removeAll();
			JButton buttonAdd = new MenuButton("Add account", new Dimension(150, 50));
			buttonAdd.setFont(FontUtil.FONT_MENU);
			buttonAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AccountPanel.this.state = 1;
					removeAll();
					updateState();
				}
			});
			this.add(buttonAdd);
			
			JButton buttonChange = new MenuButton("Change account", new Dimension(150, 50));
			buttonChange.setFont(FontUtil.FONT_MENU);
			buttonChange.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AccountPanel.this.state = 2;
					removeAll();
					updateState();
				}
			});
			this.add(buttonChange);
			
			JButton buttonDelete = new MenuButton("Delete account", new Dimension(150, 50));
			buttonDelete.setFont(FontUtil.FONT_MENU);
			buttonDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AccountPanel.this.state = 3;
					removeAll();
					updateState();
				}
			});
			this.add(buttonDelete);
		} else if (state == 1) {
			JLabel header = new JLabel("Add account");
			header.setFont(FontUtil.FONT_TITLE);
			header.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			this.add(header, c);
			
			JLabel labelUsername = new JLabel("Username");
			labelUsername.setFont(FontUtil.FONT_HEADER);
			labelUsername.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			this.add(labelUsername, c);
			
			JTextField fieldName = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			this.add(fieldName, c);
			
			JLabel labelAddress = new JLabel("Address");
			labelAddress.setFont(FontUtil.FONT_HEADER);
			labelAddress.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			this.add(labelAddress, c);
			
			JTextField fieldAddress = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			this.add(fieldAddress, c);
			
			JLabel labelTown = new JLabel("Hometown");
			labelTown.setFont(FontUtil.FONT_HEADER);
			labelTown.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			this.add(labelTown, c);
			
			JTextField fieldTown = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			this.add(fieldTown, c);
			
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
					String accountName = fieldName.getText();
					String accountAddress = fieldAddress.getText();
					String accountTown = fieldTown.getText();
					
					if (!accountName.isEmpty()) {
						if (!accountAddress.isEmpty()) {
							if (!accountTown.isEmpty()) {
								QueryUtil.addAccount(accountName, accountAddress, accountTown);
								JOptionPane.showMessageDialog(null, "Account has been added.", "Success", JOptionPane.PLAIN_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "Hometown cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Address cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Account name cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
					}
					
					AccountPanel.this.state = 0;
					removeAll();
					updateState();
				}
			});
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 4;
			this.add(buttonSubmit, c);
		} else if (state == 2) {
			JLabel header = new JLabel("Change account");
			header.setFont(FontUtil.FONT_TITLE);
			header.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			this.add(header, c);
			
			JLabel labelUsername = new JLabel("Username");
			labelUsername.setFont(FontUtil.FONT_HEADER);
			labelUsername.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			this.add(labelUsername, c);
			
			JTextField fieldName = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			this.add(fieldName, c);
			
			JLabel labelAddress = new JLabel("New address");
			labelAddress.setFont(FontUtil.FONT_HEADER);
			labelAddress.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			this.add(labelAddress, c);
			
			JTextField fieldAddress = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			this.add(fieldAddress, c);
			
			JLabel labelTown = new JLabel("New hometown");
			labelTown.setFont(FontUtil.FONT_HEADER);
			labelTown.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			this.add(labelTown, c);
			
			JTextField fieldTown = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			this.add(fieldTown, c);
			
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
					String accountName = fieldName.getText();
					String accountAddress = fieldAddress.getText();
					String accountTown = fieldTown.getText();
					
					if (!accountName.isEmpty()) {
						if (!accountAddress.isEmpty()) {
							if (!accountTown.isEmpty()) {
								QueryUtil.changeAccount(accountName, accountAddress, accountTown);
								JOptionPane.showMessageDialog(null, "Account has been changed.", "Success", JOptionPane.PLAIN_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "Hometown cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Address cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Account name cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
					}
					
					AccountPanel.this.state = 0;
					removeAll();
					updateState();
				}
			});
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 4;
			this.add(buttonSubmit, c);
		} else if (state == 3) {
			JLabel header = new JLabel("Delete account");
			header.setFont(FontUtil.FONT_TITLE);
			header.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			this.add(header, c);
			
			JLabel labelID = new JLabel("User ID");
			labelID.setFont(FontUtil.FONT_HEADER);
			labelID.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			this.add(labelID, c);
			
			JTextField fieldID = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			this.add(fieldID, c);
			
			JLabel labelSubmit = new JLabel("Submit");
			labelSubmit.setFont(FontUtil.FONT_HEADER);
			labelSubmit.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			this.add(labelSubmit, c);
			
			JButton buttonSubmit = new MenuButton("Submit", new Dimension(150, 50));
			buttonSubmit.setFont(FontUtil.FONT_MENU);
			buttonSubmit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (fieldID.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "User ID cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
						AccountPanel.this.state = 0;
						removeAll();
						updateState();
					} else {
						int userID = NumberUtil.parseInt(fieldID.getText());
						
						QueryUtil.deleteAccount(userID);
						
						JOptionPane.showMessageDialog(null, "User deleted.", "Success", JOptionPane.PLAIN_MESSAGE);
						
						AccountPanel.this.state = 0;
						removeAll();
						updateState();
					}
				}
			});
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			this.add(buttonSubmit, c);
		}
		
		revalidate();
		repaint();
	}
}
