package it.easyhouse.esame.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import it.easyhouse.esame.factory.SpesaFactory;

public class Casa {

	private String indirizzo;
	private String citta;
	private int piano;
	private char scala;
	private int numeroPostiLetto;
	private List<SpazioComune> spaziComune;
	private List<Inquilino> inquilini;
	private List<Spesa> spese;
	
	public Casa(String indirizzo, String citta, int piano, char scala, int numeroPostiLetto) {
		this.citta = citta;
        this.indirizzo = indirizzo;
        this.piano = piano;
        this.scala = scala;
        this.numeroPostiLetto = numeroPostiLetto;
        this.spaziComune = new ArrayList<>();
        this.inquilini = new ArrayList<>();
        this.spese = new ArrayList<>();
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
	public List<Inquilino> getInquilini() {
		return inquilini;
	}
	public void setInquilini(List<Inquilino> inquilini) {
		this.inquilini = inquilini;
	}
	
	public List<Spesa> getSpese() {
		return spese;
	}

	public void setSpese(List<Spesa> spese) {
		this.spese = spese;
	}
	
	
	public void addSpazioComune(String nome, int tipo) {
		boolean esiste = this.spaziComune.stream()
				.anyMatch(s -> s.getNome().equals(nome));
		if (esiste) {
	        throw new IllegalArgumentException("Spazio comune già esistente: " + nome);
		}
		SpazioComune sc = new SpazioComune(nome, tipo);
		this.spaziComune.add(sc);
	}

	public void addInquilino(String nome, String cognome, String email, String password, double cauzione) {
		boolean esiste = this.inquilini.stream()
				.anyMatch(i -> i.getEmail().equals(email));
		if(esiste) {
			throw new IllegalArgumentException("mail già registrata" + email);
		}
		Inquilino i = new Inquilino (nome, cognome, email, password, cauzione);
		this.inquilini.add(i);
	}
	
	public boolean haPostiLetto() {
		int numPosti = this.numeroPostiLetto - inquilini.size();
		if(numPosti > 0)
			return true;
		return false;
	}
	
	public void addSpesa(String id, String tipo, double importo, LocalDate dataScadenza, String nota, String nomeInquilino) {
		Spesa s = SpesaFactory.crea(id, tipo, importo, dataScadenza, nota, inquilini.size(), nomeInquilino);
		spese.add(s);
		
		if(s instanceof Affitto) {
			Inquilino i = getInquilinoByNome(nomeInquilino);
			Pagamento p = new Pagamento (i, s, s.calcolaQuota(inquilini.size()));
			s.addPagamento(p);
		} else {
			double quota = s.calcolaQuota(inquilini.size());
			inquilini.stream()
	         .forEach(i -> s.addPagamento(new Pagamento(i, s, quota)));
		}
	}
	
	public Inquilino getInquilinoByNome(String nome) {
		return inquilini.stream()
			.filter(i -> i.getNome().equals(nome))
			.findFirst()
	        .orElseThrow(() -> new NoSuchElementException("Inquilino non trovato: " + nome));
	}
	
	
	public void modificaSpesa (String id, double importo, String note) {
		Spesa spesa = getSpese().stream()
				.filter(s -> s.getId().equals(id))
				.findFirst()
	            .orElseThrow(() -> new IllegalArgumentException("Spesa con ID " + id + " non trovata"));
		
		spesa.setImporto(importo);
		spesa.setNota(note);
		spesa.aggiornaQuote(spesa, inquilini.size());
	}

}
