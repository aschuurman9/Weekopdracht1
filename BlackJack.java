package Weekopdrachten;

import java.util.Scanner;

public class BlackJack {
	static boolean doorspelen = true;
	Scanner scanner = new Scanner(System.in);
	Dealer dealer = new Dealer();
	
	BlackJack(){
		System.out.println("Welkom bij BlackJack \nMaak een keuze: \n");
	}

	void starten() {
		toonBeginMenu();
		String invoer = scanner.nextLine();
		verwerkenInvoer(invoer);
		while (doorspelen) {
			toonMenu();
			String invoerMenu = scanner.nextLine();
			verwerkenInvoer(invoerMenu);
		}
	}
	
	void toonBeginMenu() {
		System.out.println("s start nieuw spel");
		System.out.println("q stop spel");
		System.out.println();
	}

	
	void toonMenu() {
		System.out.println();
		System.out.println("k kaart");
		System.out.println("p pas");
		System.out.println("q stop spel");
		System.out.println();
	}

	void verwerkenInvoer(String deInvoer) {
		switch (deInvoer) {
		case "s":
			System.out.println("spel start");
			Kaartendek kaartendek = new Kaartendek();
			kaartendek.kaartendekMaken();
			kaartendek.kaartenSchudden();
			System.out.println("De eerste 2 kaarten: ");
			dealer.geefKaart();
			dealer.telPunten();
			dealer.geefKaart();
			dealer.telPunten();
			System.out.println("Totaal aantal punten: " + Dealer.totaalPunten);
			dealer.check21();
			break;
		case "k":
			System.out.println("kaart");
			dealer.geefKaart();
			dealer.telPunten();
			System.out.println("Totaal aantal punten: " + Dealer.totaalPunten);
			dealer.check21();
			break;
		case "p":
			System.out.println("passen");
			System.out.println("Totaal aantal punten: " + Dealer.totaalPunten);
			dealer.pas();
			break;
		case "q":
			doorspelen = false;
			System.out.println("Het spel is gestopt. Bedankt voor het spelen");
			break;
		default:
			System.out.println("Dit is geen geldige invoer. Kies opnieuw");
		}
	}

	

	
	
}