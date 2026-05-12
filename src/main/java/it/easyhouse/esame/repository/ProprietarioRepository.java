package it.easyhouse.esame.repository;

import java.util.HashMap;
import java.util.Map;

import it.easyhouse.esame.model.Proprietario;

public class ProprietarioRepository {

	Map<String, Proprietario>elencoProprietari;
	
	public ProprietarioRepository() {
	    this.elencoProprietari = new HashMap<String, Proprietario>();
	}
	
	public Proprietario getProprietarioByEmail(String email) {
		Proprietario p = elencoProprietari.get(email);
		return p;
	}
	
	public void save(Proprietario p) {
		this.elencoProprietari.put(p.getEmail(), p);
	}
}
