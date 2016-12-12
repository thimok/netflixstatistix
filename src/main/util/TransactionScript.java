package main.util;

import main.overviewone.OneViewItem;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

abstract public class TransactionScript {
	
	static public ArrayList fillComboBox() {
		String QueryIn = "";
		String option = "";
		boolean typ_string = true;
		
		ArrayList rs = Connectable.fillComboBox(QueryIn, typ_string, option);
		return rs;
	}
}
