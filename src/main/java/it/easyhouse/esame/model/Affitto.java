package it.easyhouse.esame.model;

import java.time.LocalDate;

public class Affitto extends Spesa{

	String nomeInquilino;
	
	public Affitto(String id, double importo, LocalDate dataScadenza, String nota, String nomeInquilino) {
        super(id, importo, dataScadenza, nota);
        this.nomeInquilino = nomeInquilino;
    }

	@Override
    public double calcolaQuota(int numInquilini) {
        return getImporto();
    }
}
