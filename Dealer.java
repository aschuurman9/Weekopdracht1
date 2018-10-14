package Weekopdrachten;

import java.util.ArrayList;

public class Dealer {
	static int totaalPunten;
	Kaart teGevenKaart;
	ArrayList<Kaart> gekregenKaarten = new ArrayList<>();
		
	Kaart geefKaart() {
		teGevenKaart = Kaartendek.kaartendek.get(0);
		gekregenKaarten.add(teGevenKaart);
		Kaartendek.kaartendek.remove(0);
		System.out.println(teGevenKaart);
		return teGevenKaart;
	}
	
	void pas() {
		System.out.println(gekregenKaarten);
		Kaartendek.kaartendek.remove(0);
		System.out.println("Geschudde kaartendek: " + Kaartendek.kaartendek);
	}
	
	int telPunten() {
		totaalPunten += teGevenKaart.puntenKaart;
		if(teGevenKaart.waarde.equals("aas") && totaalPunten >21) {
			totaalPunten -= 10;
		}
		return totaalPunten;
	}
	
	boolean check21() {
		if(totaalPunten > 21) {
			aasTellen();
			telPunten();
			System.out.println("Helaas je hebt meer dan 21 punten. Game over!");
			BlackJack.doorspelen = false;
		}
		return BlackJack.doorspelen;
	}
	
	void aasTellen() {
		for(int i = 0 ; i < gekregenKaarten.size()-1;i++) {
			if (gekregenKaarten.get(i).waarde.equals("aas") && totaalPunten > 21) {
				gekregenKaarten.get(i).puntenKaart = 1;
			}
		}
	}
	


	
}
