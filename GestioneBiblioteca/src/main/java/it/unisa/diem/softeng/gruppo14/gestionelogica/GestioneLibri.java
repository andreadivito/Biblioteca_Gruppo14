package it.unisa.diem.softeng.gruppo14.gestionelogica;

import it.unisa.diem.softeng.gruppo14.gestionedati.Libro;
import java.util.ArrayList;
import java.util.List;

/**
 * @brief Classe che gestisce l'archivio dei libri.
 * 
 * La classe permette di memorizzare e manipolare la lista dei libri
 * (aggiunta, rimozione, modifica, ricerca).
 * 
 * @invariant `libri != null`.
 * 
 * @author gruppo14
 */
public class GestioneLibri {
    
    /// Lista contenente i libri presenti nell'archivio.
    private List <Libro> libri;
    
    /**
     * @brief Costruttore.
     * 
     * Inizializza la lista dei libri.
     * 
     * @post La lista dei libri è inizializzata.
     */
    public GestioneLibri(){
        
        this.libri = new ArrayList<>();
        
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
     * @brief Aggiunge un nuovo libro all'archivio.
     * 
     * Inserisce il libro nella lista e riordina immediatamente
     * la collezione in base ai criteri definiti in ComparatoreLibri.
     * 
     * @param[in] l Il libro da aggiungere. 
     * 
     * @post La lista libri contiene l'elemento `l` ed è ordinata.
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
     * @pre `l1` deve essere presente nella lista dei libri.
     * @post I campi di `l1` sono aggiornati e la lista è riordinata.
     */
    public void modificaLibro(Libro l1, Libro l2){
        
        
        
    }
    
    /**
     * @brief Rimuove un libro dall'archivio.
     * 
     * @param[in] l Il libro da rimuovere.
     * 
     * @post Il libro `l` non è piu presente nella lista libri.
     */
    public void eliminaLibro(Libro l){
        
        
        
    }
    
    /**
     * @brief Cerca i libri nell'archivio.
     * 
     * Effettua una ricerca case-insensitive su titolo, 
     * ISBN e nomi degli autori. Se il parametro testo è vuoto
     * o null, restituisce l'intera lista dei libri. 
     * 
     * @param[in] testo La stringa da cercare.
     * 
     * @return Una lista di `Libro` contenente i risultati della ricerca.
     */
    public List<Libro> cercaLibro(String testo){
        
        return new ArrayList<Libro>();
        
    }
    
}