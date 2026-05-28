package it.easyhouse.esame.model;

import java.time.LocalDate;

public class Affitto extends Spesa{

	public Affitto(String id, double importo, LocalDate dataScadenza, String nota) {
        super(id, importo, dataScadenza, nota);
    }

	@Override
    public double calcolaQuota(int numInquilini) {
        return getImporto();
    }
}
