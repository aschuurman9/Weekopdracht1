package Weekopdrachten;

import java.util.Scanner;

public class BlackJack {
	static boolean doorspelen = true;
	Scanner scanner = new Scanner(System.in);
	Dealer dealer = new Dealer();
	Speler speler = new Speler();

	BlackJack() {
		System.out.println("Welkom bij BlackJack \n");
		System.out.println("Wat is je naam? ");
		String naam = scanner.nextLine();
		speler.setNaam(naam);
		System.out.println(speler.getNaam() + " leuk dat je meespeelt! \nMaak een keuze: \n");
	}

	void starten() {
		toonBeginMenu();
		String invoerBeginMenu = scanner.nextLine();
		verwerkenInvoerBeginMenu(invoerBeginMenu);
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
		System.out.println("Maak een keuze:");
		System.out.println("s start een nieuw spel");
		System.out.println("k kaart");
		System.out.println("p pas");
		System.out.println("q stop spel");
		System.out.println();
	}

	void verwerkenInvoerBeginMenu(String deInvoer) {
		switch (deInvoer) {
		case "s":
			nieuwSpelBegint();
			break;
		case "q":
			doorspelen = false;
			System.out.println("Het spel is gestopt. Bedankt voor het spelen");
			break;
		default:
			System.out.println("Dit is geen geldige invoer. Kies opnieuw");
		}
	}

	void verwerkenInvoer(String deInvoer) {
		switch (deInvoer) {
		case "s":
			dealer.totaalPunten = 0;
			dealer.puntenDealer = 0;
			dealer.kaartenDealer.clear();
			nieuwSpelBegint();
			break;
		case "k":
			System.out.println("kaart");
			dealer.geefKaart();
			dealer.totaalPunten = dealer.telPunten();
			System.out.println("Totaal aantal punten: " + dealer.totaalPunten);
			dealer.check21();
			break;
		case "p":
			System.out.println("passen");
			System.out.println("Totaal aantal punten: " + dealer.totaalPunten);
			System.out.println();
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

	void nieuwSpelBegint() {
		System.out.println("spel start");
		Kaartendeck kaartendek = new Kaartendeck();
		kaartendek.kaartendekMaken();
		kaartendek.kaartenSchudden();
		System.out.println("********************************************");
		dealer.dealerPaktKaart();
		dealer.puntenDealer = dealer.kaartenDealer.get(0).punten;
		System.out.println("********************************************");
		System.out.println("De eerste 2 kaarten: ");
		dealer.geefKaart();
		dealer.telPunten();
		dealer.geefKaart();
		dealer.telPunten();
		System.out.println("Totaal aantal punten: " + dealer.totaalPunten);
		dealer.check21();
	}

}