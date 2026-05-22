package it.easyhouse.esame.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.easyhouse.esame.model.Casa;

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

}
