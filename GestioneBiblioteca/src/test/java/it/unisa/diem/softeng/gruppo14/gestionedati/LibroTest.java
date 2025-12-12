/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo14.gestionedati;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andre
 */
public class LibroTest {
    
    private Libro libro;
    
    public LibroTest() {
    }
   
    @BeforeEach
    public void setUp() {
        
        libro = new Libro("Il Signore degli Anelli", 1954, "978-88-12345", 5);
        
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
        List<String> autori = new ArrayList<>();
        autori.add("Tolkien");
        libro.setAutori(autori);
        List<String> expResult = libro.getAutori();
        assertEquals(1, expResult.size());
        assertEquals("Tolkien", expResult.get(0));
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

    /**
     * Test of setAutori method, of class Libro.
     */
    @Test
    public void testSetAutori() {
        System.out.println("setAutori");
        List<String> autori = new ArrayList<>();
        autori.add("J. K. Rowling");
        libro.setAutori(autori);
        List<String> expResult = autori;
        assertEquals(expResult, libro.getAutori());
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
        libro.setNumCopie(0);
        libro.decrementaCopie();
        int expResult = 0;
        assertEquals(expResult, libro.getNumCopie(), "Errore: le copie sono scese sotto lo zero!");
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
