package it.unisa.diem.softeng.gruppo14.gestionelogica;

import it.unisa.diem.softeng.gruppo14.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo14.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo14.gestionedati.Utente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gany
 */
public class GestioneUtentiTest {
    
    private GestioneUtenti gestioneUtenti;
    
    public GestioneUtentiTest() {
    }
    
    @BeforeEach
    public void setUp() {
        
        gestioneUtenti = new GestioneUtenti();
        
    }
    
    @Test
    public void testGestioneUtenti(){
        
        System.out.println("GestioneUtenti");
        assertNotNull(gestioneUtenti);
        assertNotNull(gestioneUtenti.getUtenti());
        
    }

    /**
     * Test of getUtenti method, of class GestioneUtenti.
     */
    @Test
    public void testGetUtenti() {
        
        System.out.println("getUtenti");
        Utente u = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u);
        List<Utente> expResult = Arrays.asList(u);
        assertEquals(expResult, gestioneUtenti.getUtenti());
        
    }

    /**
     * Test of aggiungiUtente method, of class GestioneUtenti.
     */
    @Test
    public void testAggiungiUtente() {
        
        System.out.println("aggiungiUtente");
        Utente u = new Utente("Francesca Gaia", "Amato", "0612708845", "f.amato46@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u);
        assertFalse(gestioneUtenti.getUtenti().isEmpty());
        assertTrue(gestioneUtenti.getUtenti().contains(u));
        assertEquals(1, gestioneUtenti.getUtenti().size());
        
    }
    
    @Test
    public void testAggiungiUtenteNull() {
        
        System.out.println("aggiungiUtente - Null");
        int sizeIniziale = gestioneUtenti.getUtenti().size();
        gestioneUtenti.aggiungiUtente(null);
        assertEquals(sizeIniziale, gestioneUtenti.getUtenti().size());
        
    }

    @Test
    public void testAggiungiUtenteDuplicato() {
        
        System.out.println("aggiungiUtente - Duplicato Matricola");
        Utente u1 = new Utente("Mario", "Rossi", "0612700001", "m.rossi@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u1);
        Utente u2 = new Utente("Luigi", "Verdi", "0612700001", "l.verdi@studenti.unisa.it");
        assertThrows(IllegalArgumentException.class, () -> 
            gestioneUtenti.aggiungiUtente(u2));
        
    }
    
    /**
     * Test of modificaUtente method, of class GestioneUtenti.
     */
    @Test
    public void testModificaUtente() {
        
        System.out.println("modificaUtente - Nome");
        Utente u1 = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u1);
        Utente u2 = new Utente("Andrea", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.modificaUtente(u1, u2);
        assertEquals("Andrea", u1.getNome());
        
    }

    @Test
    public void testModificaUtente1() {
        
        System.out.println("modificaUtente - Cognome");
        Utente u1 = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u1);
        Utente u2 = new Utente("Aniello", "De Falco", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.modificaUtente(u1, u2);
        assertEquals("De Falco", u1.getCognome());
        
    }
    
    @Test
    public void testModificaUtente2() {
        
        System.out.println("modificaUtente - Matricola");
        Utente u1 = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u1);
        Utente u2 = new Utente("Aniello", "De Marinis", "0612708888", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.modificaUtente(u1, u2);
        assertEquals("0612708888", u1.getMatricola());
        
    }
    
    @Test
    public void testModificaUtente3() {
        
        System.out.println("modificaUtente - E-mail");
        Utente u1 = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u1);
        Utente u2 = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis31@studenti.unisa.it");
        gestioneUtenti.modificaUtente(u1, u2);
        assertEquals("a.demarinis31@studenti.unisa.it", u1.getEmail());
        
    }
    
    @Test
    public void testModificaUtenteParametriNull() {
        
         System.out.println("modificaUtente - Parametri Null");
         Utente u = new Utente("Mario", "Rossi", "0612700001", "m.rossi@studenti.unisa.it");
         gestioneUtenti.aggiungiUtente(u);
         gestioneUtenti.modificaUtente(u, null);
         assertEquals("Mario", u.getNome(), "L'utente non deve cambiare se i nuovi dati sono null");
         
    }
    
    @Test
    public void testModificaUtenteNonPresente() {
        
        System.out.println("modificaUtente - Utente non in archivio");
        Utente uNonPresente = new Utente("Luigi", "User", "0612708860", "luigi@unisa.it");
        Utente uNuoviDati = new Utente("Mario", "User", "0612708860", "mario@unisa.it");
        assertFalse(gestioneUtenti.getUtenti().contains(uNonPresente));
        gestioneUtenti.modificaUtente(uNonPresente, uNuoviDati);
        assertFalse(gestioneUtenti.getUtenti().contains(uNonPresente));
        assertEquals(0, gestioneUtenti.getUtenti().size());
        
    }
    
    /**
     * Test of eliminaUtente method, of class GestioneUtenti.
     */
    @Test
    public void testEliminaUtente() {
        
        System.out.println("eliminaUtente");
        Utente u = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u);
        List<Prestito> prestitiVuoti = new ArrayList<>();
        gestioneUtenti.eliminaUtente(u, prestitiVuoti);
        assertTrue(gestioneUtenti.getUtenti().isEmpty());
        
    }
    
    @Test
    public void testEliminaUtenteNull() {
        
        System.out.println("eliminaUtente - Null");
        List<Prestito> prestiti = new ArrayList<>();
        assertDoesNotThrow(() -> gestioneUtenti.eliminaUtente(null, prestiti));
        
    }
    
    @Test
    public void testEliminaUtenteConPrestitoAttivo() {
        
        System.out.println("eliminaUtente - Utente con Prestito Attivo");
        Utente u = new Utente("Mario", "Rossi", "0612700001", "m.rossi@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u);
        Libro l = new Libro("Libro Test", Arrays.asList("Autore"), 2020, "978-88-12345", 1);
        Prestito p = new Prestito(l, u, LocalDate.now().plusDays(10));
        List<Prestito> listaPrestiti = new ArrayList<>();
        listaPrestiti.add(p);
        assertThrows(IllegalArgumentException.class, () -> 
            gestioneUtenti.eliminaUtente(u, listaPrestiti));
        
    }
    
    /**
     * Test of cercaUtente method, of class GestioneUtenti.
     */
    @Test
    public void testCercaUtente() {
        
        System.out.println("cercaUtente - Nome");
        String testo = "Aniel";
        Utente u = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u);
        List<Utente> result = gestioneUtenti.cercaUtente(testo);
        assertFalse(result.isEmpty());
        assertEquals("Aniello", result.get(0).getNome());
        
    }
    
    @Test
    public void testCercaUtente1() {
        
        System.out.println("cercaUtente - Cognome");
        String testo = "De Mar";
        Utente u = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u);
        List<Utente> result = gestioneUtenti.cercaUtente(testo);
        assertFalse(result.isEmpty());
        assertEquals("De Marinis", result.get(0).getCognome());
        
    }
    
    @Test
    public void testCercaUtente2() {
        
        System.out.println("cercaUtente - Matricola");
        String testo = "06127088";
        Utente u = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u);
        List<Utente> result = gestioneUtenti.cercaUtente(testo);
        assertFalse(result.isEmpty());
        assertEquals("0612708860", result.get(0).getMatricola());
        
    }
    
    @Test
    public void testCercaUtente3() {
        
        System.out.println("cercaUtente - E-mail");
        String testo = "a.demarinis@studenti.";
        Utente u = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u);
        List<Utente> result = gestioneUtenti.cercaUtente(testo);
        assertFalse(result.isEmpty());
        assertEquals("a.demarinis@studenti.unisa.it", result.get(0).getEmail());
        
    }
    
    @Test
    public void testCercaUtente4() {
        
        System.out.println("cercaUtente - Utente non presente");
        String testo = "Non presente";
        Utente u = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u);
        List<Utente> result = gestioneUtenti.cercaUtente(testo);
        assertTrue(result.isEmpty());
        
    }
    
    @Test
    public void testCercaUtente5() {
        
        System.out.println("cercaUtente - Stringa vuota");
        String testo = "";
        Utente u = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        gestioneUtenti.aggiungiUtente(u);
        List<Utente> result = gestioneUtenti.cercaUtente(testo);
        assertFalse(result.isEmpty());
        assertEquals(result, gestioneUtenti.getUtenti());
        
    }
    
}