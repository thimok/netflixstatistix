package main;

import main.util.FontUtil;
import main.util.StringUtil;
import main.util.ColorUtil;

import javax.swing.*;
import java.awt.*;

public class FooterPanel extends JPanel {
	private JLabel footerTitle, footerCourse, footerClass, footerNames;
	
	public FooterPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); // Set Layout
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));// set Border
		setBackground(ColorUtil.BACKGROUND_MAIN);// Set background color

		// Creates Titellabel
		footerTitle = new JLabel(StringUtil.COPYRIGHT);
		footerTitle.setFont(FontUtil.FONT_FOOTER);
		footerTitle.setForeground(new Color(250,250,250));
		add(footerTitle);
		add(Box.createHorizontalGlue());
		
		// Creates Courselabel
		footerCourse = new JLabel(StringUtil.COURSE);
		footerCourse.setFont(FontUtil.FONT_FOOTER);
		footerCourse.setForeground(new Color(250,250,250));
		add(footerCourse);
		add(Box.createHorizontalGlue());
		
		//Creates Authorslabel
		footerNames = new JLabel(StringUtil.AUTHORS);
		footerNames.setFont(FontUtil.FONT_FOOTER);
		footerNames.setForeground(new Color(250,250,250));
		add(footerNames);
		add(Box.createHorizontalStrut(20));
		
		//Create classlabel
		footerClass = new JLabel(StringUtil.COURSE_CLASS);
		footerClass.setFont(FontUtil.FONT_FOOTER);
		footerClass.setForeground(new Color(250,250,250));
		add(footerClass);
	}
}
