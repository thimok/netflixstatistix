package main.overviewthree;

import main.overviewone.OneTransactionResult;
import main.overviewone.OneTransactionScript;
import main.overviewone.OneViewItem;
import main.overviewone.OptionMenuOne;
import main.util.ColorUtil;
import main.util.OptionMenuButton;
import main.util.cbEditor;
import main.util.cbRenderer;
import main.util.jiconfont.icons.FontAwesome;
import main.util.jiconfont.swing.IconFontSwing;

import javax.swing.*;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class OptionMenuThree extends JPanel{
	static private Icon arrow = IconFontSwing.buildIcon(FontAwesome.CARET_DOWN, 10, ColorUtil.MAIN_TEXT);
	private JEditorPane ta;
	private JLabel l;
	
	public OptionMenuThree(String labelt, JEditorPane ta, JLabel l) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.ta = ta;
		this.l = l;
		
		JLabel label = new JLabel(labelt);
		ArrayList list = ThreeTransactionScript.fillComboBox();
		JComboBox cb = new JComboBox(list.toArray());
		cb.addItemListener(new OptionMenuThree.QueryResult());
		cb.setUI((ComboBoxUI) OptionMenuThree.CustomComboBoxUI.createUI(cb));
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
			return new OptionMenuThree.CustomComboBoxUI();
		}
		
		@Override
		protected JButton createArrowButton() {
			JButton button = new OptionMenuButton(arrow);
			return button;
		}
	}
	
	public class QueryResult implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Object item1 = e.getItem();
				ThreeTransactionResult.displayResultsThree(ta, item1, l);
			}
		}
	}
}