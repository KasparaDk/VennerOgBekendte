package presentation;

import java.util.Scanner;

import logic.VennerOgBekendte;

public class SletVen {

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
		System.out.println("Slet ven");
		System.out.println("Indtast Email - eller afslut med \"x\\");
	}

	private void processIndtasning(String indtastning, Scanner sc) {
		boolean retur = venner.slet(indtastning);
		if (retur) {
			System.out.println("Ven eller bekent er nu slettet ");
		}
		else System.out.println("Ven eller bekent blev ikke slettet ");

	}
}