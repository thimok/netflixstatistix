package main.overviewfour;

import main.util.ColorUtil;
import main.util.FontUtil;

import javax.swing.*;
import java.awt.*;

public class OverviewFourPanel extends JPanel {
	private JEditorPane ta;
	private JScrollPane sp;
	private JLabel l;

	public OverviewFourPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(ColorUtil.BACKGROUND);
		
		Dimension ld = new Dimension(600,20);
		Dimension tad = new Dimension(20,600);
		
		ta = new JEditorPane();
		ta.setMinimumSize(tad);
		ta.setPreferredSize(tad);
		ta.setMaximumSize(tad);
		ta.setEditable(false);
		ta.setBackground(ColorUtil.BACKGROUND);
		ta.setForeground(ColorUtil.MAIN_TEXT);
		ta.setBorder(BorderFactory.createMatteBorder(1,0,1,0,ColorUtil.HEADER_TEXT));
		//ta.setAlignmentX(Component.CENTER_ALIGNMENT);
		ta.setContentType("text/html");
		
		sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBorder(null);
		
		l = new JLabel("Longest movies for children under the age of 16");
		l.setFont(FontUtil.FONT_HEADER);
		l.setForeground(ColorUtil.MAIN_TEXT);
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		l.setMaximumSize(ld);
		l.setPreferredSize(ld);
		l.setMinimumSize(ld);
		
		FourTransactionResult.displayResultsFour(ta);
		
		add(Box.createVerticalStrut(60));
		add(l);
		add(Box.createVerticalStrut(10));
		add(sp);
		add(Box.createVerticalStrut(20));
	}
}
