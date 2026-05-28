package it.easyhouse.esame.model;

import java.time.LocalDate;

import it.easyhouse.esame.catalog.TipoSpesa;

public class Bolletta extends Spesa{
	
	private TipoSpesa ragione;

	public Bolletta(String id, double importo, LocalDate dataScadenza, String nota) {
        super(id, importo, dataScadenza, nota);
    }

    @Override
    public double calcolaQuota(int numInquilini) {
        return getImporto() / numInquilini;
    }

	public TipoSpesa getRagione() {
		return ragione;
	}

	public void setRagione(TipoSpesa ragione) {
		this.ragione = ragione;
	}
}
