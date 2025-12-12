/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo14.gestionedati;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Utente
 */
public class ComparatoreLibriTest {
    
    private Libro o1;
    private Libro o2;
    private ComparatoreLibri c;
    
    public ComparatoreLibriTest() {
    }

    @BeforeEach
    public void setUp() {
        c = new ComparatoreLibri();
    }

    @Test
    public void testCompare(){
        o1 = new Libro("Il Signore degli Anelli", 1954, null, 0); // Titolo, anno pubblicazione, ISBN, numero copie
        o2 = new Libro("Il Signore degli Anelli", 1954, null, 0);
        int expResult = 0;
        int result = c.compare(o1, o2);   
        assertEquals(expResult, result);
    }

    /**
     * Test of compare method, of class ComparatoreLibri.
     */
     @Test
    public void testCompare1() {
        o1 = new Libro("Il Signore degli Anelli", 1954, null, 0);  // Titolo, anno pubblicazione, ISBN, numero copie
        o2 = new Libro("Harry Potter", 1997, null, 0);
        int result1 = c.compare(o1, o2);
        assertTrue(result1 > 0);  
        
    }
    
    @Test
    public void testCompare2() {
        o1 = new Libro("Harry Potter", 1997, null, 0);
        o2 = new Libro("Il Signore degli Anelli", 1954, null, 0);  // Titolo, anno pubblicazione, ISBN, numero copie
        int result2 = c.compare(o1, o2);
        assertTrue(result2 < 0);
    }
    
    @Test
    public void testCompare3() {
        o1 = new Libro("il signore degli anelli", 1954, null, 0);
        o2 = new Libro("Il Signore degli Anelli", 1954, null, 0);  // Titolo, anno pubblicazione, ISBN, numero copie
        int expResult = 0;
        int result3 = c.compare(o1, o2);
        assertEquals(expResult, result3);
    }
    
}