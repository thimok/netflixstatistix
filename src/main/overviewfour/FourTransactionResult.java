package main.overviewfour;

import main.overviewone.OneViewItem;
import main.util.Connectable;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FourTransactionResult {
	static public void displayResultsFour(JEditorPane ta) {
		String query = "SELECT programma.Titel" +
				" FROM programma" +
				" INNER JOIN film" +
				" ON film.ID = programma.ID" +
				" WHERE film.Leeftijdsindicatie < 16" +
				" ORDER BY programma.Tijdsduur DESC;";
		
		ResultSet rs = Connectable.executeQuery(query);
		StringBuffer sb = new StringBuffer();
		
		if (rs != null) {
			try {
				while (rs.next()) {
					String titel = "<strong>" + rs.getString("programma.Titel") + "</strong>";
					sb.append(titel + "<br><br>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ta.setText("<div style = 'text-align: center; color: #FAFAFA;'><font face='verdana' size='4'>" + sb.toString() + "</font></div>");
		}
	}
}
