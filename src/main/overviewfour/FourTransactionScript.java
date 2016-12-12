package main.overviewfour;

import main.util.Connectable;

import java.sql.ResultSet;

public class FourTransactionScript {
	
	public static FourTransactionResult getInformation() {
		FourTransactionResult result = new FourTransactionResult();
		
		String query = "SELECT programma.Titel" +
				" FROM programma" +
				" INNER JOIN film" +
				" ON film.ID = programma.ID" +
				" WHERE film.Leeftijdsindicatie < 16" +
				" ORDER BY programma.Tijdsduur DESC;";
		
		ResultSet rs = Connectable.executeQuery(query);
		String format = "";
		
		if (rs != null) {
			try {
				while (rs.next()) {
					format += rs.getString("programma.Titel");
					format += "/";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			result.setFormat(format.substring(0, format.length() - 1));
		}
		
		return result;
	}
}
