package it.unisa.diem.softeng.gruppo14.gestionefile;

/**
 * @brief Classe che gestisce l'operazione di scrittura su un file.
 * 
 * Questa classe si occupa di persistere lo stato dell'archivio (libri, utenti e prestiti)
 * su un file di testo (formato csv), permettendo il salvataggio dei dati.
 * 
 * 
 * @author gruppo14
 */
public class FileManager {
    
    /**
     * @brief Salva i dati dell'archivio su un file specificato.
     * 
     * Il metodo scrive sequenzialmente le liste di libri, utenti e prestiti
     * separando i campi con un punto e virgola (;).
     * 
     * @param[in] nomeFile Il percorso o il nome del file su cui scrivere.
     * 
     * @pre `nomeFile != null`
     * @post Viene creato (o sovrascritto) un file contenente i dati attuali dell'archivio.
     * 
     * @throws IOException Se si verifica un errore durante l'apertura o la scrittura del file.
     */
    public void salvaSuFile(String nomeFile){
        
        
        
    }
    
}
