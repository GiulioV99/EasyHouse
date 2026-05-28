package it.easyhouse.esame.factory;

import java.time.LocalDate;

import it.easyhouse.esame.model.Affitto;
import it.easyhouse.esame.model.Bolletta;
import it.easyhouse.esame.model.Spesa;

public class SpesaFactory {

	public static Spesa crea(String id, String tipo, double importo, LocalDate dataScadenza, String note, int numInquilini, String nomeInquilino) {
        if (tipo.equals("Affitto")) {
            return new Affitto(id, importo, dataScadenza, note, nomeInquilino);
        } else {
            return new Bolletta(id, importo, dataScadenza, note);
        }
    }
}
