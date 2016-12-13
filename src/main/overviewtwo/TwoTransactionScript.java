package main.overviewtwo;

import main.util.Connectable;

import java.util.ArrayList;

public class TwoTransactionScript {
	static public ArrayList fillComboBoxOne() {
		String QueryIn = "SELECT Naam FROM Abonnement;";
		String Option = "Naam";
		boolean typ_string = true;
		
		ArrayList rs = Connectable.fillComboBox(QueryIn, typ_string, Option);
		return rs;
		
	}
	static public ArrayList fillComboBoxTwo() {
		String QueryIn = "SELECT Titel FROM serie;";
		String Option = "Titel";
		boolean typ_string = true;
		
		ArrayList rs = Connectable.fillComboBox(QueryIn, typ_string, Option);
		return rs;
		
	}
}
