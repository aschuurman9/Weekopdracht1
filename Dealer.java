package Weekopdrachten;

import java.util.ArrayList;

public class Dealer {
	int totaalPunten;
	int puntenDealer;
	Kaart teGevenKaart;
	ArrayList<Kaart> gekregenKaarten = new ArrayList<>();
	ArrayList<Kaart> kaartenDealer = new ArrayList<>();
		
	Kaart geefKaart() {
		teGevenKaart = Kaartendeck.kaartendeck.get(0);
		gekregenKaarten.add(teGevenKaart);
		Kaartendeck.kaartendeck.remove(0);
		System.out.println(teGevenKaart);
		return teGevenKaart;
	}
	
	void pas() {
//		System.out.println(gekregenKaarten);
//		Kaartendek.kaartendek.remove(0);
//		System.out.println("Geschudde kaartendek: " + Kaartendek.kaartendek);
		dealerKaarten();
	}
	
	int telPunten() {
		totaalPunten += teGevenKaart.punten;
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
				gekregenKaarten.get(i).punten = 1;
			}
		}
	}
	
	Kaart dealerPaktKaart() {
		teGevenKaart = Kaartendeck.kaartendeck.get(0);
		System.out.println("Kaart van de dealer: " + teGevenKaart);
		kaartenDealer.add(teGevenKaart);
		Kaartendeck.kaartendeck.remove(0);
		System.out.println("Alle kaarten van de dealer: " + kaartenDealer);
		puntenDealer += teGevenKaart.punten;
		System.out.println("Totaal aantal punten van de dealer: " + puntenDealer);
		return kaartenDealer.get(0);
	}
	
	void dealerKaarten(){
		while (BlackJack.doorspelen != false) {
		dealerPaktKaart();
		if (puntenDealer < 17) {
				System.out.println();
			} else if (puntenDealer > 21 || totaalPunten > puntenDealer ) {
				System.out.println("Gefeliciteerd! Je  hebt gewonnen.");
				BlackJack.doorspelen = false;
			} else if(totaalPunten == puntenDealer){
				System.out.println("Gelijkspel");
			}else {
				System.out.println("Helaas je hebt verloren");
				BlackJack.doorspelen = false;
			}
			
		}
	}


	
}
