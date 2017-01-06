package main.overviewfive;

import main.util.Connectable;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FiveTransactionResult {
	static public void displayResultsFive(JEditorPane ta) {
		//Prepare SQl Query to hit the database
		String query = "SELECT abonnement.Naam FROM abonnement INNER JOIN profiel ON abonnement.AbonneeNr = profiel.AbonneeNr GROUP BY abonnement.AbonneeNr HAVING COUNT(*) = 1;";
		
		//Catch results in resultset
		ResultSet rs = Connectable.executeQuery(query);
		StringBuffer sb = new StringBuffer();
		
		//Print out the results in a stringbuffer
		//If it fails it will throw an SQLException
		if (rs != null) {
			try {
				while (rs.next()) {
					String naam = "<strong>" + rs.getString("abonnement.Naam") + "</strong>";
					sb.append(naam + "<br>");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ta.setText("<div style = 'text-align: center; color: #FAFAFA;'><font face='verdana' size='4'>" + sb.toString() + "</font></div>");
		}
	}
	
	
}
