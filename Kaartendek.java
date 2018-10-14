package Weekopdrachten;

import java.util.ArrayList;
import java.util.Collections;

public class Kaartendek {
	String[] soort = {"harten", "ruiten", "schoppen", "klaver"};
	String[] waarde = {"2", "3", "4", "5", "6","7", "8", "9", "10", "boer", "vrouw", "heer", "aas"};
	static ArrayList<Kaart> kaartendek = new ArrayList<>();
	Kaart kaart;
		
	void kaartendekMaken() {
		for(int indexWaarde = 0; indexWaarde < waarde.length; indexWaarde++) {
			for(int indexSoort = 0; indexSoort < soort.length; indexSoort++) {
				Kaart kaart = new Kaart(soort[indexSoort],waarde[indexWaarde] );
				kaart.waardeKaart();
				kaartendek.add(kaart);
			}
		}
	}
	
	void kaartenSchudden() {
		Collections.shuffle(kaartendek);
		System.out.println("Geschudde kaartendek: " + kaartendek);
		System.out.println();
	}
	
	

}