package presentation;

import java.util.Scanner;

import data.VenContainer;
import logic.VennerOgBekendte;

public class SoegVen {

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
		System.out.println("soge Ven eller Bekendt");
		System.out.println("søg på Navn, email eller telefon nr - eller afslut med \"x\"");
	}

	private void processIndtasning(String indtastning, Scanner sc) {
		VenContainer fundenevenner = venner.soeg(indtastning);
			if (fundenevenner.antalElementer() == 0) {
				System.out.println("ingen venner med det navn fundet");
			}
			if (fundenevenner.antalElementer() != 0) {
			System.out.println(fundenevenner.antalElementer() + " antal venner fundet");
			for (int i = 0; i < fundenevenner.antalElementer(); i++) {
				System.out.println("Ven " + fundenevenner.getElement(i) + " er fundet");
			}
		}
		}
	}
