package main.overviewtwo;

import main.util.ColorUtil;
import main.util.FontUtil;

import javax.swing.*;
import java.awt.*;

public class OverviewTwoPanel extends JPanel {
	private JScrollPane sp;
	private JEditorPane ta;
	private OptionMenuTwoFirst option1;
	private OptionMenuTwoSecond option2;
	private JLabel l;
	
	public OverviewTwoPanel() {
		//Set layout & backgroundcolor
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(ColorUtil.BACKGROUND);
		
		//Create reusable dimension for the different items in the panel
		Dimension ld = new Dimension(600,20);
		Dimension tad = new Dimension(20,600);
		
		//Create and customize a new JEditorPane
		ta = new JEditorPane();
		ta.setMinimumSize(tad);
		ta.setPreferredSize(tad);
		ta.setMaximumSize(tad);
		ta.setEditable(false);
		ta.setBackground(ColorUtil.BACKGROUND);
		ta.setForeground(ColorUtil.MAIN_TEXT);
		ta.setBorder(BorderFactory.createMatteBorder(1,0,1,0,ColorUtil.HEADER_TEXT));
		ta.setContentType("text/html");
		
		//Create and add an JScrollpane to the JEditorPane
		sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBorder(null);
		
		//Create header for information
		l = new JLabel();
		l.setFont(FontUtil.FONT_HEADER);
		l.setForeground(ColorUtil.MAIN_TEXT);
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		l.setMaximumSize(ld);
		l.setPreferredSize(ld);
		l.setMinimumSize(ld);
		
		//Create an optionmenu (JPanel with JCombobox and JLabel) and set the size
		option1 = new OptionMenuTwoFirst("Account: ", ta, l);
		option1.setMinimumSize(ld);
		option1.setMaximumSize(ld);
		
		//Create an optionmenu (JPanel with JCombobox and JLabel) and set the size
		option2 = new OptionMenuTwoSecond("Titel: ", ta, l);
		option2.setMinimumSize(ld);
		option2.setMaximumSize(ld);
		
		//Exchange comboboxes for listeners
		option1.setOtherComboBox(option2.getOtherComboBox());
		option2.setOtherComboBox(option1.getOtherComboBox());
		
		
		//Add compenents and verticalstruts to the panel
		add(Box.createVerticalStrut(10));
		add(option1);
		add(Box.createVerticalStrut(10));
		add(option2);
		add(Box.createVerticalStrut(50));
		add(l);
		add(Box.createVerticalStrut(10));
		add(sp);
		add(Box.createVerticalStrut(10));
		
	}
}
