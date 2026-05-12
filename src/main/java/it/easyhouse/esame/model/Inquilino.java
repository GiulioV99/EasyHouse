package it.easyhouse.esame.model;

public class Inquilino extends Utente{

	private double cauzione;
	
	public Inquilino(String nome, String cognome, String email, String password, double cauzione) {
		super(nome, cognome, email, password);
		this.cauzione = cauzione;
	}

	public double getCauzione() {
		return cauzione;
	}

	public void setCauzione(double cauzione) {
		this.cauzione = cauzione;
	}
}
