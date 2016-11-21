package main;

import main.util.FontUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FooterPanel extends JPanel {
	private JLabel footerTitle, footerCourse, footerClass, footerNames;
	private JLabel separator;
	
	public FooterPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Border b = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		setBorder(b);
		
		footerTitle = new JLabel("Netflix Statistix");
		footerTitle.setFont(FontUtil.FONT_FOOTER);
		add(footerTitle);
		
		add(Box.createRigidArea(new Dimension(25, 0)));
		
		add(new JSeparator(JSeparator.VERTICAL));
		
		add(Box.createRigidArea(new Dimension(25, 0)));
		
		footerCourse = new JLabel("Informatica 1.2");
		footerCourse.setFont(FontUtil.FONT_FOOTER);
		add(footerCourse);
		
		add(Box.createRigidArea(new Dimension(25, 0)));
		
		add(new JSeparator(JSeparator.VERTICAL));
		
		add(Box.createRigidArea(new Dimension(25, 0)));
		
		footerClass = new JLabel("23ivt1c");
		footerClass.setFont(FontUtil.FONT_FOOTER);
		add(footerClass);
		
		add(Box.createRigidArea(new Dimension(25, 0)));
		
		add(new JSeparator(JSeparator.VERTICAL));
		
		add(Box.createRigidArea(new Dimension(25, 0)));
		
		footerNames = new JLabel("Sven / Devon / Thimo");
		footerNames.setFont(FontUtil.FONT_FOOTER);
		add(footerNames);
		
		setBackground(Color.ORANGE);
	}
}
