package main.util;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import java.awt.*;

public class cbEditor  extends BasicComboBoxEditor {
	private JLabel label = new JLabel();
	private JPanel panel = new JPanel();
	private Object selectedItem;
	
	public cbEditor() {
		
		label.setOpaque(false);
		label.setFont(new Font("Verdana", Font.BOLD, 14));
		label.setForeground(ColorUtil.MAIN_TEXT);
		
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2));
		panel.add(label);
		panel.setBackground(ColorUtil.BACKGROUND);
	}
	
	public Component getEditorComponent() {
		return this.panel;
	}
	
	public Object getItem() {
		return "[" + this.selectedItem.toString() + "]";
	}
	
	public void setItem(Object item) {
		this.selectedItem = item;
		label.setText(item.toString());
		
	}
}
