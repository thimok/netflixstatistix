package main.overviewone;

import main.util.ResultPanel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OneViewItem {
	private String serieNaam;
	private int volgnummer;
	private double gemiddeldbekeken;
	
	public OneViewItem(String serieNaam, int volgnummer, double gemiddeldbekeken) {
		this.serieNaam = serieNaam;
		this.volgnummer = volgnummer;
		this.gemiddeldbekeken = gemiddeldbekeken;
	}
	
	public String getSerieNaam() {
		return this.serieNaam;
	}
	
	public int getVolgnummer() {
		return this.volgnummer;
	}
	
	public String getSeasonEpisode() {
		return "" + this.volgnummer;
	}
	
	public double getGemiddeldbekeken() {
		return this.gemiddeldbekeken;
	}
		
}
