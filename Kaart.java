package Weekopdrachten;

public class Kaart {
	String waarde;
	String soort;
	int waardeKaart;
	
	Kaart(String soort, String waarde){
			this.soort = soort;
			this.waarde = waarde;
		}
	
		
	int waardeKaart() {
		if (waarde == "boer" || waarde == "vrouw" ||waarde == "heer") {
			waardeKaart = 10;
		} else if (waarde == "aas") {
			waardeKaart = 11;
		} else {
			waardeKaart = Integer.parseInt(waarde);
		}
		return waardeKaart;
	}

	@Override
	public String toString() {
		return soort + " " + waarde + " " + waardeKaart;
	}
}
