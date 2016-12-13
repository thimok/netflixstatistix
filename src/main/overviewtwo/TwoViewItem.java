package main.overviewtwo;

public class TwoViewItem {
	private int volgnummer;
	private double gemiddeldbekeken;
	
	public TwoViewItem(int volgnummer, double gemiddeldbekeken) {
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
