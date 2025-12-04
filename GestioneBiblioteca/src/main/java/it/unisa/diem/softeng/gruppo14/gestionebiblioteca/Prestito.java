package it.unisa.diem.softeng.gruppo14.gestionebiblioteca;

import java.time.LocalDate;

/**
 * @brief Classe che rappresenta un prestito all'interno del sistema bibliotecario.
 *
 * La classe gestisce l'associazione tra un Libro e un Utente, definendo
 * una data di scadenza per la restituzione. Fornisce inoltre funzionalità
 * per verificare se il prestito è in ritardo rispetto alla data odierna.
 * 
 * @author gruppo14
 */
public class Prestito {
    
    /** @brief Il libro oggetto del prestito. */
    private Libro libro;
    
    /** @brief L'utente che ha richiesto il prestito. */
    private Utente utente;
    
    /** @brief La data entro cui il libro deve essere restituito. */
    private LocalDate dataRestituzione;
    
    /**
     * @brief Costruttore della classe Prestito.
     * 
     * Inizializza un nuovo prestito associando un libro a un utente, 
     * il prestito avrà una data di scadenza.
     * Verifica che nessuno dei parametri sia null.
     * 
     * @param[in] libro Il libro da prestare.
     * @param[in] utente L'utente che prende in prestito il libro.
     * @param[in] dataRestituzione La data limite per la restituzione.
     * 
     * @pre libro != null && utente != null && dataRestituzione != null.
     * @post Viene creato un oggetto Prestito valido.
     */
    public Prestito(Libro libro, Utente utente, LocalDate dataRestituzione){
        
    }
    
    /**
     * @brief Restituisce il libro prestato.
     * 
     * @return L'oggetto Libro associato al prestito.
     */
    public Libro getLibro() {
        return libro;
    }
    
    /**
     * @brief Restituisce l'utente beneficiario del prestito.
     * 
     * @return L'oggetto Utente associato al prestito.
     */
    public Utente getUtente() {
        return utente;
    }
    
    /**
     * @brief Restituisce la data di scadenza del prestito.
     * 
     * @return La data prevista per la restituzione.
     */
    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }
    
    /**
     * @brief Verifica se il prestito è in ritardo.
     * 
     * Confronta la data di restituzione prevista con la data corrente (LocalDate.now()).
     * 
     * @return true se la data corrente è successiva alla data di restituzione, false altrimenti.
     */
    public boolean verificaRitardo(){
        
        return false;
        
    }
    
    /**
     * @brief Imposta un nuovo libro per il prestito.
     * 
     * @param[in] libro Il nuovo libro da associare.
     * 
     * @pre libro != null.
     * @post Il libro associato viene aggiornato.
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    /**
     * @brief Imposta un nuovo utente per il prestito.
     * 
     * @param[in] utente Il nuovo utente da associare.
     * 
     * @pre utente != null.
     * @post L'utente associato viene aggiornato.
     */
    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    
    /**
     * @brief Imposta una nuova data di restituzione.
     * 
     * @param[in] dataRestituzione La nuova data di scadenza.
     * 
     * @pre dataRestituzione != null.
     * @post La data di restituzione viene aggiornata.
     */
    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }
    
    /**
     * @brief Restituisce una rappresentazione in stringa del prestito.
     * 
     * @return Stringa contenente i dettagli del prestito (Libro, Utente, Data).
     */
    @Override
    public String toString() {
        return "Prestito{" + "libro=" + libro + ", utente=" + utente + ", dataRestituzione=" + dataRestituzione + '}';
    }
        
}