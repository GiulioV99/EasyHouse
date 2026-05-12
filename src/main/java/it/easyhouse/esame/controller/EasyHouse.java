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
	private Proprietario prop;
	private ProprietarioRepository propRepo;

	
	private EasyHouse() {
		this.casaRepo = new CasaRepository();
	    this.propRepo = new ProprietarioRepository();
	}

	public static EasyHouse getInstance() {
		if (instance == null) {
			instance = new EasyHouse();
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
		prop = propRepo.getProprietarioByEmail(email);
		if (prop.getEmail().equals(email)) {
			return prop;
		}
		return null;
	}

	public ProprietarioRepository getPropRepo() {
		return propRepo;
	}

	public void setPropRepo(ProprietarioRepository propRepo) {
		this.propRepo = propRepo;
	}
	
	
	public void loadProprietari() {
        Proprietario p1 = new Proprietario("Mario", "Rossi", "email", "password", 1);
        propRepo.save(p1);
    }


}
