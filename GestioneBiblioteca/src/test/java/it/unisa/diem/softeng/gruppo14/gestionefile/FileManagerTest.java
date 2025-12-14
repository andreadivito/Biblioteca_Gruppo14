package it.unisa.diem.softeng.gruppo14.gestionefile;

import it.unisa.diem.softeng.gruppo14.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo14.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo14.gestionedati.Utente;
import it.unisa.diem.softeng.gruppo14.gestionelogica.GestioneLibri;
import it.unisa.diem.softeng.gruppo14.gestionelogica.GestionePrestiti;
import it.unisa.diem.softeng.gruppo14.gestionelogica.GestioneUtenti;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * @author gruppo14
 */
public class FileManagerTest {
    
    private GestioneLibri gestioneLibri;
    private GestioneUtenti gestioneUtenti;
    private GestionePrestiti gestionePrestiti;
    private FileManager fileManager;
    private final String TEST_FILE = "test_archivio.dat";
    
    @BeforeEach
    public void setUp() {
        
        gestioneLibri = new GestioneLibri();
        gestioneUtenti = new GestioneUtenti();
        gestionePrestiti = new GestionePrestiti();
        fileManager = new FileManager(gestioneLibri, gestioneUtenti, gestionePrestiti);
        
    }
    
    @AfterEach
    public void tearDown() {
        
        File f = new File(TEST_FILE);
        if (f.exists()) {
            f.delete();
        }
        
    }

    /**
     * Test Principale: Popoliamo i gestori, salviamo, svuotiamo e ricarichiamo.
     * Verifica che i dati tornino esattamente come erano.
     */
    @Test
    public void testSalvaECaricaDati() throws IOException, ClassNotFoundException {
        
        System.out.println("Salva e Carica - Flusso Completo");
        Libro l = new Libro("Java Programming", Arrays.asList("Luca Greco"), 2022, "978-88-10101", 5);
        Utente u = new Utente("Aniello", "De Marinis", "0612708860", "a.demarinis@studenti.unisa.it");
        Prestito p = new Prestito(l, u, LocalDate.now().plusDays(30));
        gestioneLibri.aggiungiLibro(l);
        gestioneUtenti.aggiungiUtente(u);
        gestionePrestiti.registraPrestito(l, u, LocalDate.now().plusDays(30)); 
        assertFalse(gestioneLibri.getLibri().isEmpty());
        assertFalse(gestionePrestiti.getPrestiti().isEmpty());
        fileManager.salvaSuFile(TEST_FILE);
        gestioneLibri.getLibri().clear();
        gestioneUtenti.getUtenti().clear();
        gestionePrestiti.getPrestiti().clear();
        assertTrue(gestioneLibri.getLibri().isEmpty());
        fileManager.caricaDaFile(TEST_FILE);
        assertEquals(1, gestioneLibri.getLibri().size(), "Deve esserci 1 libro caricato");
        assertEquals(1, gestioneUtenti.getUtenti().size(), "Deve esserci 1 utente caricato");
        assertEquals(1, gestionePrestiti.getPrestiti().size(), "Deve esserci 1 prestito caricato");
        Libro libroCaricato = gestioneLibri.getLibri().get(0);
        assertEquals("Java Programming", libroCaricato.getTitolo());
        assertEquals("978-88-10101", libroCaricato.getISBN());
        
    }

    /**
     * Test: Salvataggio e caricamento di liste vuote.
     * Non deve esplodere e le liste devono restare vuote.
     */
    @Test
    public void testSalvaECaricaVuoto() throws IOException, ClassNotFoundException {
        
        System.out.println("Salva e Carica - Archivio Vuoto");
        fileManager.salvaSuFile(TEST_FILE);
        fileManager.caricaDaFile(TEST_FILE);
        assertTrue(gestioneLibri.getLibri().isEmpty());
        assertTrue(gestioneUtenti.getUtenti().isEmpty());
        assertTrue(gestionePrestiti.getPrestiti().isEmpty());
        
    }

    /**
     * Test: Caricamento di un file che non esiste.
     * Il metodo dovrebbe uscire silenziosamente senza errori.
     */
    @Test
    public void testCaricaFileInesistente() throws IOException, ClassNotFoundException {
        
        System.out.println("Carica - File Inesistente");
        String fileFantasma = "file_che_non_esiste_123.dat";
        gestioneLibri.aggiungiLibro(new Libro("Temp", Arrays.asList("A"), 2000, "978-88-00000", 1));
        fileManager.caricaDaFile(fileFantasma);
        assertEquals(1, gestioneLibri.getLibri().size());
        
    }

    /**
     * Test: Gestione parametri non validi (Nome file null/vuoto).
     */
    @Test
    public void testSalvaFileNomeNull() {
        
        System.out.println("Salva - Nome File Null");
        assertThrows(IllegalArgumentException.class, () -> {
            fileManager.salvaSuFile(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            fileManager.salvaSuFile("");
        });
    }
}
