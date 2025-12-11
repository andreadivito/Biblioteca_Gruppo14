/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo14.gestionedati;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Utente
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
       
        o1 = new Utente ("Andrea" , "Di Vito", "001", "a1@gmail.com");
        o2 = new Utente ("Andrea" , "Di Vito", "001", "a1@gmail.com");
        int expResult = 0;
        int result = c.compare(o1, o2);
        assertEquals(expResult, result);
        
    }
    
      @Test
    public void testCompare1() {
       
        o1 = new Utente ("Andrea" , "De Marinis", "001", "a1@gmail.com");
        o2 = new Utente ("Andrea" , "Di Vito", "001", "a2@gmail.com");
        int result1 = c.compare(o1, o2);
        assertTrue(result1 < 0);
        
    }
    
     @Test
    public void testCompare2() {
       
        o1 = new Utente ("Andrea" , "Di Vito", "001", "a1@gmail.com");
        o2 = new Utente ("Andrea" , "De Marinis", "001", "a2@gmail.com");
        int result2 = c.compare(o1, o2);
        assertTrue(result2 > 0);
        
    }
    
     @Test
    public void testCompare3() {
       
        o1 = new Utente ("Andrea" , "Di Vito", "001", "a1@gmail.com");
        o2 = new Utente ("Gaia" , "Di Vito", "001", "a2@gmail.com");
        int result3 = c.compare(o1, o2);
        assertTrue(result3 < 0);
        
    }
    
    @Test
    public void testCompare4() {
       
        o1 = new Utente ("Gaia" , "Di Vito", "001", "a1@gmail.com");
        o2 = new Utente ("Andrea" , "Di Vito", "001", "a2@gmail.com");
        int result4 = c.compare(o1, o2);
        assertTrue(result4 > 0);
        
    }
    
    @Test
    public void testCompare5() {
       
        o1 = new Utente ("Andrea" , "Di Vito", "001", "a1@gmail.com");
        o2 = new Utente ("Andrea" , "Di Vito", "002", "a2@gmail.com");
        int result5 = c.compare(o1, o2);
        assertTrue(result5 < 0);
        
    }
    
     @Test
    public void testCompare6() {
       
        o1 = new Utente ("Andrea" , "Di Vito", "002", "a1@gmail.com");
        o2 = new Utente ("Andrea" , "Di Vito", "001", "a2@gmail.com");
        int result6 = c.compare(o1, o2);
        assertTrue(result6 > 0);
       
    }
    
     @Test
    public void testCompare7() {
       
        o1 = new Utente ("andrea" , "di vito", "002", "a1@gmail.com");
        o2 = new Utente ("Andrea" , "Di Vito", "001", "a2@gmail.com");
        int expResult = 0;
        int result7 = c.compare(o1, o2);
        assertEquals(expResult, result7);
        
    }
    
}
