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
    
    @Test
    public void testCostruttoreNomeNonValido() {
        
        System.out.println("Costruttore - Nome Invalidi");
        assertThrows(IllegalArgumentException.class, () -> 
            new Utente(null, "Rossi", "0612700001", "m.rossi@studenti.unisa.it"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Utente("", "Rossi", "0612700001", "m.rossi@studenti.unisa.it"));
        
    }
    
    @Test
    public void testCostruttoreCognomeNonValido() {
        
        System.out.println("Costruttore - Cognome Invalidi");
        assertThrows(IllegalArgumentException.class, () -> 
            new Utente("Mario", null, "0612700001", "m.rossi@studenti.unisa.it"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Utente("Mario", "", "0612700001", "m.rossi@studenti.unisa.it"));
        
    }
    
    @Test
    public void testCostruttoreMatricolaNonValida() {
        
        System.out.println("Costruttore - Matricola Invalida");
        assertThrows(IllegalArgumentException.class, () -> 
            new Utente("Mario", "Rossi", null, "m.rossi@studenti.unisa.it"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Utente("Mario", "Rossi", "123", "m.rossi@studenti.unisa.it"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Utente("Mario", "Rossi", "012345678912", "m.rossi@studenti.unisa.it"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Utente("Mario", "Rossi", "ABC1234567", "m.rossi@studenti.unisa.it"));
        
    }
    
    @Test
    public void testCostruttoreEmailNonValida() {
        
        System.out.println("Costruttore - Email Invalidi");
        assertThrows(IllegalArgumentException.class, () -> 
            new Utente("Mario", "Rossi", "0612700001", null));
        assertThrows(IllegalArgumentException.class, () -> 
            new Utente("Mario", "Rossi", "0612700001", ""));
        assertThrows(IllegalArgumentException.class, () -> 
            new Utente("Mario", "Rossi", "0612700001", "mario@gmail.com"));
        
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

    @Test
    public void testSetNomeNonValido() {
        
        System.out.println("SetNome - Valori Invalidi");
        assertThrows(IllegalArgumentException.class, () -> utente.setNome(null));
        assertThrows(IllegalArgumentException.class, () -> utente.setNome(""));
        assertThrows(IllegalArgumentException.class, () -> utente.setNome("   "));
        
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

    @Test
    public void testSetCognomeNonValido() {
        
        System.out.println("SetCognome - Valori Invalidi");
        assertThrows(IllegalArgumentException.class, () -> utente.setCognome(null));
        assertThrows(IllegalArgumentException.class, () -> utente.setCognome(""));
        
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
    
    @Test
    public void testSetMatricolaNonValida() {
        
        System.out.println("SetMatricola - Valori Invalidi");
        assertThrows(IllegalArgumentException.class, () -> utente.setMatricola(null));
        assertThrows(IllegalArgumentException.class, () -> utente.setMatricola("")); 
        assertThrows(IllegalArgumentException.class, () -> utente.setMatricola("12345")); 
        assertThrows(IllegalArgumentException.class, () -> utente.setMatricola("012345678912")); 
        assertThrows(IllegalArgumentException.class, () -> utente.setMatricola("061270000A")); 
        
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

    @Test
    public void testSetEmailNonValida() {
        
        System.out.println("SetEmail - Valori Invalidi");
        assertThrows(IllegalArgumentException.class, () -> utente.setEmail(null));
        assertThrows(IllegalArgumentException.class, () -> utente.setEmail(""));
        assertThrows(IllegalArgumentException.class, () -> utente.setEmail("mario.rossi")); 
        assertThrows(IllegalArgumentException.class, () -> utente.setEmail("mario@libero.it")); 
        
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
