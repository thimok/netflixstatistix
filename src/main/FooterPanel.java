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
		
		GridBagLayout bag = new GridBagLayout();
		setLayout(bag);
		
		Border b = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		setBorder(b);
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(20, 20, 20, 20);
		
		footerTitle = new JLabel("Netflix Statistix");
		footerTitle.setFont(FontUtil.FONT_FOOTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		add(footerTitle, c);
		
		footerCourse = new JLabel("Informatica 1.2");
		footerCourse.setFont(FontUtil.FONT_FOOTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		add(footerCourse, c);
		
		footerClass = new JLabel("23ivt1c");
		footerClass.setFont(FontUtil.FONT_FOOTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		add(footerClass, c);
		
		footerNames = new JLabel("Sven / Devon / Thimo");
		footerNames.setFont(FontUtil.FONT_FOOTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		add(footerNames, c);
		
		setBackground(Color.GREEN);
	}
}
