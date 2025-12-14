package it.unisa.diem.softeng.gruppo14.gestionelogica;

import it.unisa.diem.softeng.gruppo14.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo14.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo14.gestionedati.Utente;
import java.time.LocalDate;
import java.util.Arrays; // Import necessario
import java.util.List;
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
public class GestionePrestitiTest {
    
    private GestionePrestiti gestionePrestiti;
    private Libro libro;
    private Utente utente;
    private LocalDate dataScadenza;
    
    public GestionePrestitiTest() {
    }
    
    @BeforeEach
    public void setUp() {
        gestionePrestiti = new GestionePrestiti();
        libro = new Libro("Harry Potter", Arrays.asList("J.K. Rowling"), 1997, "978-88-67890", 5);
        utente = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        dataScadenza = LocalDate.now().plusDays(30);
    }

    @Test
    public void testGestionePrestiti(){
        
        System.out.println("GestionePrestiti");
        assertNotNull(gestionePrestiti.getPrestiti());
        assertTrue(gestionePrestiti.getPrestiti().isEmpty());
        
    }
    
    /**
     * Test of getPrestiti method, of class GestionePrestiti.
     */
    @Test
    public void testGetPrestiti() {
        
        System.out.println("getPrestiti");
        gestionePrestiti.registraPrestito(libro, utente, dataScadenza);
        List<Prestito> result = gestionePrestiti.getPrestiti();
        assertEquals(1, result.size());
        Prestito p = result.get(0);
        assertEquals(libro, p.getLibro());
        assertEquals(utente, p.getUtente());
        assertEquals(dataScadenza, p.getDataRestituzione());
        
    }

    /**
     * Test of registraPrestito method, of class GestionePrestiti.
     */
    @Test
    public void testRegistraPrestito() {
        
        System.out.println("registraPrestito - Successo");
        gestionePrestiti.registraPrestito(libro, utente, dataScadenza);
        assertFalse(gestionePrestiti.getPrestiti().isEmpty());
        assertEquals(1, gestionePrestiti.getPrestiti().size());
        assertEquals(4, libro.getNumCopie());
        
    }

    @Test
    public void testRegistraPrestito1() {
        
        System.out.println("registraPrestito - Fallimento numero Copie");
        libro.setNumCopie(1);
        libro.decrementaCopie();
        assertEquals(0, libro.getNumCopie());
        gestionePrestiti.registraPrestito(libro, utente, dataScadenza);
        assertTrue(gestionePrestiti.getPrestiti().isEmpty(), "Il prestito non doveva essere aggiunto perché le copie sono 0");
        assertEquals(0, libro.getNumCopie(), "Le copie devono restare 0 e non diventare negative");
        
    }
    
    @Test
    public void testRegistraPrestito2() {
        
        System.out.println("registraPrestito - Fallimento numero massimo raggiunto");
        Libro l1 = new Libro("L1", Arrays.asList("A1"), 2000, "978-88-11111", 5);
        Libro l2 = new Libro("L2", Arrays.asList("A2"), 2000, "978-88-22222", 5);
        Libro l3 = new Libro("L3", Arrays.asList("A3"), 2000, "978-88-33333", 5);
        Libro l4 = new Libro("L4", Arrays.asList("A4"), 2000, "978-88-44444", 5);
        gestionePrestiti.registraPrestito(l1, utente, dataScadenza);
        gestionePrestiti.registraPrestito(l2, utente, dataScadenza);
        gestionePrestiti.registraPrestito(l3, utente, dataScadenza);
        assertEquals(3, gestionePrestiti.getPrestiti().size(), "Dovrebbero esserci 3 prestiti attivi");
        assertThrows(IllegalArgumentException.class, () -> {
            gestionePrestiti.registraPrestito(l4, utente, dataScadenza);
        });
        assertEquals(3, gestionePrestiti.getPrestiti().size(), "L'utente non deve superare i 3 prestiti");
        assertEquals(5, l4.getNumCopie(), "Le copie del libro non prestato non devono diminuire");
        
    }
    
    
    /**
     * Test of registraRestituzione method, of class GestionePrestiti.
     */
    @Test
    public void testRegistraRestituzione() {
        
        System.out.println("registraRestituzione");
        gestionePrestiti.registraPrestito(libro, utente, dataScadenza);
        assertEquals(4, libro.getNumCopie());
        Prestito p = gestionePrestiti.getPrestiti().get(0);
        gestionePrestiti.registraRestituzione(p);
        assertTrue(gestionePrestiti.getPrestiti().isEmpty());
        assertEquals(5, libro.getNumCopie());
     
    }

}
