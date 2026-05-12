package it.easyhouse.esame.model;

public class Utente {

	private String nome;
	private String email;
	private String cognome;
	private String password;
	
	public Utente(String nome, String cognome, String email, String password) {
		this.nome = nome;
		this.setCognome(cognome);
		this.email = email;
		this.setPassword(password);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
