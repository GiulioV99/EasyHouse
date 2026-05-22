package it.easyhouse.esame.controller;

import it.easyhouse.esame.model.Casa;
import it.easyhouse.esame.model.Proprietario;
import it.easyhouse.esame.model.Utente;
import it.easyhouse.esame.repository.CasaRepository;
import it.easyhouse.esame.repository.ProprietarioRepository;


//usato design pattern creazionale singleton
public class EasyHouse {

	private static EasyHouse instance;
	private Casa casaCorrente;
	private CasaRepository casaRepo;
	private Utente currentUser;
	private ProprietarioRepository propRepo;

	
	private EasyHouse(CasaRepository casaRepo, ProprietarioRepository propRepo) {
		this.casaRepo = casaRepo;
	    this.propRepo = propRepo;
	    //completare il costruutore
	}

	public static EasyHouse getInstance() {
		if (instance == null) {
			instance = new EasyHouse(new CasaRepository(), new ProprietarioRepository());
		}
		return instance;
	}

	public Casa getCasaCorrente() {
		return casaCorrente;
	}

	public void setCasaCorrente(Casa casaCorrente) {
		this.casaCorrente = casaCorrente;
	}
	
	public Casa registraNuovaCasa(String indirizzo, String citta, int piano, char scala, int numeroPostiLetto) {
		Casa c = new Casa(indirizzo, citta, piano, scala, numeroPostiLetto);
		casaRepo.save(c);
		setCasaCorrente(c);
		return c;
	}
	
    public void aggiungiSpazioComune(String nomeSpazio, int tipo) {
//        Casa c = casaRepo.getCasaByIndirizzo(casa);
        if (casaCorrente == null) {
            throw new IllegalArgumentException("Casa non trovata");
        }
        casaCorrente.addSpazioComune(nomeSpazio, tipo);
    }
    
    public void aggiungiInquilino(String nome, String email, double cauzione) {
    	
    }

	public Utente getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Utente currentUser) {
		this.currentUser = currentUser;
	}
	
	public Proprietario getProprietarioByEmail(String email) {
	    return propRepo.getProprietarioByEmail(email);
	}

	public void setPropRepo(ProprietarioRepository propRepo) {
		this.propRepo = propRepo;
	}
	
	
	public void loadProprietari() {
        Proprietario p1 = new Proprietario("Mario", "Rossi", "email", "password", 1);
        propRepo.save(p1);
    }
	
	public void loadCase() {
        Casa c1 = new Casa("via Mineo", "Catania", 5, 'D', 1);
        casaCorrente.addSpazioComune("Cinema", 1);
        casaRepo.save(c1);
        setCasaCorrente(c1);
    }



}
