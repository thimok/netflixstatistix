package main.overviewprogress;

import main.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressPanel extends JPanel {
	private int state = 0;
	private GridBagConstraints c;
	
	public ProgressPanel() {
		setBackground(ColorUtil.BACKGROUND);
		
		setLayout(new GridBagLayout());
		
		c = new GridBagConstraints();
		
		updateState();
	}
	
	/**
	 * Change the current state of this panel
	 * @param state new state integer
	 */
	public void setState(int state) {
		this.state = state;
		updateState();
	}
	
	/**
	 * Method to show the correct items on the panel, according to the current state
	 */
	public void updateState() {
		if (state == 0) {
			removeAll();
			JButton buttonAdd = new MenuButton("Add progress", new Dimension(150, 50));
			buttonAdd.setFont(FontUtil.FONT_MENU);
			buttonAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ProgressPanel.this.state = 1;
					removeAll();
					updateState();
				}
			});
			this.add(buttonAdd);
			JButton buttonChange = new MenuButton("Change progress", new Dimension(150, 50));
			buttonChange.setFont(FontUtil.FONT_MENU);
			buttonChange.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ProgressPanel.this.state = 2;
					removeAll();
					updateState();
				}
			});
			this.add(buttonChange);
			JButton buttonDelete = new MenuButton("Delete progress", new Dimension(150, 50));
			buttonDelete.setFont(FontUtil.FONT_MENU);
			buttonDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ProgressPanel.this.state = 3;
					removeAll();
					updateState();
				}
			});
			this.add(buttonDelete);
		} else if (state == 1) {
			JLabel header = new JLabel("Add progress");
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
			
			JTextField fieldName = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			this.add(fieldName, c);
			
			JLabel labelAccount = new JLabel("Account ID");
			labelAccount.setFont(FontUtil.FONT_HEADER);
			labelAccount.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			this.add(labelAccount, c);
			
			JTextField fieldAccount = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			this.add(fieldAccount, c);
			
			JLabel labelProgram = new JLabel("Program ID");
			labelProgram.setFont(FontUtil.FONT_HEADER);
			labelProgram.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			this.add(labelProgram, c);
			
			JTextField fieldProgram = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			this.add(fieldProgram, c);
			
			JLabel labelPercentage = new JLabel("Progress");
			labelPercentage.setFont(FontUtil.FONT_HEADER);
			labelPercentage.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 4;
			this.add(labelPercentage, c);
			
			JTextField fieldPercentage = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 4;
			this.add(fieldPercentage, c);
			
			JLabel labelSubmit = new JLabel("Submit");
			labelSubmit.setFont(FontUtil.FONT_HEADER);
			labelSubmit.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 5;
			this.add(labelSubmit, c);
			
			JButton buttonSubmit = new MenuButton("Submit", new Dimension(150, 50));
			buttonSubmit.setFont(FontUtil.FONT_MENU);
			buttonSubmit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String accountName = fieldName.getText();
					int accountID = NumberUtil.parseInt(fieldAccount.getText());
					int programID = NumberUtil.parseInt(fieldProgram.getText());
					int percentage = NumberUtil.parseInt(fieldPercentage.getText());
					
					if (!accountName.isEmpty()) {
						if (!fieldAccount.getText().isEmpty()) {
							if (!fieldProgram.getText().isEmpty()) {
								if (!fieldPercentage.getText().isEmpty()) {
									QueryUtil.addProgress(accountName, accountID, programID, percentage);
									JOptionPane.showMessageDialog(null, "Progress has been added.", "Success", JOptionPane.PLAIN_MESSAGE);
								} else {
									JOptionPane.showMessageDialog(null, "Percentage cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Program ID cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Account ID cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Account name cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
					}
					
					ProgressPanel.this.state = 0;
					removeAll();
					updateState();
				}
			});
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 5;
			this.add(buttonSubmit, c);
		} else if (state == 2) {
			JLabel header = new JLabel("Change progress");
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
			
			JTextField fieldName = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			this.add(fieldName, c);
			
			JLabel labelAccount = new JLabel("Current account ID");
			labelAccount.setFont(FontUtil.FONT_HEADER);
			labelAccount.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			this.add(labelAccount, c);
			
			JTextField fieldAccount = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			this.add(fieldAccount, c);
			
			JLabel labelProgram = new JLabel("Current program ID");
			labelProgram.setFont(FontUtil.FONT_HEADER);
			labelProgram.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			this.add(labelProgram, c);
			
			JTextField fieldProgram = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			this.add(fieldProgram, c);
			
			JLabel labelPercentage = new JLabel("New progress");
			labelPercentage.setFont(FontUtil.FONT_HEADER);
			labelPercentage.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 4;
			this.add(labelPercentage, c);
			
			JTextField fieldPercentage = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 4;
			this.add(fieldPercentage, c);
			
			JLabel labelSubmit = new JLabel("Submit");
			labelSubmit.setFont(FontUtil.FONT_HEADER);
			labelSubmit.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 5;
			this.add(labelSubmit, c);
			
			JButton buttonSubmit = new MenuButton("Submit", new Dimension(150, 50));
			buttonSubmit.setFont(FontUtil.FONT_MENU);
			buttonSubmit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String accountName = fieldName.getText();
					int accountID = NumberUtil.parseInt(fieldAccount.getText());
					int programID = NumberUtil.parseInt(fieldProgram.getText());
					int percentage = NumberUtil.parseInt(fieldPercentage.getText());
					
					if (!accountName.isEmpty()) {
						if (!fieldAccount.getText().isEmpty()) {
							if (!fieldProgram.getText().isEmpty()) {
								if (!fieldPercentage.getText().isEmpty()) {
									QueryUtil.changeProgress(accountName, accountID, programID, percentage);
									JOptionPane.showMessageDialog(null, "Progress has been added.", "Success", JOptionPane.PLAIN_MESSAGE);
								} else {
									JOptionPane.showMessageDialog(null, "Percentage cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Program ID cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Account ID cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Account name cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
					}
					
					ProgressPanel.this.state = 0;
					removeAll();
					updateState();
				}
			});
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 5;
			this.add(buttonSubmit, c);
		} else if (state == 3) {
			JLabel header = new JLabel("Delete progress");
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
			
			JTextField fieldName = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			this.add(fieldName, c);
			
			JLabel labelAccount = new JLabel("Account ID");
			labelAccount.setFont(FontUtil.FONT_HEADER);
			labelAccount.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			this.add(labelAccount, c);
			
			JTextField fieldAccount = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			this.add(fieldAccount, c);
			
			JLabel labelProgram = new JLabel("Program ID");
			labelProgram.setFont(FontUtil.FONT_HEADER);
			labelProgram.setForeground(ColorUtil.MAIN_TEXT);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			this.add(labelProgram, c);
			
			JTextField fieldProgram = new JTextField(20);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			this.add(fieldProgram, c);
			
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
					int accountID = NumberUtil.parseInt(fieldAccount.getText());
					int programID = NumberUtil.parseInt(fieldProgram.getText());
					
					if (!accountName.isEmpty()) {
						if (!fieldAccount.getText().isEmpty()) {
							if (!fieldProgram.getText().isEmpty()) {
								QueryUtil.deleteProgress(accountName, accountID, programID);
								JOptionPane.showMessageDialog(null, "Progress has been deleted.", "Success", JOptionPane.PLAIN_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "Program ID cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Account ID cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Account name cannot be empty.", "Failed", JOptionPane.ERROR_MESSAGE);
					}
					
					ProgressPanel.this.state = 0;
					removeAll();
					updateState();
				}
			});
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 4;
			this.add(buttonSubmit, c);
		}
		
		revalidate();
		repaint();
	}
}
