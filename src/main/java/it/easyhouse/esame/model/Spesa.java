package it.easyhouse.esame.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.easyhouse.esame.catalog.StatoSpesa;

public abstract class Spesa {

	private String id;
	private String tipo;
	private double importo;
	private LocalDate dataScadenza;
	private String nota;
	private StatoSpesa stato;
	private List<Pagamento> pagamenti;

	
	protected Spesa(String id, double importo, LocalDate dataScadenza, String nota) {
	    this.id = id;
	    this.importo = importo;
	    this.dataScadenza = dataScadenza;
	    this.nota = nota;
	    this.stato = StatoSpesa.NON_PAGATA;
	    this.pagamenti = new ArrayList<>();
	}
	
	public String getId() { 
		return id; 
	}
	public void setId(String id) { 
		this.id = id; 
	}

    public double getImporto() {
    	return importo;
    }
    public void setImporto(double importo) {
    	this.importo = importo;
    }
    public LocalDate getDataScadenza() {
    	return dataScadenza;
    }
    public void setDataScadenza(LocalDate dataScadenza) {
    	this.dataScadenza = dataScadenza;
    }
    public String getNota() {
    	return nota;
    }
    public void setNota(String nota) {
    	this.nota = nota;
    }

    public StatoSpesa getStato() {
    	return stato;
    }
    public void setStato(StatoSpesa stato) {
    	this.stato = stato;
    }
    
    public abstract double calcolaQuota(int numInquilini);

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void addPagamento(Pagamento p) {
	    this.pagamenti.add(p);
	}
	
	public List<Pagamento> getPagamenti() {
	    return pagamenti;
	}

	
}
