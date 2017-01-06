package main.overviewone;

import main.util.Connectable;

import java.util.ArrayList;

public class OneTransactionScript{
	
	//Fill the combobox with the optional titels from the database
	static public ArrayList fillComboBox() {
		String QueryIn = "SELECT Titel FROM serie;";
		String Option = "Titel";
		boolean typ_string = true;
		
		ArrayList rs = Connectable.fillComboBox(QueryIn, typ_string, Option);
		return rs;
		
	}
	
	
	
	
}
