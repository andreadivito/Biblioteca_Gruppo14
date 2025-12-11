/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo14.gestionedati;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andre
 */
public class PrestitoTest {
    
    private Prestito prestito;
    private Libro libro;
    private Utente utente;
    private LocalDate dataRestituzione;
    
    public PrestitoTest() {
  
    }   
    
    @BeforeEach
    public void setUp() {
        libro = new Libro("Il Signore degli Anelli", 1954, "978-88-12345", 5);
        utente = new Utente("Mario", "Rossi", "0612700001", "m.rossi@studenti.unisa.it");
        dataRestituzione = LocalDate.now().plusDays(30);
        
        prestito = new Prestito(libro, utente, dataRestituzione);
    }

    /**
     * Test of getLibro method, of class Prestito.
     */
    @Test
    public void testGetLibro() {
        System.out.println("getLibro");
        Libro expResult = libro;
        Libro result = prestito.getLibro();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUtente method, of class Prestito.
     */
    @Test
    public void testGetUtente() {
        System.out.println("getUtente");
        Utente expResult = utente;
        Utente result = prestito.getUtente();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataRestituzione method, of class Prestito.
     */
    @Test
    public void testGetDataRestituzione() {
        System.out.println("getDataRestituzione");
        LocalDate expResult = dataRestituzione;
        LocalDate result = prestito.getDataRestituzione();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLibro method, of class Prestito.
     */
    @Test
    public void testSetLibro() {
        System.out.println("setLibro");
        Libro nuovoLibro = new Libro("Harry Potter", 1997, "978-88-67890", 3);
        prestito.setLibro(nuovoLibro);
        Libro expResult = nuovoLibro;
        assertEquals(expResult, prestito.getLibro());
    }

    /**
     * Test of setUtente method, of class Prestito.
     */
    @Test
    public void testSetUtente() {
        System.out.println("setUtente");
        Utente nuovoUtente = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        prestito.setUtente(nuovoUtente);
        Utente expResult = nuovoUtente;
        assertEquals(expResult, prestito.getUtente());
    }

    /**
     * Test of setDataRestituzione method, of class Prestito.
     */
    @Test
    public void testSetDataRestituzione() {
        System.out.println("setDataRestituzione");
        LocalDate nuovaDataRestituzione = LocalDate.now().plusDays(35);
        prestito.setDataRestituzione(nuovaDataRestituzione);
        LocalDate expResult = nuovaDataRestituzione;
        assertEquals(expResult, prestito.getDataRestituzione());
    }

    /**
     * Test of verificaRitardo method, of class Prestito.
     */
    @Test
    public void testVerificaRitardoFalse() {
        System.out.println("verificaRitardoFalse");
        boolean expResult = false;
        boolean result = prestito.verificaRitardo();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testVerificaRitardoTrue() {
        System.out.println("verificaRitardoFalse");
        prestito.setDataRestituzione(LocalDate.now().minusDays(1));
        boolean expResult = true;
        boolean result = prestito.verificaRitardo();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Prestito.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Prestito{libro=" + libro + ", utente=" + utente + ", dataRestituzione=" + dataRestituzione + "}";
        String result = prestito.toString();
        assertEquals(expResult, result);
    }
    
}
