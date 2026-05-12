package it.easyhouse.esame.model;

import java.util.ArrayList;
import java.util.List;

public class Casa {

	private String indirizzo;
	private String citta;
	private int piano;
	private char scala;
	private int numeroPostiLetto;
	private List<SpazioComune> spaziComune;
	private List<Inquilino> inqulini;
	
	public Casa(String indirizzo, String citta, int piano, char scala, int numeroPostiLetto) {
		this.citta = citta;
        this.indirizzo = indirizzo;
        this.piano = piano;
        this.scala = scala;
        this.numeroPostiLetto = numeroPostiLetto;
        
        this.spaziComune = new ArrayList<>();
        this.inqulini = new ArrayList<>();
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public int getPiano() {
		return piano;
	}
	public void setPiano(int piano) {
		this.piano = piano;
	}
	public char getScala() {
		return scala;
	}
	public void setScala(char scala) {
		this.scala = scala;
	}
	public int getNumeroPostiLetto() {
		return numeroPostiLetto;
	}
	public void setNumeroPostiLetto(int numeroPostiLetto) {
		this.numeroPostiLetto = numeroPostiLetto;
	}
	public List<SpazioComune> getSpaziComune() {
		return spaziComune;
	}
	public void setSpaziComune(List<SpazioComune> spaziComune) {
		this.spaziComune = spaziComune;
	}
	
	public void addSpazioComune(String nome, int tipo) {
		SpazioComune sc = new SpazioComune(nome, tipo);
		this.spaziComune.add(sc);
	}

	//TODO : verificare se passare inquilino o i dati
	public void addInquilino(Inquilino i) {
		this.inqulini.add(i);
	}
	
	public boolean haPostiLetto() {
		int numPosti = this.numeroPostiLetto - inqulini.size();
		if(numPosti > 0)
			return true;
		return false;
	}
}
