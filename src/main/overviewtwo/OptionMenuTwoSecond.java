package main.overviewtwo;

import main.overviewone.OneTransactionResult;
import main.overviewone.OneTransactionScript;
import main.overviewone.OneViewItem;
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

public class OptionMenuTwoSecond extends JPanel{
	static private Icon arrow = IconFontSwing.buildIcon(FontAwesome.CARET_DOWN, 10, ColorUtil.MAIN_TEXT);
	private JEditorPane ta;
	private JLabel l;
	private JComboBox cbOther, cb;
	
	public OptionMenuTwoSecond(String labelt, JEditorPane ta, JLabel l) {
		//Set layout to boxlayout
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		//disambiguate variable references
		this.ta = ta;
		this.l = l;
		
		//Create contents (Label, combobox filled with the arraylist)
		JLabel label = new JLabel(labelt);
		ArrayList list = TwoTransactionScript.fillComboBoxTwo();
		this.cb = new JComboBox(list.toArray());
		cb.addItemListener(new QueryResult());
		cb.setUI((ComboBoxUI) CustomComboBoxUI.createUI(cb));
		cb.setBackground(ColorUtil.BACKGROUND);
		cb.setForeground(ColorUtil.MAIN_TEXT);
		cb.setRenderer(new cbRenderer());
		cb.setEditor(new cbEditor());
		cb.setBorder(BorderFactory.createMatteBorder(0,0,1,0,ColorUtil.HEADER_TEXT));
		cb.setSelectedIndex(0);
		
		//Set back- and foreground color
		this.setBackground(ColorUtil.BACKGROUND);
		label.setForeground(ColorUtil.MAIN_TEXT);
		
		//Add contents to the panel
		this.add(label);
		this.add(Box.createHorizontalStrut(20));
		this.add(cb);
	}
	
	//Set the other Combobox for query reasons
	public void setOtherComboBox(JComboBox cbO) {
		this.cbOther = cbO;
	}
	
	//Get method for other class to use this combobox
	public JComboBox getOtherComboBox() {
		return cb;
	}
	
	//Override the combobox properties (look)
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
	
	//When the combobox selection is changed the query will be executed.
	public class QueryResult implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Object item1 = e.getItem();
				Object item2 = cbOther.getSelectedItem();
				ArrayList<TwoViewItem> results = new ArrayList<>();
				if(item2 != null && item1 != null) {
					TwoTransactionResult.displayResultsTwo(results, ta, item1, item2, l);
				}
			}
		}
	}
	
	
	
}
