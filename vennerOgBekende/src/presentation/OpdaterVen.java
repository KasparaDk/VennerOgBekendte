package presentation;

import java.util.Scanner;

import logic.Ven;
import logic.VennerOgBekendte;

public class OpdaterVen {
	private VennerOgBekendte venner;

	public void start(VennerOgBekendte venner, Scanner sc) {
		this.venner = venner;
		showMenu();
		String indtastning = sc.nextLine();
		while (!indtastning.equals("x")) {
			processIndtasning(indtastning, sc);
			showMenu();
			indtastning = sc.nextLine();

		}
	}

	private void showMenu() {
		System.out.println("Opdater Ven eller Bekendt");
		System.out.println("Indtast email - eller afslut med \"x\"");
	}

	private void processIndtasning(String email, Scanner sc) {
		Ven ven = venner.find(email);
		if (ven != null) {

			System.out.println("Indtast nyt Navn, Telefonnr");
			String indtastning = sc.nextLine();
			String[] dele = indtastning.split(",");
			Ven nyven = new Ven(dele[0].trim(), email, dele[1].trim());
			boolean retur = venner.opdater(nyven);
			{
				if (retur) {
					System.out.println("Ven eller bekent er nu belvet opdateret " + ven);
				} else
					System.out.println("Ven eller bekent er ikke blevet opdateret " + ven);

			}
		} else {
			System.out.println("Ven eller bekent blev ikke fundet");
		}
	}
}