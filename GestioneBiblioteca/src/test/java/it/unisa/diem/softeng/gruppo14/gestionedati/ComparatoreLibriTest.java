package it.unisa.diem.softeng.gruppo14.gestionedati;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gruppo14
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
        
        System.out.println("Compare - Libro Uguale");
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
        
        System.out.println("Compare - Titolo");
        o1 = new Libro("Il Signore degli Anelli", 1997, null, 0);  // Titolo, anno pubblicazione, ISBN, numero copie
        o2 = new Libro("Harry Potter", 1997, null, 0);
        int result = c.compare(o1, o2);
        assertTrue(result > 0);  
        
    }
    
    @Test
    public void testCompare2() {
        
        System.out.println("Compare - Titolo");
        o1 = new Libro("Harry Potter", 1997, null, 0);
        o2 = new Libro("Il Signore degli Anelli", 1997, null, 0);  // Titolo, anno pubblicazione, ISBN, numero copie
        int result = c.compare(o1, o2);
        assertTrue(result < 0);
        
    }
    
    @Test
    public void testCompare3() {
        
        System.out.println("Compare - IgnoreCase");
        o1 = new Libro("il signore degli anelli", 1954, null, 0);
        o2 = new Libro("Il Signore degli Anelli", 1954, null, 0);  // Titolo, anno pubblicazione, ISBN, numero copie
        int expResult = 0;
        int result = c.compare(o1, o2);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testCompare4() {
        
        System.out.println("Compare - Anno pubblicazione");
        o1 = new Libro("Il Signore degli Anelli", 1970, null, 0);
        o2 = new Libro("Il Signore degli Anelli", 1954, null, 0);  // Titolo, anno pubblicazione, ISBN, numero copie
        int result4 = c.compare(o1, o2);
        assertTrue(result4 < 0);
        
    }
    
    @Test
    public void testCompare5() {
        
        System.out.println("Compare - Anno pubblicazione");
        o1 = new Libro("Il Signore degli Anelli", 1954, null, 0);
        o2 = new Libro("Il Signore degli Anelli", 1970, null, 0);  // Titolo, anno pubblicazione, ISBN, numero copie
        int result5 = c.compare(o1, o2);
        assertTrue(result5 > 0);
        
    }
    
}