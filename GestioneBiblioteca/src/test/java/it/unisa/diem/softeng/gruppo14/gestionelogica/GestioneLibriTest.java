package it.unisa.diem.softeng.gruppo14.gestionelogica;

import it.unisa.diem.softeng.gruppo14.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo14.gestionedati.Prestito;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author gruppo14
 */
public class GestioneLibriTest {
    
    private GestioneLibri gestioneLibri;
    
    public GestioneLibriTest() {
    }
    
    @BeforeEach
    public void setUp() {
        
        gestioneLibri = new GestioneLibri();
        
    }
    
    @Test
    public void testGestioneLibri(){
        
        System.out.println("GestioneLibri");
        assertNotNull(gestioneLibri);
        assertNotNull(gestioneLibri.getLibri());
        
    }

    @Test
    public void testGetLibri() {
        
        System.out.println("getLibri");
        Libro l = new Libro("Harry Potter", Arrays.asList("J.K. Rowling"), 1997, "978-88-67890", 1);
        gestioneLibri.aggiungiLibro(l);
        List<Libro> expResult = Arrays.asList(l);
        assertEquals(expResult, gestioneLibri.getLibri());
        
    }

    @Test
    public void testAggiungiLibro() {
        
        System.out.println("aggiungiLibro");
        Libro l = new Libro("Harry Potter", Arrays.asList("J.K. Rowling"), 1997, "978-88-67890", 1);
        gestioneLibri.aggiungiLibro(l);
        assertFalse(gestioneLibri.getLibri().isEmpty());
        assertTrue(gestioneLibri.getLibri().contains(l));
        assertEquals(1, gestioneLibri.getLibri().size());
        
    }

    @Test
    public void testModificaLibro1() {
        
        System.out.println("modificaLibro - Titolo");
        Libro l1 = new Libro("Il Trono di Spade", Arrays.asList("G.R.R. Martin"), 1996, "978-88-11111", 1);
        gestioneLibri.aggiungiLibro(l1);
        Libro l2 = new Libro("Il Trono di Spade 2", Arrays.asList("G.R.R. Martin"), 1996, "978-88-11111", 1);
        gestioneLibri.modificaLibro(l1, l2);
        assertEquals("Il Trono di Spade 2", l1.getTitolo());
        
    }
    
    @Test
    public void testModificaLibro2() {
        
        System.out.println("modificaLibro - Anno");
        Libro l1 = new Libro("Il Trono di Spade", Arrays.asList("G.R.R. Martin"), 1996, "978-88-11111", 1);
        gestioneLibri.aggiungiLibro(l1);
        Libro l2 = new Libro("Il Trono di Spade", Arrays.asList("G.R.R. Martin"), 2008, "978-88-11111", 1);
        gestioneLibri.modificaLibro(l1, l2);
        assertEquals(2008, l1.getAnnoPubblicazione());
        
    }
    
    @Test
    public void testModificaLibro3() {
        
        System.out.println("modificaLibro - ISBN");
        Libro l1 = new Libro("Il Trono di Spade", Arrays.asList("G.R.R. Martin"), 1996, "978-88-11111", 1);
        gestioneLibri.aggiungiLibro(l1);
        Libro l2 = new Libro("Il Trono di Spade", Arrays.asList("G.R.R. Martin"), 1996, "978-88-11122", 1);
        gestioneLibri.modificaLibro(l1, l2);
        assertEquals("978-88-11122", l1.getISBN());
        
    }
    
    @Test
    public void testModificaLibro4() {
        
        System.out.println("modificaLibro - Copie");
        Libro l1 = new Libro("Il Trono di Spade", Arrays.asList("G.R.R. Martin"), 1996, "978-88-11111", 3);
        gestioneLibri.aggiungiLibro(l1);
        Libro l2 = new Libro("Il Trono di Spade", Arrays.asList("G.R.R. Martin"), 1996, "978-88-11111", 7);
        gestioneLibri.modificaLibro(l1, l2);
        assertEquals(7, l1.getNumCopie());
        
    }
    
    @Test
    public void testModificaLibro5() {
        
        System.out.println("modificaLibro - Autori");
        List<String> autori1 = Arrays.asList("George R. R. Martin");
        Libro l1 = new Libro("Il Trono di Spade", autori1, 1996, "978-88-11122", 3);
        gestioneLibri.aggiungiLibro(l1);
        List<String> autori2 = Arrays.asList("Elio M. García Jr.", "Linda Antonsson");
        Libro l2 = new Libro("Il Trono di Spade", autori2, 1996, "978-88-11122", 3);
        gestioneLibri.modificaLibro(l1, l2);
        assertEquals(autori2, l1.getAutori());
        assertEquals(2, l1.getAutori().size());
        
    }

    @Test
    public void testEliminaLibro() {
        
        System.out.println("eliminaLibro - Caso Senza Prestiti");
        Libro l = new Libro("Il Trono di Spade", Arrays.asList("G.R.R. Martin"), 1996, "978-88-11111", 3);
        gestioneLibri.aggiungiLibro(l);
        List<Prestito> prestitiVuoti = new ArrayList<>();
        gestioneLibri.eliminaLibro(l, prestitiVuoti);
        assertTrue(gestioneLibri.getLibri().isEmpty());
        
    }

    @Test
    public void testCercaLibro1() {
        
        System.out.println("cercaLibro - Titolo");
        String testo = "Signore";
        Libro l = new Libro("Il Signore degli Anelli", Arrays.asList("Tolkien"), 1954, "978-88-12345", 5); 
        gestioneLibri.aggiungiLibro(l);
        List<Libro> result = gestioneLibri.cercaLibro(testo);
        assertFalse(result.isEmpty());
        assertEquals("Il Signore degli Anelli", result.get(0).getTitolo());
        
    }
    
    @Test
    public void testCercaLibro2() {
        
        System.out.println("cercaLibro - ISBN");
        String testo = "978-88-12";
        Libro l = new Libro("Il Signore degli Anelli", Arrays.asList("Tolkien"), 1954, "978-88-12345", 5); 
        gestioneLibri.aggiungiLibro(l);
        List<Libro> result = gestioneLibri.cercaLibro(testo);
        assertFalse(result.isEmpty());
        assertEquals("978-88-12345", result.get(0).getISBN());
        
    }
    
    @Test
    public void testCercaLibro3() {
        
        System.out.println("cercaLibro - Autori");
        String testo = "Tolk";
        Libro l = new Libro("Il Signore degli Anelli", Arrays.asList("J.R.R. Tolkien"), 1954, "978-88-12345", 5);
        gestioneLibri.aggiungiLibro(l);
        List<Libro> result = gestioneLibri.cercaLibro(testo);
        assertFalse(result.isEmpty());
        assertEquals("J.R.R. Tolkien", result.get(0).getAutori().get(0));
        
    }
    
    @Test
    public void testCercaLibro4() {
        
        System.out.println("cercaLibro - Stringa vuota");
        String testo = "";
        Libro l = new Libro("Il Signore degli Anelli", Arrays.asList("Tolkien"), 1954, "978-88-12345", 5);
        gestioneLibri.aggiungiLibro(l);
        List<Libro> result = gestioneLibri.cercaLibro(testo);
        assertFalse(result.isEmpty());
        assertEquals(result, gestioneLibri.getLibri());
        
    }
    
    @Test
    public void testCercaLibro5() {
        
        System.out.println("cercaLibro - Libro non presente");
        String testo = "Non presente";
        Libro l = new Libro("Il Signore degli Anelli", Arrays.asList("Tolkien"), 1954, "978-88-12345", 5);
        gestioneLibri.aggiungiLibro(l);
        List<Libro> result = gestioneLibri.cercaLibro(testo);
        assertTrue(result.isEmpty());
        
    }
    
}