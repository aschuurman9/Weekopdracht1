package Weekopdrachten;

public class Kaart {
	String waarde;
	String soort;
	int puntenKaart;
	
	Kaart(String soort, String waarde){
			this.soort = soort;
			this.waarde = waarde;
		}
	
		
	int waardeKaart() {
		if (waarde == "boer" || waarde == "vrouw" ||waarde == "heer") {
			puntenKaart = 10;
		} else if (waarde == "aas") {
			puntenKaart = 11;
		} else {
			puntenKaart = Integer.parseInt(waarde);
		}
		return puntenKaart;
	}

	@Override
	public String toString() {
		return soort + " " + waarde;
	}
}
