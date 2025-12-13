package it.unisa.diem.softeng.gruppo14.gestionedati;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
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
public class ComparatorePrestitiTest {
    
    private Prestito o1;
    private Prestito o2;
    private ComparatorePrestiti c;
    private Utente utente;
    private Libro libro;
    
    public ComparatorePrestitiTest() {
    }
    
    @BeforeEach
    public void setUp() {
        
        c = new ComparatorePrestiti();
        utente = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        libro = new Libro("Harry Potter", Arrays.asList("J.K. Rowling"), 1997, "978-88-67890", 5);
    }
    
    /**
     * Test of compare method, of class ComparatorePrestiti.
     */
    @Test
    public void testCompare() {
        
        System.out.println("Compare - Data uguale");
        o1 = new Prestito(libro, utente, LocalDate.now());
        o2 = new Prestito(libro, utente, LocalDate.now());
        int expResult = 0;
        int result = c.compare(o1, o2);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testCompare1() {
        
        System.out.println("Compare - o1 precedente");
        o1 = new Prestito(libro, utente, LocalDate.of(2026, 12, 10));
        o2 = new Prestito(libro, utente, LocalDate.of(2026, 12, 15));
        int result = c.compare(o1, o2);
        assertTrue(result < 0);
        
    }
    
    @Test
    public void testCompare2() {
        
        System.out.println("Compare - o1 successivo");
        o1 = new Prestito(libro, utente, LocalDate.of(2026, 12, 15));
        o2 = new Prestito(libro, utente, LocalDate.of(2026, 12, 10));
        int result = c.compare(o1, o2);
        assertTrue(result > 0);
        
    }
    
    
}
