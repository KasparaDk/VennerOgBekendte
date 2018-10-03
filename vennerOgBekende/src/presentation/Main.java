package presentation;
import logic.VennerOgBekendte;
import logic.VennerOgBekendteFactory;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		VennerOgBekendte vennerOgBekendte = new VennerOgBekendteFactory().makeVennerOgBekendte();
		menu.start(vennerOgBekendte);

	}

}
