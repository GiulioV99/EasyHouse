package it.easyhouse.esame.model;

public class Proprietario extends Utente{

	private int numProprieta;
	
    public Proprietario(String nome, String cognome, String email, String password, int numProprieta) {
    	super(nome, cognome, email, password);
    	this.setNumProprieta(numProprieta);
    }

	public int getNumProprieta() {
		return numProprieta;
	}

	public void setNumProprieta(int numProprieta) {
		this.numProprieta = numProprieta;
	}
    

}
