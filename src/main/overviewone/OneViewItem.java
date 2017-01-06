package main.overviewone;

public class OneViewItem {
	private int volgnummer;
	private double gemiddeldbekeken;
	
	//disambiguate variable references
	public OneViewItem(int volgnummer, double gemiddeldbekeken) {
		this.volgnummer = volgnummer;
		this.gemiddeldbekeken = gemiddeldbekeken;
	}
	
	/**
	 *
	 * @return String with the Episode and Season
	 */
	public String getSeasonEpisode() {
		return "" + this.volgnummer;
	}
	
	/**
	 *
	 * @return Double with the average percentage of the item being watched
	 */
	public double getGemiddeldbekeken() {
		return this.gemiddeldbekeken;
	}
		
}
