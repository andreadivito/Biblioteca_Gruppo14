package it.unisa.diem.softeng.gruppo14.gestionelogica;

import it.unisa.diem.softeng.gruppo14.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo14.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo14.gestionedati.Utente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @brief Classe che gestisce l'archivio dei prestiti.
 * 
 * La classe permette di memorizzare e manipolare la lista dei prestiti
 * (aggiunta, rimozione).
 * 
 * @invariant `prestiti != null`.
 * 
 * @author gruppo14
 */
public class GestionePrestiti {
    
    /// Lista contenente i prestiti attualmente attivi.
    private List<Prestito> prestiti;
    
    /**
     * @brief Costruttore.
     * 
     * Inizializza la lista dei prestiti.
     * 
     * @post La lista dei prestiti è inizializzata.
     */
    public GestionePrestiti(){
        
        this.prestiti = new ArrayList<>();
        
    }
    
    /**
     * @brief Restituisce la lista dei prestiti attivi.
     * 
     * @return Lista di oggetti `Prestito`.
     */
    public List<Prestito> getPrestiti() {
        return prestiti;
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
     * `l != null && u != null && l.getNumCopie() > 0`.
     * L'utente deve avere meno di 3 prestiti attivi.
     * 
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
     * @post 
     * Il numero di copie del libro associato è incrementato di uno.
     * Il prestito non è più presente nella lista dei prestiti attivi.
     */
    public void registraRestituzione(Prestito p){
        
        
        
    }
    
}
