package Weekopdrachten;

public class Kaart {
	String waarde;
	String soort;
	int punten;
	
	Kaart(String soort, String waarde){
			this.soort = soort;
			this.waarde = waarde;
		}
	
		
	int waardeKaart() {
		if (waarde == "boer" || waarde == "vrouw" ||waarde == "heer") {
			punten = 10;
		} else if (waarde == "aas") {
			punten = 11;
		} else {
			punten = Integer.parseInt(waarde);
		}
		return punten;
	}

	@Override
	public String toString() {
		return soort + " " + waarde;
	}
}
