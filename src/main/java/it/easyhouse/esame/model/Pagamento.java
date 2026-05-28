package it.easyhouse.esame.model;

import java.time.LocalDate;

import it.easyhouse.esame.catalog.StatoSpesa;

public class Pagamento {

	private Inquilino inquilino;
	private Spesa spesa;
	private LocalDate dataPagamento;
	private StatoSpesa stato;
	private double quota;
	
    public Pagamento(Inquilino inquilino, Spesa spesa, double quota) {
        this.inquilino = inquilino;
        this.spesa = spesa;
        this.setQuota(quota);
        this.stato = StatoSpesa.NON_PAGATA;
    }
	
	public Inquilino getInquilino() {
		return inquilino;
	}
	
	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}
	
	public Spesa getSpesa() {
		return spesa;
	}
	
	public void setSpesa(Spesa spesa) {
		this.spesa = spesa;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public StatoSpesa getStato() {
		return stato;
	}

	public void setStato(StatoSpesa stato) {
		this.stato = stato;
	}

	public double getQuota() {
		return quota;
	}

	public void setQuota(double quota) {
		this.quota = quota;
	}
}
