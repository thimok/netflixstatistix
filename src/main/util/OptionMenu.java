package main.util;

import main.util.jiconfont.icons.FontAwesome;
import main.util.jiconfont.swing.IconFontSwing;

import javax.swing.*;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.util.ArrayList;

public class OptionMenu extends JPanel{
	private QueryResult cl;
	static private Icon arrow = IconFontSwing.buildIcon(FontAwesome.CARET_DOWN, 10, ColorUtil.MAIN_TEXT);
	
	public OptionMenu(ArrayList<String> list, String labelt, JEditorPane ta, OverviewPanel p, JLabel l) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel label = new JLabel(labelt);
		JComboBox cb = new JComboBox(list.toArray());
		this.cl = new QueryResult(ta, cb, p, l);
		cb.addItemListener(cl);
		cb.setUI((ComboBoxUI) CustomComboBoxUI.createUI(cb));
		cb.setBackground(ColorUtil.BACKGROUND);
		cb.setForeground(ColorUtil.MAIN_TEXT);
		cb.setRenderer(new cbRenderer());
		cb.setEditor(new cbEditor());
		cb.setBorder(BorderFactory.createMatteBorder(0,0,1,0,ColorUtil.HEADER_TEXT));
		cb.setSelectedIndex(0);
		
		this.setBackground(ColorUtil.BACKGROUND);
		label.setForeground(ColorUtil.MAIN_TEXT);

		this.add(label);
		this.add(Box.createHorizontalStrut(20));
		this.add(cb);
	}
	
	static class CustomComboBoxUI extends BasicComboBoxUI {
		public static ComponentUI createUI(JComponent c) {
			return new CustomComboBoxUI();
		}
		
		@Override
		protected JButton createArrowButton() {
			JButton button = new OptionMenuButton(arrow);
			return button;
		}
	}
	
}
