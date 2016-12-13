package main.overviewone;

public class OneViewItem {
	private int volgnummer;
	private double gemiddeldbekeken;
	
	public OneViewItem(int volgnummer, double gemiddeldbekeken) {
		this.volgnummer = volgnummer;
		this.gemiddeldbekeken = gemiddeldbekeken;
	}
	
	public String getSeasonEpisode() {
		return "" + this.volgnummer;
	}
	
	public double getGemiddeldbekeken() {
		return this.gemiddeldbekeken;
	}
		
}
