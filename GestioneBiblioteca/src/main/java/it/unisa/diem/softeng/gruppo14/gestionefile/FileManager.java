package it.unisa.diem.softeng.gruppo14.gestionefile;

import it.unisa.diem.softeng.gruppo14.gestionebiblioteca.ArchivioBiblioteca;

/**
 * @brief Classe che gestisce l'operazione di scrittura su un file.
 * 
 * Questa classe si occupa di persistere lo stato dell'archivio (libri, utenti e prestiti)
 * su un file di testo (formato csv), permettendo il salvataggio dei dati.
 * 
 * @invariant L'attributo `archivio` non deve essere `null`.
 * 
 * @author gruppo14
 */
public class FileManager {
    
    /**
     * @brief Costruttore.
     * * Inietta la dipendenza dell'archivio all'interno del gestore file.
     * 
     * @param[in] archivio L'archivio contenente i dati da salvare.
     * 
     * @post L'istanza di `FileManager` è pronta per eseguire operazioni di salvataggio.
     */
    public FileManager(ArchivioBiblioteca archivio){
        
    }
    
    /**
     * @brief Salva i dati dell'archivio su un file specificato.
     * 
     * Il metodo scrive sequenzialmente le liste di libri, utenti e prestiti
     * separando i campi con un punto e virgola (;).
     * 
     * @param[in] nomeFile Il percorso o il nome del file su cui scrivere.
     * 
     * @pre `nomeFile` != `null`
     * @post Viene creato (o sovrascritto) un file contenente i dati attuali dell'archivio.
     * 
     * @throws IOException Se si verifica un errore durante l'apertura o la scrittura del file.
     */
    public void salvaSuFile(String nomeFile){
        
        
        
    }
    
}
