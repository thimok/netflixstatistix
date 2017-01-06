package main.util;

import javax.swing.*;
import java.awt.*;

public class cbRenderer extends JLabel implements ListCellRenderer {
	//Override the properties of the normal JCombobox
	public cbRenderer() {
		setOpaque(true);
		setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		setBackground(ColorUtil.BACKGROUND);
		setForeground(ColorUtil.MAIN_TEXT);
	}
	
	//Override the properties of the normal JCombobox
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		setText(value.toString());
		if(isSelected){
			setBackground(ColorUtil.TITLE);
			setForeground(ColorUtil.MAIN_TEXT);
		} else {
			setBackground(ColorUtil.BACKGROUND);
			setForeground(ColorUtil.MAIN_TEXT);
		}
		return this;
	}
}
