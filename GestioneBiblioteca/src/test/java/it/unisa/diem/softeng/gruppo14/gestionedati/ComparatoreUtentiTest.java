package it.unisa.diem.softeng.gruppo14.gestionedati;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gruppo14
 */
public class ComparatoreUtentiTest {
    
    private Utente o1 ; 
    private Utente o2;
    private ComparatoreUtenti c;
    
    
    public ComparatoreUtentiTest() {
    }
    
    
    
    @BeforeEach
    public void setUp() {
        
        c = new ComparatoreUtenti();
        
    }
  

    /**
     * Test of compare method, of class ComparatoreUtenti.
     */
    @Test
    public void testCompare() {
        
        System.out.println("Compare - Caso uguali");
        o1 = new Utente ("Andrea" , "Di Vito", "0612709214", "a.divito7@studenti.unisa.it");
        o2 = new Utente ("Andrea" , "Di Vito", "0612709214", "a.divito7@studenti.unisa.it");
        int expResult = 0;
        int result = c.compare(o1, o2);
        assertEquals(expResult, result);
        
    }
    
      @Test
    public void testCompare1() {
        
        System.out.println("Compare - Cognome");
        o1 = new Utente ("Andrea" , "De Marinis", "0612709214", "a.divito7@studenti.unisa.it");
        o2 = new Utente ("Andrea" , "Di Vito", "0612709214", "a.divito7@studenti.unisa.it");
        int result = c.compare(o1, o2);
        assertTrue(result < 0);
        
    }
    
     @Test
    public void testCompare2() {
        
        System.out.println("Compare - Cognome");
        o1 = new Utente ("Andrea" , "Di Vito", "0612709214", "a.divito7@studenti.unisa.it");
        o2 = new Utente ("Andrea" , "De Marinis", "0612709214", "a.divito7@studenti.unisa.it");
        int result = c.compare(o1, o2);
        assertTrue(result > 0);
        
    }
    
     @Test
    public void testCompare3() {
       
        System.out.println("Compare - Nome");
        o1 = new Utente ("Andrea" , "Di Vito", "0612709214", "a.divito7@studenti.unisa.it");
        o2 = new Utente ("Gaia" , "Di Vito", "0612709214", "a.divito7@studenti.unisa.it");
        int result = c.compare(o1, o2);
        assertTrue(result < 0);
        
    }
    
    @Test
    public void testCompare4() {
       
        System.out.println("Compare - Nome");
        o1 = new Utente ("Gaia" , "Di Vito", "0612709214", "a.divito7@studenti.unisa.it");
        o2 = new Utente ("Andrea" , "Di Vito", "0612709214", "a.divito7@studenti.unisa.it");
        int result = c.compare(o1, o2);
        assertTrue(result > 0);
        
    }
    
    @Test
    public void testCompare5() {
       
        System.out.println("Compare - Matricola");
        o1 = new Utente ("Andrea" , "Di Vito", "0612709214", "a.divito7@studenti.unisa.it");
        o2 = new Utente ("Andrea" , "Di Vito", "0612709215", "a.divito7@studenti.unisa.it");
        int result = c.compare(o1, o2);
        assertTrue(result < 0);
        
    }
    
     @Test
    public void testCompare6() {
        
        System.out.println("Compare - Matricola");
        o1 = new Utente ("Andrea" , "Di Vito", "0612709215", "a.divito7@studenti.unisa.it");
        o2 = new Utente ("Andrea" , "Di Vito", "0612709214", "a.divito7@studenti.unisa.it");
        int result = c.compare(o1, o2);
        assertTrue(result > 0);
       
    }
    
     @Test
    public void testCompare7() {
       
        System.out.println("Compare - IgnoreCase");
        o1 = new Utente ("andrea" , "di vito", "0612709214", "a.divito7@studenti.unisa.it");
        o2 = new Utente ("Andrea" , "Di Vito", "0612709214", "a.divito7@studenti.unisa.it");
        int expResult = 0;
        int result = c.compare(o1, o2);
        assertEquals(expResult, result);
  
    }
    
}
