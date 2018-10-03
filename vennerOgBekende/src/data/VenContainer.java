package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logic.Ven;

public class VenContainer {

	private Ven[] venner;
	private int nextElement = 0;

	public int antalElementer() {
		int antal = 0;
		for (int i = 0; i < venner.length; i++) {
			if (venner[i] != null) {
				antal++;
			} else {
				break;
			}
		}
		return antal;
	}

	public VenContainer() {
		this(2);
	}

	public VenContainer(int startantal) {
		venner = new Ven[startantal];
	}

	public void addElement(Ven s) {
		if (nextElement >= venner.length) {
			Ven[] temp = venner;
			venner = new Ven[venner.length * 2];
			for (int i = 0; i < nextElement; i++) {
				venner[i] = temp[i];
			}

		}
		venner[nextElement] = s;
		nextElement++;
	}

	public boolean deleteElement(String email) {
		for (int i = 0; i < nextElement; i++) {
			Ven ven = venner[i];
			if (ven.getEmail().equals(email)) {
				System.out.println("slettet" + ven);
				for (int j = i; j < nextElement; j++) {
					venner[j] = venner[j + 1];
					venner[j + 1] = null;
				}
				nextElement--;
				return true;
			}
		}
		return false;
	}

	public Ven findElement(String email) {
		for (int i = 0; i < nextElement; i++) {
			Ven ven = venner[i];
			if (ven.getEmail().equals(email)) {
				System.out.println(ven);
				return ven;
			}

		}
		return null;
	}

	public boolean opdateElement(Ven nyven) {
		for (int i = 0; i < nextElement; i++) {
			Ven ven = venner[i];
			if (ven.getEmail().equals(nyven.getEmail())) {
				System.out.println("opdaterElement" + nyven);
				venner[i] = nyven;
				return true;
			}
		}
		return false;

	}

	public Ven[] list() {
		return venner;
	}

	public VenContainer sogeElement(String sogestreng) {
		VenContainer fundenevenner = new VenContainer();
		for (int i = 0; i < nextElement; i++) {
			Ven ven = venner[i];
			if (ven.getNavn().toUpperCase().contains(sogestreng.toUpperCase())
					|| ven.getEmail().toUpperCase().contains(sogestreng.toUpperCase())
					|| ven.getTelefon().toUpperCase().contains(sogestreng.toUpperCase())) {
				fundenevenner.addElement(ven);
			}

		}
		return fundenevenner;
	}

	public Ven getElement(int index) {
		return venner[index];
	}

	public int size() {
		return nextElement;
	}

	public void gemVenfil() {
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream("Venne Liste.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(venner);
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e)
		{
			System.out.println("Fejl Kunne ikke gemme");
		}
		
	}

	public void hentVenFil()  {
		
		try {
			FileInputStream fileInputStream = new FileInputStream("Venne Liste.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			venner = (Ven[]) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
			nextElement = this.antalElementer();
			System.out.println("Størrelse " + venner.length);
			Ven[] temp = venner;
			venner = new Ven[nextElement];
			for (int i = 0; i < nextElement; i++) {
				venner[i] = temp[i];
			}
		} catch (Exception e) {
			System.out.println("Fejl venner ikke hentet");
		}
	}

//	public void sort() {
//		for (int a = 1; a < nextElement; a++) {
//			for (int b = nextElement - 1; b >= a; b--) {
//				if (array[b - 1].compareTo(array[b]) > 0) { 
//					// if out of order, exchange elements
//					String t = array[b - 1];
//					array[b - 1] = array[b];
//					array[b] = t;
//				}
//			}
//		}
//	}

}