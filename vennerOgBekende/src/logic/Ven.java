package logic;

import java.io.Serializable;

public class Ven implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String navn;
	private String email;
	private String telefon;

	public Ven(String navn, String email, String telefon) {
		this.navn = navn;
		this.email = email;
		this.telefon = telefon;
	}

	public String getNavn() {
		return navn;

	}

	public String getEmail() {
		return email;
	}

	public String getTelefon() {
		return telefon;
	}

	@Override
	public String toString() {
		return "Ven [navn=" + navn + ", email=" + email + ", telefon=" + telefon + "]";
	}
	

}