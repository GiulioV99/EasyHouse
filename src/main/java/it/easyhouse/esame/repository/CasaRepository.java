package it.easyhouse.esame.repository;

import java.util.HashMap;
import java.util.Map;

import it.easyhouse.esame.model.Casa;

public class CasaRepository {

	Map<String, Casa> elencoCase;
	
	public CasaRepository() {
		this.elencoCase = new HashMap<String, Casa>();
	}
	
	public void save(Casa c) {
		this.elencoCase.put(c.getIndirizzo(), c);
	}
	
	public Casa getCasaByIndirizzo(String indirizzo) {
		return this.elencoCase.get(indirizzo);
	}
}
