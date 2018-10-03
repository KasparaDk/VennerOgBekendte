package presentation;
import java.util.Scanner;

import logic.Ven;
import logic.VennerOgBekendte;

public class OpretVen {
	private VennerOgBekendte venner;

	public void start(VennerOgBekendte venner, Scanner sc) {
		this.venner = venner;
		showMenu();
		String indtastning = sc.nextLine();
		while (!indtastning.equals("x")) {
			processIndtasning(indtastning, sc, false);
			showMenu();
			indtastning = sc.nextLine();
		}

	}
	
	private void showMenu() {
		System.out.println("Opret Ven eller Bekendt");
		System.out.println("Indtast navn, email, telefon - eller afslut med \"x\"");
	}

	private void processIndtasning(String indtastning, Scanner sc, boolean fejl) {
		if (fejl) {
			indtastning = sc.nextLine();
		}
		String[] dele = indtastning.split(",");
		String navn = dele[0].trim();
		if (navn.equals("x")) {
			return;
		}
		else {
//			System.out.println(navn + navn);
//			System.out.println(navn + navn);
//			System.out.println((navn=="x") +"should be true if "+navn+" = x");
		String email = dele[1].trim();
		String telefon = dele[2].trim();
		if (!navn.contains("") || (!email.contains("@")) || ((!telefon.chars().allMatch(Character::isDigit))) || telefon.length() != 8) {
			System.out.println("Husk @ i email og telefon nr på 8 tal ");
			System.out.println("Indtast navn, email, telefon igen");
			processIndtasning(indtastning, sc, true);
		}
		else{
			Ven ven = new Ven(dele[0].trim(), dele[1].trim(), dele[2].trim());
			boolean retur = venner.opret(ven);
			if (retur) {
				System.out.println("Ven eller bekent er nu oprettet " + ven);
			}
			else System.out.println("Ven eller bekent er ikke blevet oprettet " + ven);
		}
		
	}
	}
}