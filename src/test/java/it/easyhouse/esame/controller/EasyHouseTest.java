package it.easyhouse.esame.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import it.easyhouse.esame.model.Casa;

//@TestInstance(Lifecycle.PER_CLASS) è fondamentale senza di essa @BeforeAll deve essere static, e quindi this.eh non è accessibile.
@TestInstance(Lifecycle.PER_CLASS)
class EasyHouseTest {
	
	private EasyHouse eh;

    @BeforeAll
    void setupAll() {
        this.eh = EasyHouse.getInstance();
    }

    @BeforeEach
    void setup() {
        this.eh.loadProprietari();
        this.eh.loadCase();
    }

    @AfterEach
    void clean() {
    }

    @Test
    @DisplayName("Test registrazione casa con successo")
    void testRegistraCasa() {
        Casa c = eh.registraNuovaCasa("Via Roma 1", "Milano", 2, 'A', 3);
        assertNotNull(c);
        assertEquals("Milano", c.getCitta());
    }
    
    @Test
    @DisplayName("Test registra spazio comune duplicato")
    void testAddSpazioComuneDuplicato() {
    	Exception e = assertThrows(IllegalArgumentException.class, () -> eh.aggiungiSpazioComune("cucina", 1));
        assertEquals("Spazio comune già esistente: Cucina", e.getMessage());
    }
    
    @Test
    @DisplayName("Test aggiungi inquilino duplicato")
    void testAddInquilinoDuplicato() {
    	Exception e = assertThrows(IllegalArgumentException.class, () -> eh.aggiungiInquilino("Mario", "ola", "mail1", "password", 10));
        assertEquals("mail già registrata", e.getMessage());
    }
    
    @Test
    @DisplayName("Test aggiungi inquilino posti duplicato")
    void testAddInquilinoCasaPiena() {
    	
    }

}
