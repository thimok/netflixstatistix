package main.util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class ResultPanel extends JPanel {
	private JScrollPane sp;
	private JEditorPane ta;
	private OptionMenu option;
	private JLabel l;
	
	public ResultPanel(String QueryIn, String Option, boolean string, OverviewPanel p) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(ColorUtil.BACKGROUND);
		
		ta = new JEditorPane();
		ta.setPreferredSize(new Dimension(500, 500));
		ta.setEditable(false);
		ta.setBackground(ColorUtil.BACKGROUND);
		ta.setForeground(ColorUtil.MAIN_TEXT);
		ta.setBorder(BorderFactory.createMatteBorder(1,0,1,0,ColorUtil.HEADER_TEXT));
		ta.setAlignmentX(Component.CENTER_ALIGNMENT);
		ta.setContentType("text/html");
		
		sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBorder(null);
		
		l = new JLabel();
		l.setFont(FontUtil.FONT_HEADER);
		l.setForeground(ColorUtil.MAIN_TEXT);
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		Dimension d = new Dimension(600,20);
		l.setPreferredSize(d);
		l.setMaximumSize(d);
		l.setMinimumSize(d);
		
		ArrayList<String> optionList = Connectable.fillComboBox(QueryIn, string, Option);
		this.option = new OptionMenu(optionList, (Option + ": "), ta, p, l);
		
		add(option);
		add(Box.createVerticalStrut(50));
		add(l);
		add(Box.createVerticalStrut(10));
		
		add(sp);
		add(Box.createHorizontalGlue());
	}
}
