package main.overviewsix;

import main.util.Connectable;

import java.util.ArrayList;

public class SixTransactionScript {
	//Fill the combobox with the optional titels from the database
	static public ArrayList fillComboBox() {
		String QueryIn = "SELECT programma.Titel FROM programma INNER JOIN film ON film.ID = programma.ID ";
		String Option = "Titel";
		boolean typ_string = true;
		
		ArrayList rs = Connectable.fillComboBox(QueryIn, typ_string, Option);
		return rs;
		
	}
}
