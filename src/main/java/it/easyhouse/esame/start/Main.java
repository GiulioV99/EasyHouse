package it.easyhouse.esame.start;

import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import it.easyhouse.esame.controller.EasyHouse;
import it.easyhouse.esame.model.Proprietario;

public class Main {

	public static void main(String[] args) {
		
		EasyHouse eh = EasyHouse.getInstance();
		int scelta;
		System.out.println("Benvenuto in easyHouse !\n");
		
		Scanner sc = new Scanner(System.in);
		
		eh.loadProprietari();
		eh.loadCase();
//		eh.loadSpaziComuni();
		
		while (true) {
	        System.out.println("\nScegli tra le operazioni disponibili.");
	        System.out.println(
	            "0 - Esci\n" +
	            "1 - Registra nuova casa\n" +
	            "2 - Aggiungi spazio comune\n" +
	            "3 - Inserisci inquilino\n" +
	            "4 - Login\n" +
	            "5 - Aggiungi spesa\n" +
	            "6 - Modifica spesa\n" +
	            "7 - Elimina Spesa" +
	            "5 - Logout\n"
	        );
	        
	        try {
	        	scelta = sc.nextInt();
	            sc.nextLine();
	        } catch (InputMismatchException e) {
	        	System.out.println("Inserisci un valore corretto");
	        	sc.nextLine();
	        	continue;
	        }
	        
	        switch(scelta) {
	        case 0:
	        	System.out.println("\nArrivederci !");
	        	sc.close();
	        	System.exit(0);
	        	break;
	        case 1:
	        	registraCasa(eh, sc);
	        	break;
	        case 2:
	        	aggiungiSpazioComune(eh, sc);
	        	break;
	        case 3:
	        	aggiungiInquilino(eh, sc);
	        	break;
	        case 4:
	        	loginProprietario(sc, eh);
	        	break;
	        case 5:
	        	aggiungiSpesa(sc, eh);
	        	break;
	        case 6:
	        	modificaSpesa(sc, eh);
	        	break;
	        case 7:
	        	eliminaSpesa(sc, eh);
	        	break;
	        case 10:
	        	eh.setCurrentUser(null);
                System.out.println("Logout effettuato.");
	        }
	        
		 }
		 	
	}
	
	 private static void registraCasa(EasyHouse eh, Scanner sc) {
		 String citta;
		 String indirizzo;
		 int postiLetto;
		 
		 if (!(eh.getCurrentUser()  instanceof Proprietario)) {
	            System.out.println("Operazione riservata al proprietario.");
	            return;
		 }
		 System.out.println("\nInserisci la città della casa:");
		 citta = sc.nextLine();
		 System.out.println("\nInserisci l'indirizzo della casa:");
		 indirizzo = sc.nextLine();
		 System.out.println("\nInserisci i posti letto della casa:");
		 postiLetto = sc.nextInt();
		 sc.nextLine();
		 eh.registraNuovaCasa(indirizzo, citta, postiLetto, 'a', postiLetto);
	}
	
	private static void aggiungiSpazioComune(EasyHouse eh, Scanner sc) {
		String nome;
		int tipo;
		
		if (!(eh.getCurrentUser()  instanceof Proprietario)) {
            System.out.println("Operazione riservata al proprietario.");
            return;
	    }
		System.out.println("\n inserisci nome spazio comune");
		nome = sc.nextLine();
		System.out.println("\n inserisci tipo spazio comune"
				+ "1 -> precedenza a chi lo ha prenotato meno(indipendentementa dalla data prenotazione)"
				+ "2 -> precedenza a chi prenota prima");
		tipo = sc.nextInt();
		sc.nextLine();
		eh.aggiungiSpazioComune(nome, tipo);
	}
	
	public static void aggiungiInquilino (EasyHouse eh, Scanner sc) {
		
		if (!(eh.getCurrentUser()  instanceof Proprietario)) {
            System.out.println("Operazione riservata al proprietario.");
            return;
	    }
		System.out.println("Inserisci nome del nuovo inqulino");
		String nome = sc.nextLine();
		System.out.println("Inserisci cognome del nuovo inqulino");
		String cognome = sc.nextLine();
		System.out.println("Inserisci la cauzione");
		double cauzione = sc.nextDouble();
		System.out.println("Inserisci email del nuovo inqulino");
		String email = sc.nextLine();
		
		eh.aggiungiInquilino(nome, cognome, email, "password", cauzione);
	}
	
	 private static void loginProprietario(Scanner sc, EasyHouse eh) {
	        System.out.print("Email: ");
	        String email = sc.nextLine();
	        System.out.print("Password: ");
	        String password = sc.nextLine();
	 
	        Proprietario p = eh.getProprietarioByEmail(email);
	        if (p != null && p.getPassword().equals(password)) {
	            eh.setCurrentUser(p);
	            System.out.println("Login effettuato. Benvenuto, " + p.getNome() + "!");
	        } else {
	            System.out.println("Credenziali non valide.");
	        }
	    }
	 
	 private static void aggiungiSpesa(Scanner sc, EasyHouse eh) {
		 System.out.print("inserisci id spesa");
	     String id = sc.nextLine();
	     System.out.print("inserisci tipo di spesa: \n 1 - affitto \n 2 - bolletta");
	     int codTipo = sc.nextInt();
	     sc.nextLine();
	     String nomeInquilino = null;
	     String tipo = null;
	     if (codTipo == 1) {
	    	 tipo = "Affitto";
	    	 System.out.println("Inserisci il nome dell'inquilino");
	    	 nomeInquilino = sc.nextLine();
	     } else if (codTipo == 2) {
	    	 tipo = "Bolletta";
	     }
	     System.out.print("inserisci importo: ");
	     double importo = sc.nextDouble();
	     sc.nextLine();
	     System.out.println("inserisci data scadenza formato aaaa-mm-gg: ");
	     String scadenza = sc.nextLine();
	     LocalDate dataScadenza = LocalDate.parse(scadenza);
	     System.out.println("Inserisci note");
	     String nota = sc.nextLine();
	     
	     eh.addSpesa(id, tipo, importo, dataScadenza, nota, nomeInquilino);
	 }
	 
	 public static void modificaSpesa(Scanner sc, EasyHouse eh) {
		 eh.getSpeseNonPagate().stream()
		 	.forEach(s -> System.out.println(s));
		 
		 System.out.println("Inserisci id spesa da modificare: ");
		 String id = sc.nextLine();
		 System.out.println("Inserisci nuovo importo: ");
		 double importo = sc.nextDouble();
		 sc.nextLine();
		 
		 eh.modificaSpesa(id, importo, "note");
	 }
	 
	 public static void eliminaSpesa(Scanner sc, EasyHouse eh) {
		 
	 }

}
