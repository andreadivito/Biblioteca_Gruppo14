package it.unisa.diem.softeng.gruppo14.gestionelogica;

import it.unisa.diem.softeng.gruppo14.gestionedati.Utente;
import java.util.ArrayList;
import java.util.List;

/**
 * @brief Classe che gestisce l'archivio degli utenti.
 * 
 * La classe permette di memorizzare e manipolare la lista degli utenti
 * (aggiunta, rimozione, modifica, ricerca).
 * 
 * @invariant `utenti != null`.
 * 
 * @author gruppo14
 */
public class GestioneUtenti {
    
    /// Lista contenente gli utenti registrati nel sistema.
    private List <Utente> utenti;
    
    
    /**
     * @brief Costruttore.
     * 
     * Inizializza la lista degli utenti.
     * 
     * @post La lista degli utenti è inizializzata.
     */
    public GestioneUtenti(){
        
        this.utenti = new ArrayList<>();
        
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
     * @brief Aggiunge un nuovo utente all'archivio.
     * 
     * Inserisce l'utente nella lista e riordina immediatamente
     * la collezione in base ai criteri definiti in ComparatoreUtenti.
     * 
     * @param[in] u L'utente da aggiungere.
     * 
     * @post La lista utenti contiene l'utente `u` ed è ordinata.
     */
    public void aggiungiUtente(Utente u){
        
        if(u != null){
            
            utenti.add(u);
            
        }
        
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
     * @pre `u1` deve essere presente nella lista utenti.
     * @post I campi di `u1` sono aggiornati e la lista è riordinata.
     */
    public void modificaUtente(Utente u1, Utente u2){
        
        
        
    }
    
    /**
     * @brief Rimuove un utente dall'archivio
     * 
     * @param[in] u L'utente da rimuovere.
     * 
     * @post L'utente `u` non è più presente nella lista utenti.
     */
    public void eliminaUtente(Utente u){
        
        
        
    }
    
    /**
     * @brief Cerca utenti nell'archivio.
     * 
     * Effettua una ricerca case-insensitive su `nome`, 
     * `cognome` e `matricola` degli utenti. Se il parametro testo è vuoto
     * o `null`, restituisce l'intera lista degli utenti. 
     * 
     * @param[in] testo La stringa da cercare.
     * @return Una lista di Utente contenente i risultati della ricerca.
     */
    public List<Utente> cercaUtente(String testo){
        
        return new ArrayList<Utente>();
        
    }
    
}