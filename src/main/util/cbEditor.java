package main.util;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import java.awt.*;

public class cbEditor  extends BasicComboBoxEditor {
	private JLabel label = new JLabel();
	private JPanel panel = new JPanel();
	private Object selectedItem;
	
	//Override the properties of the normal JCombobox
	public cbEditor() {
		
		label.setOpaque(false);
		label.setFont(new Font("Verdana", Font.BOLD, 14));
		label.setForeground(ColorUtil.MAIN_TEXT);
		
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2));
		panel.add(label);
		panel.setBackground(ColorUtil.BACKGROUND);
	}
	
	/**
	 *
	 * @return the combobox
	 */
	public Component getEditorComponent() {
		return this.panel;
	}
	
	/**
	 *
	 * @return the selected item
	 */
	public Object getItem() {
		return "[" + this.selectedItem.toString() + "]";
	}
	
	/**
	 * Set the selected item
	 * @param item
	 */
	public void setItem(Object item) {
		this.selectedItem = item;
		label.setText(item.toString());
		
	}
}
