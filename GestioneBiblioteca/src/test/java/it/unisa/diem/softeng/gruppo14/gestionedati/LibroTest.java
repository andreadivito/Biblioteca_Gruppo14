package it.unisa.diem.softeng.gruppo14.gestionedati;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
public class LibroTest {
    
    private Libro libro;
    private List<String> autori; 
    
    public LibroTest() {
    }
   
    @BeforeEach
    public void setUp() {
        autori = new ArrayList<>();
        autori.add("J.R.R. Tolkien");
        libro = new Libro("Il Signore degli Anelli", autori, 1954, "978-88-12345", 5);
        
    }
    
    @Test
    public void testCostruttoreTitoloInvalido() {
        System.out.println("Costruttore - Titolo Invalido");
        assertThrows(IllegalArgumentException.class, () -> {
            new Libro(null, autori, 2000, "978-88-12345", 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Libro("", autori, 2000, "978-88-12345", 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Libro("   ", autori, 2000, "978-88-12345", 1);
        });
    }
    
    @Test
    public void testCostruttoreAutoriInvalidi() {
        System.out.println("Costruttore - Autori Invalidi");
        assertThrows(IllegalArgumentException.class, () -> {
            new Libro("Titolo", null, 2000, "978-88-12345", 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Libro("Titolo", new ArrayList<>(), 2000, "978-88-12345", 1);
        });
    }
    
    @Test
    public void testCostruttoreAnnoInvalido() {
        System.out.println("Costruttore - Anno Futuro");
        int annoFuturo = LocalDate.now().getYear() + 1;
        assertThrows(IllegalArgumentException.class, () -> {
            new Libro("Titolo", autori, annoFuturo, "978-88-12345", 1);
        });
    }
    
    @Test
    public void testCostruttoreISBNInvalido() {
        
        System.out.println("Costruttore - ISBN Invalido");
        assertThrows(IllegalArgumentException.class, () -> {
            new Libro("Titolo", autori, 2000, null, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Libro("Titolo", autori, 2000, "123-456", 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Libro("Titolo", autori, 2000, "978-88-ABCDE", 1);
        });
        
    }
    
    @Test
    public void testCostruttoreNumCopieInvalido() {
        
        System.out.println("Costruttore - Copie Invalidi");
        assertThrows(IllegalArgumentException.class, () -> {
            new Libro("Titolo", autori, 2000, "978-88-12345", 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Libro("Titolo", autori, 2000, "978-88-12345", -5);
        });
        
    }
    
    /**
     * Test of getTitolo method, of class Libro.
     */
    @Test
    public void testGetTitolo() {
        
        System.out.println("getTitolo");
        String expResult = "Il Signore degli Anelli";
        String result = libro.getTitolo();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAutori method, of class Libro.
     */
    @Test
    public void testGetAutori() {
        
        System.out.println("getAutori");
        List<String> result = libro.getAutori();
        assertEquals(1, result.size());
        assertEquals("J.R.R. Tolkien", result.get(0));
        
    }

    /**
     * Test of getAnnoPubblicazione method, of class Libro.
     */
    @Test
    public void testGetAnnoPubblicazione() {
        
        System.out.println("getAnnoPubblicazione");
        int expResult = 1954;
        int result = libro.getAnnoPubblicazione();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getISBN method, of class Libro.
     */
    @Test
    public void testGetISBN() {
        
        System.out.println("getISBN");
        String expResult = "978-88-12345";
        String result = libro.getISBN();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getNumCopie method, of class Libro.
     */
    @Test
    public void testGetNumCopie() {
        
        System.out.println("getNumCopie");
        int expResult = 5;
        int result = libro.getNumCopie();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setTitolo method, of class Libro.
     */
    @Test
    public void testSetTitolo() {
        
        System.out.println("setTitolo");
        String titolo = "Harry Potter";
        libro.setTitolo(titolo);
        String expResult = "Harry Potter";
        assertEquals(expResult, libro.getTitolo());
        
    }

    @Test
    public void testSetTitoloInvalido() {
        
        System.out.println("setTitolo - Invalido");
        assertThrows(IllegalArgumentException.class, () -> libro.setTitolo(null));
        assertThrows(IllegalArgumentException.class, () -> libro.setTitolo(""));
        assertThrows(IllegalArgumentException.class, () -> libro.setTitolo("   "));
        
    }
    
    /**
     * Test of setAutori method, of class Libro.
     */
    @Test
    public void testSetAutori() {
        
        System.out.println("setAutori");
        List<String> nuoviAutori = new ArrayList<>();
        nuoviAutori.add("J. K. Rowling");
        libro.setAutori(nuoviAutori);
        List<String> expResult = nuoviAutori;
        assertEquals(expResult, libro.getAutori());
        
    }

    @Test
    public void testSetAutoriInvalidi() {
        
        System.out.println("setAutori - Invalido");
        assertThrows(IllegalArgumentException.class, () -> libro.setAutori(null));
        assertThrows(IllegalArgumentException.class, () -> libro.setAutori(new ArrayList<>()));
        
    }
    
    /**
     * Test of setAnnoPubblicazione method, of class Libro.
     */
    @Test
    public void testSetAnnoPubblicazione() {
        
        System.out.println("setAnnoPubblicazione");
        int annoPubblicazione = 1997;
        libro.setAnnoPubblicazione(annoPubblicazione);
        int expResult = 1997;
        assertEquals(expResult, libro.getAnnoPubblicazione());
        
    }

    @Test
    public void testSetAnnoPubblicazioneInvalido() {
        
        System.out.println("setAnnoPubblicazione - Futuro");
        int annoFuturo = LocalDate.now().getYear() + 1;
        assertThrows(IllegalArgumentException.class, () -> libro.setAnnoPubblicazione(annoFuturo));
        
    }
    
    /**
     * Test of setISBN method, of class Libro.
     */
    @Test
    public void testSetISBN() {
        
        System.out.println("setISBN");
        String ISBN = "978-88-67890";
        libro.setISBN(ISBN);
        String expResult = "978-88-67890";
        assertEquals(expResult, libro.getISBN());
        
    }

    @Test
    public void testSetISBNInvalido() {
        
        System.out.println("setISBN - Invalido");
        assertThrows(IllegalArgumentException.class, () -> libro.setISBN(null));
        assertThrows(IllegalArgumentException.class, () -> libro.setISBN("ISBN-Sbagliato"));
        
    }
    
    /**
     * Test of setNumCopie method, of class Libro.
     */
    @Test
    public void testSetNumCopie() {
        
        System.out.println("setNumCopie");
        int numCopie = 3;
        libro.setNumCopie(numCopie);
        int expResult = 3;
        assertEquals(expResult, libro.getNumCopie());
        
    }

    @Test
    public void testSetNumCopieInvalido() {
        
        System.out.println("setNumCopie - Invalido");
        assertThrows(IllegalArgumentException.class, () -> libro.setNumCopie(0));
        assertThrows(IllegalArgumentException.class, () -> libro.setNumCopie(-1));
        
    }
    
    /**
     * Test of decrementaCopie method, of class Libro.
     */
    @Test
    public void testDecrementaCopie() {
        
        System.out.println("decrementaCopie");
        libro.decrementaCopie();
        int expResult = 4;
        assertEquals(expResult, libro.getNumCopie());
        
    }

    @Test
    public void testDecrementaCopieSottoZero() {            //Boundary test
        
        System.out.println("decrementaCopieSottoZero");
        libro.setNumCopie(1);
        libro.decrementaCopie();
        assertEquals(0, libro.getNumCopie(), "Dovrei avere 0 copie ora");
        libro.decrementaCopie();
        assertEquals(0, libro.getNumCopie(), "Errore: le copie sono scese sotto lo zero");
        
    }
    
    /**
     * Test of incrementaCopie method, of class Libro.
     */
    @Test
    public void testIncrementaCopie() {
        
        System.out.println("incrementaCopie");
        libro.incrementaCopie();
        int expResult = 6;
        assertEquals(expResult, libro.getNumCopie());
        
    }
    
    /**
     * Test of toString method, of class Libro.
     */
    @Test
    public void testToString() {
        
        System.out.println("toString");
        List<String> autori = new ArrayList<>();
        autori.add("Tolkien");
        libro.setAutori(autori);
        String expResult = "Libro{titolo=Il Signore degli Anelli, autori=[Tolkien], annoPubblicazione=1954, ISBN=978-88-12345, numCopie=5}";
        String result = libro.toString();
        assertEquals(expResult, result);
        
    }
    
    
}