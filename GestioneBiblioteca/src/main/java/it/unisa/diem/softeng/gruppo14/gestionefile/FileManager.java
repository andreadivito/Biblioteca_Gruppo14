package it.unisa.diem.softeng.gruppo14.gestionefile;

import it.unisa.diem.softeng.gruppo14.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo14.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo14.gestionedati.Utente;
import it.unisa.diem.softeng.gruppo14.gestionelogica.GestioneLibri;
import it.unisa.diem.softeng.gruppo14.gestionelogica.GestionePrestiti;
import it.unisa.diem.softeng.gruppo14.gestionelogica.GestioneUtenti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @brief Classe che gestisce l'operazione di scrittura e lettura su file binario.
 * 
 * Questa classe si occupa di persistere lo stato dell'archivio (libri, utenti e prestiti)
 * serializzando gli oggetti Java direttamente su file.
 * 
 * @author gruppo14
 */
public class FileManager {
    
    /// @brief Riferimento al gestore dei Libri.
    private GestioneLibri gestioneLibri;
    
    /// @brief Riferimento al gestore degli Utenti.
    private GestioneUtenti gestioneUtenti;
    
    /// @brief Riferimento al gestore dei Prestiti
    private GestionePrestiti gestionePrestiti;

    /**
     * @brief Costruttore del FileManager.
     * 
     * @param[in] gestioneLibri Riferimento a GestioneLibri.
     * @param[in] gestioneUtenti Riferimento a GestioneUtenti.
     * @param[in] gestionePrestiti Riferimento a GestionePrestiti.
     */
    public FileManager(GestioneLibri gestioneLibri, GestioneUtenti gestioneUtenti, GestionePrestiti gestionePrestiti) {
        this.gestioneLibri = gestioneLibri;
        this.gestioneUtenti = gestioneUtenti;
        this.gestionePrestiti = gestionePrestiti;
    }
    
    /**
     * @brief Salva i dati dell'archivio su un file specificato (Serializzazione Binaria).
     * 
     * Il metodo raccoglie le liste correnti in una Mappa e serializza l'intera
     * mappa su un file .dat o .bin.
     * 
     * @param[in] nomeFile Il nome del file su cui scrivere.
     * 
     * @pre nomeFile != null
     * @post Viene creato un file binario contenente lo stato degli oggetti.
     * @throws IOException Se si verifica un errore di I/O.
     */
    public void salvaSuFile(String nomeFile) throws IOException {
        
        if (nomeFile == null || nomeFile.isEmpty()) {
            throw new IllegalArgumentException("Il nome del file non può essere nullo o vuoto");
        }

        Map<String, Object> mappaDati = new HashMap<>();
        mappaDati.put("libri", gestioneLibri.getLibri());
        mappaDati.put("utenti", gestioneUtenti.getUtenti());
        mappaDati.put("prestiti", gestionePrestiti.getPrestiti());
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(mappaDati);
        }
    }

    /**
     * @brief Carica i dati da un file binario esistente e ripopola i gestori.
     * 
     * Legge la {@link java.util.Map} serializzata dal file e usa le liste caricate 
     * per sovrascrivere lo stato corrente delle classi di gestione.
     * 
     * @param[in] nomeFile Il percorso del file binario da leggere (es. "archivio.dat").
     * @pre Il file specificato da nomeFile deve esistere e non essere danneggiato.
     * @post I dati interni di {@link GestioneLibri}, {@link GestioneUtenti} e {@link GestionePrestiti} 
     * vengono sovrascritti con quelli letti dal file. Se il file non esiste, lo stato non viene modificato.
     * @throws IOException Se ci sono problemi di I/O (es. permessi di lettura, file corrotto).
     * @throws ClassNotFoundException Se la classe di uno degli oggetti serializzati non viene trovata 
     * o la versione non è compatibile.
     */

    public void caricaDaFile(String nomeFile) throws IOException, ClassNotFoundException {
        
        File file = new File(nomeFile);
        if (!file.exists()) {
            return; 
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            
            Map<String, Object> mappaDati = (Map<String, Object>) ois.readObject();
            
            List<Libro> listaLibri = (List<Libro>) mappaDati.get("libri");
            
            List<Utente> listaUtenti = (List<Utente>) mappaDati.get("utenti");
            
            List<Prestito> listaPrestiti = (List<Prestito>) mappaDati.get("prestiti");
            
            if (listaLibri != null) {
                gestioneLibri.getLibri().clear(); 
                gestioneLibri.getLibri().addAll(listaLibri);
            }

            if (listaUtenti != null) {
                gestioneUtenti.getUtenti().clear();
                gestioneUtenti.getUtenti().addAll(listaUtenti);
            }

            if (listaPrestiti != null) {
                gestionePrestiti.getPrestiti().clear();
                gestionePrestiti.getPrestiti().addAll(listaPrestiti);
            }
        }catch (ClassNotFoundException | IOException ex){
            ex.printStackTrace();
        }
    }
}
