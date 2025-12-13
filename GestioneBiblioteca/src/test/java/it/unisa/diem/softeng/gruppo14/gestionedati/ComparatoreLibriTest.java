package it.unisa.diem.softeng.gruppo14.gestionedati;

import java.util.Arrays;
import java.util.List;
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
    private final List<String> autori = Arrays.asList("J.R.R. Tolkien");
    
    public ComparatoreLibriTest() {
    }

    @BeforeEach
    public void setUp() {
        
        c = new ComparatoreLibri();
        
    }

    @Test
    public void testCompare1(){
        
        System.out.println("Compare - Libro Uguale (Stesso Titolo, Stesso Anno)");
        o1 = new Libro("Il Signore degli Anelli", autori, 1954, "978-88-12345", 10); 
        o2 = new Libro("Il Signore degli Anelli", autori, 1954, "978-88-12345", 10);
        int expResult = 0;
        int result = c.compare(o1, o2);    
        assertEquals(expResult, result);
        
    }

    @Test
    public void testCompare2() {
        
        System.out.println("Compare - Titolo");
        o1 = new Libro("Il Signore degli Anelli", autori, 1997, "978-88-12345", 10);  
        o2 = new Libro("Harry Potter", autori, 1997, "978-88-67890", 10);
        int result = c.compare(o1, o2);
        assertTrue(result > 0);  
        
    }
    
    @Test
    public void testCompare3() {
        
        System.out.println("Compare - Titolo (Alfabetico: H vs I)");
        o1 = new Libro("Harry Potter", autori, 1997, "978-88-12345", 10);
        o2 = new Libro("Il Signore degli Anelli", autori, 1997, "978-88-67890", 10); 
        int result = c.compare(o1, o2);
        assertTrue(result < 0);
        
    }
    
    @Test
    public void testCompare4() {
        
        System.out.println("Compare - IgnoreCase");
        o1 = new Libro("il signore degli anelli", autori, 1954, "978-88-12345", 10);
        o2 = new Libro("Il Signore degli Anelli", autori, 1954, "978-88-67890", 10);
        int expResult = 0;
        int result = c.compare(o1, o2);
        assertEquals(expResult, result);
        
    }
    
    
    @Test
    public void testCompare5() {
        
        System.out.println("Compare - Anno pubblicazione");
        o1 = new Libro("Il Signore degli Anelli", autori, 1970, "978-88-12345", 10);
        o2 = new Libro("Il Signore degli Anelli", autori, 1954, "978-88-67890", 10); 
        int result = c.compare(o1, o2);
        assertTrue(result < 0);
        
    }
    
    @Test
    public void testCompare6() {
        
        System.out.println("Compare - Anno pubblicazione");
        o1 = new Libro("Il Signore degli Anelli", autori, 1954, "978-88-12345", 10);
        o2 = new Libro("Il Signore degli Anelli", autori, 1970, "978-88-67890", 10); 
        int result = c.compare(o1, o2);
        assertTrue(result > 0);
        
    }
}