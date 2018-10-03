package logic;

import data.VenContainer;

public class VennerOgBekendteImpl implements VennerOgBekendte {

	private VenContainer venner = new VenContainer();

	public VennerOgBekendteImpl() {
		venner.hentVenFil();
	}
	
	@Override
	public boolean opret(Ven ven) {
		venner.addElement(ven);
		venner.gemVenfil();
		return true;
	}

	@Override
	public boolean opdater(Ven ven) {
		boolean status = venner.opdateElement(ven);
		venner.gemVenfil();
		return status;
	}

	@Override
	public boolean slet(String email) {
		boolean status = venner.deleteElement(email);
		venner.gemVenfil();
		return status;
	}

	@Override
	public Ven find(String email) {
		Ven ven = venner.findElement(email);
		return ven;
	}

	public Ven[] list() {
		return venner.list();
	}
	
	@Override
	public VenContainer soeg(String sogestreng) {
		VenContainer fundenevenner = venner.sogeElement(sogestreng);
		return fundenevenner;
	}

}