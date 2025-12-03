package it.unisa.diem.softeng.gruppo14.gestionebiblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @brief Classe che gestisce l'archivio della biblioteca.
 * 
 * La classe permette di memorizzare la lista dei libri
 * e la lista degli utenti registrati, fornendo i metodi 
 * per manipolare questi dati (aggiunta, rimozione, modifica, ricerca)
 * e per gestire le operazioni di prestito e restituzione.
 * 
 * @author gruppo14
 */
public class ArchivioBiblioteca {
    
    /// Lista contenente i libri presenti nell'archivio.
    private List <Libro> libri;
    
    /// Lista contenente gli utenti registrati nel sistema.
    private List <Utente> utenti;
    
    /**
     * @brief Costruttore.
     * 
     * Inizializza l'archivio creando liste vuote per libri e utenti.
     * 
     * @post Le liste di libri e utenti sono inizializzate e vuote.
     */
    public ArchivioBiblioteca(){
        
        this.libri = new ArrayList<>();
        this.utenti = new ArrayList<>();
        
    }

    /**
     * @brief Restituisce la lista completa dei libri.
     * 
     * @return Lista di oggetti Libro presenti nell'archivio.
     */
    public List<Libro> getLibri() {
        return libri;
    }

    /**
     * @brief Restituisce la lista completa degli utenti.
     * 
     * @return Lista di oggetti Utente registrati.
     */
    public List<Utente> getUtenti() {
        return utenti;
    }
    
    /**
     * @brief Aggiunge un nuovo libro all'archivio.
     * 
     * Inserisce il libro nella lista e riordina immediatamente
     * la collezione in base ai criteri definiti in ComparatoreLibri.
     * 
     * @param[in] l Il libro da aggiungere. 
     * 
     * @pre l != null.
     * @post La lista libri contiene l'elemento l ed è ordinata.
     */
    public void aggiungiLibro(Libro l){
        
        
        
    }
    
    /**
     * @brief Modifica i dati di un libro esistente.
     * 
     * Copia i dati dell'oggetto contenente le nuove informazioni
     * all'oggetto originale presente in lista, mantenendo l'identità
     * dell'oggetto originale. Al termine, la lista viene riordinata.
     * 
     * @param[in] l1 Il riferimento al libro originale da modificare.
     * @param[in] l2 Un oggetto Libro contenente i dati aggiornati.
     * 
     * @pre l1 deve essere presente nella lista dei libri.
     * @post I campi di l1 sono aggiornati e la lista è riordinata.
     */
    public void modificaLibro(Libro l1, Libro l2){
        
        
        
    }
    
    /**
     * @brief Rimuove un libro dall'archivio.
     * 
     * @param[in] l Il libro da rimuovere.
     * @post Il libro l non è piu presente nella lista libri.
     */
    public void eliminaLibro(Libro l){
        
        
        
    }
    
    /**
     * @brief Aggiunge un nuovo utente all'archivio.
     * 
     * Inserisce l'utente nella lista e riordina immediatamente
     * la collezione in base ai criteri definiti in ComparatoreUtenti.
     * 
     * @param[in] u L'utente da aggiungere.
     * 
     * @pre u != null.
     * @post La lista utenti contiene l'utente u ed è ordinata.
     */
    public void aggiungiUtente(Utente u){
        
        
        
    }
    
    /**
     * @brief Modifica i dati di un utente esistente.
     * 
     * Copia i dati dall'oggetto contente le nuove informazioni
     * all'oggetto originale presente in lista. Al termine,
     * la lista viene riordinata.
     * 
     * @param[in] u1 Il riferimento all'utente originale da modificare.
     * @param[in] u2 Un oggetto Utente contenente i dati aggiornati.
     * 
     * @pre u1 deve essere presente nella lista utenti.
     * @post I campi di u1 sono aggiornati e la lista è riordinata.
     */
    public void modificaUtente(Utente u1, Utente u2){
        
        
        
    }
    
    /**
     * @brief Rimuove un utente dall'archivio
     * 
     * @param[in] u L'utente da rimuovere.
     * 
     * @post L'utente u non è più presente nella lista utenti.
     */
    public void eliminaUtente(Utente u){
        
        
        
    }
    
    /**
     * @brief Registra un nuovo prestito nel sistema.
     * 
     * Verifica la disponibilità del libro, decrementa le copie
     * disponibili e crea una nuova istanza di Prestito associandola
     * all'utente.
     * 
     * @param[in] l Il libro oggetto del prestito.
     * @param[in] u L'utente che richiede il prestito.
     * @param[in] dataRestituzione La data prevista per la restituzione.
     * 
     * @pre 
     * l != null && u != null && l.getNumCopie() > 0.
     * L'utente deve avere meno di 3 prestiti attivi.
     * @post 
     * Il numero di copie del libro è decrementato di uno. 
     * Il nuovo prestito è presente nella lista dei prestiti attivi.
     */
    public void registraPrestito(Libro l, Utente u, LocalDate dataRestituzione){
        
        
        
    }
    
    /**
     * @brief Gestisce la restituzione di un prestito.
     * 
     * Recupera un libro dal prestito e ne incrementa
     * le copie disponibili.
     * 
     * @param[in] p Il prestito da chiudere.
     * 
     * @pre p != null.
     * @post 
     * Il numero di copie del libro associato è incrementato di uno.
     * Il prestito non è più presente nella lista dei prestiti attivi.
     */
    public void registraRestituzione(Prestito p){
        
        
        
    }
    
    /**
     * @brief Cerca i libri nell'archivio.
     * 
     * Effettua una ricerca case-insensitive su titolo, 
     * ISBN e nomi degli autori. Se il parametro testo è vuoto
     * o null, restituisce l'intera lista dei libri. 
     * 
     * @param[in] testo La stringa da cercare.
     * @return Una lista di Libro contenente i risultati della ricerca.
     */
    public List<Libro> cercaLibro(String testo){
        
        return null;
        
    }
    
    /**
     * @brief Cerca utenti nell'archivio.
     * 
     * Effettua una ricerca case-insensitive su nome, 
     * cognome e matricola degli utenti. Se il parametro testo è vuoto
     * o null, restituisce l'intera lista degli utenti. 
     * 
     * @param[in] testo La stringa da cercare.
     * @return Una lista di Utente contenente i risultati della ricerca.
     */
    public List<Utente> cercaUtente(String testo){
        
        return null;
        
    }
    
}
