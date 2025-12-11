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
    public void testComparatoreLibri1(){
        System.out.println("compare");
        o1 = new Libro("Il Singore degli Anelli", 0, null, 0); // Titolo, anno pubblicazione, ISBN, numero copie
        o2 = new Libro("Il Signore degli Anelli", 0, null, 0);
        int expResult = 0;
        int result1 = c.compare(o1, o2);   
        assertEquals(expResult, result1);
    }

    /**
     * Test of compare method, of class ComparatoreLibri.
     */
     @Test
    public void testCompare2() {
        System.out.println("compare");
        o1 = new Libro("Il Signore degli Anelli", 0, null, 0);  // Titolo, anno pubblicazione, ISBN, numero copie
        o2 = new Libro("Harry Potter", 0, null, 0);
        int result2 = c.compare(o1, o2);
        assertTrue(result2 > 0);  
        
    }
    
    @Test
    public void testCompare3() {
        System.out.println("compare");
        o1 = new Libro("Harry Potter", 0, null, 0);
        o2 = new Libro("Il Signore degli Anelli", 0, null, 0);  // Titolo, anno pubblicazione, ISBN, numero copie
        int result3 = c.compare(o1, o2);
        assertTrue(result3 < 0);
    }
}