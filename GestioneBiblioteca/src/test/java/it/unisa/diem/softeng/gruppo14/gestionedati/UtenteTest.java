package it.unisa.diem.softeng.gruppo14.gestionedati;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gruppo14
 */
public class UtenteTest {
    
    private Utente utente;
    
    public UtenteTest() {
    }
   
    @BeforeEach
    public void setUp() {
        
        utente = new Utente("Mario", "Rossi", "0612700001", "m.rossi@studenti.unisa.it");
        
    }
    
    /**
     * Test of getNome method, of class Utente.
     */
    @Test
    public void testGetNome() {
        
        System.out.println("getNome");
        String expResult = "Mario";
        String result = utente.getNome();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getCognome method, of class Utente.
     */
    @Test
    public void testGetCognome() {
        
        System.out.println("getCognome");
        String expResult = "Rossi";
        String result = utente.getCognome();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getMatricola method, of class Utente.
     */
    @Test
    public void testGetMatricola() {
        
        System.out.println("getMatricola");
        String expResult = "0612700001";
        String result = utente.getMatricola();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getEmail method, of class Utente.
     */
    @Test
    public void testGetEmail() {
        
        System.out.println("getEmail");
        String expResult = "m.rossi@studenti.unisa.it";
        String result = utente.getEmail();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setNome method, of class Utente.
     */
    @Test
    public void testSetNome() {
        
        System.out.println("setNome");
        String nome = "Luigi";
        utente.setNome(nome);
        String expResult = "Luigi";
        assertEquals(expResult, utente.getNome());
        
    }

    /**
     * Test of setCognome method, of class Utente.
     */
    @Test
    public void testSetCognome() {
        
        System.out.println("setCognome");
        String cognome = "Grigi";
        utente.setCognome(cognome);
        String expResult = "Grigi";
        assertEquals(expResult, utente.getCognome());
        
    }

    /**
     * Test of setMatricola method, of class Utente.
     */
    @Test
    public void testSetMatricola() {
        
        System.out.println("setMatricola");
        String matricola = "0612700002";
        utente.setMatricola(matricola);
        String expResult = "0612700002";
        assertEquals(expResult, utente.getMatricola());
        
    }

    /**
     * Test of setEmail method, of class Utente.
     */
    @Test
    public void testSetEmail() {
        
        System.out.println("setEmail");
        String email = "l.grigi@studenti.unisa.it";
        utente.setEmail(email);
        String expResult = "l.grigi@studenti.unisa.it";
        assertEquals(expResult, utente.getEmail());
        
    }

    /**
     * Test of toString method, of class Utente.
     */
    @Test
    public void testToString() {
        
        System.out.println("toString");
        String expResult = "Utente{nome=Mario, cognome=Rossi, matricola=0612700001, email=m.rossi@studenti.unisa.it}";
        String result = utente.toString();
        assertEquals(expResult, result);
        
    }
    
}
