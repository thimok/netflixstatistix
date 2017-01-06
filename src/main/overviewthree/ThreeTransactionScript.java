package main.overviewthree;

import main.util.Connectable;

import java.util.ArrayList;

public class ThreeTransactionScript {
	//Fill the combobox with the optional accountnames from the database
	static public ArrayList fillComboBox() {
		String QueryIn = "SELECT Naam FROM Abonnement;";
		String Option = "Naam";
		boolean typ_string = true;
		
		ArrayList rs = Connectable.fillComboBox(QueryIn, typ_string, Option);
		return rs;
		
	}
}
