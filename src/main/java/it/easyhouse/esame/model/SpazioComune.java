package it.easyhouse.esame.model;

public class SpazioComune {

	private String nome;
	private int tipo;
	
	public SpazioComune(String nome, int tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
