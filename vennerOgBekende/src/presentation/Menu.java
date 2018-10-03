package presentation;

import java.util.Scanner;

import logic.VennerOgBekendte;

public class Menu {

	private VennerOgBekendte vennerOgBekendte;

	public void start(VennerOgBekendte vennerOgBekendte) {
		this.vennerOgBekendte = vennerOgBekendte;
		try (Scanner sc = new Scanner(System.in)) {
			showMenu();
			String menuvalg = sc.nextLine();
			while (!menuvalg.equals("x")) {
				processMenuValg(menuvalg, sc);
				showMenu();
				menuvalg = sc.nextLine();
			}
		}

	}

	private void showMenu() {
		System.out.println("Venner og Bekendte");
		System.out.println("Indtast valg, eller afslut med \"x\"");
		System.out.println("  1: Opret ven eller bekendt");
		System.out.println("  2: Opdater ven eller bekendt");
		System.out.println("  3: Slet ven eller bekendt");
		System.out.println("  4: Soeg ven eller bekendt");
		System.out.println("  5: List venner");
		System.out.println("  x: Afslut");
	}

	private void processMenuValg(String menuvalg, Scanner sc) {
		switch (menuvalg) {
		case "1":
			System.out.println("  1: Opret ven eller bekendt");
			OpretVen opretVen = new OpretVen();
			opretVen.start(vennerOgBekendte, sc);
			break;
		case "2":
			System.out.println("  2: Opdater ven eller bekendt");
			OpdaterVen opdaterVen = new OpdaterVen();
			opdaterVen.start(vennerOgBekendte, sc);

			break;
		case "3":
			System.out.println("  3: Slet ven eller bekendt");
			SletVen sletVen = new SletVen();
			sletVen.start(vennerOgBekendte, sc);

			break;
		case "4":
			System.out.println("  4: Soeg ven eller bekendt");
			SoegVen soegVen = new SoegVen();
			soegVen.start(vennerOgBekendte, sc);

			break;
		case "5":
			System.out.println("  5: List venner");
			for(logic.Ven ven : vennerOgBekendte.list()) {
				if (ven != null) {
					System.out.println(ven);
				}
			}

			break;
		case "x":
			System.out.println("  x: Afslut");

			break;
		default:
			showMenu();
			break;
		}
	}

}