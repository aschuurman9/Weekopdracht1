package Weekopdrachten;

import java.util.ArrayList;

public class Dealer {
	static int totaalPunten;
	Kaart teGevenKaart;
	ArrayList<Kaart> gekregenKaarten = new ArrayList();
		
	Kaart geefKaart() {
		teGevenKaart = Kaartendek.kaartendek.get(0);
		gekregenKaarten.add(teGevenKaart);
		Kaartendek.kaartendek.remove(0);
		System.out.println(teGevenKaart);
		return teGevenKaart;
	}
	
	void pas() {
		System.out.println(gekregenKaarten);
	}
	
	int telPunten() {
		totaalPunten += teGevenKaart.waardeKaart;
		return totaalPunten;
	}
	
	boolean check21() {
		if(totaalPunten > 21) {
			System.out.println("Helaas je hebt meer dan 21 punten. Game over!");
			BlackJack.doorspelen = false;
		}
		return BlackJack.doorspelen;
	}
	
	
}
