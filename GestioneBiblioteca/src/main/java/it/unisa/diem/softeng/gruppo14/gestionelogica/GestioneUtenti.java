package it.unisa.diem.softeng.gruppo14.gestionelogica;

import it.unisa.diem.softeng.gruppo14.gestionedati.ComparatoreUtenti;
import it.unisa.diem.softeng.gruppo14.gestionedati.Prestito;
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
            
            for(Utente esistente : this.utenti){
                if(esistente.getMatricola().equals(u.getMatricola())){
                    throw new IllegalArgumentException("Matricola già presente nel sistema");
                }
            }
            utenti.add(u);
            utenti.sort(new ComparatoreUtenti());
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
        
        if(this.utenti.contains(u1) && u2 != null){
            
            u1.setCognome(u2.getCognome());
            u1.setNome(u2.getNome());
            u1.setMatricola(u2.getMatricola());
            u1.setEmail(u2.getEmail());
            
            utenti.sort(new ComparatoreUtenti());
        }
        
    }
    
    /**
     * @brief Rimuove un utente dall'archivio
     * 
     * @param[in] u L'utente da rimuovere.
     * param[in] prestiti Lista dei prestiti attiivi.
     * 
     * @post L'utente `u` non è più presente nella lista utenti.
     */
    public void eliminaUtente(Utente u, List<Prestito> prestiti){
        
        if(u != null){
            for(Prestito p : prestiti){
                
                if(p.getUtente().getMatricola().equals(u.getMatricola())){
                    
                    throw new IllegalArgumentException("Impossibile eliminare: l'Utente ha ancora dei prestiti in corso!");
                    
                }
                    
            }
            
            this.utenti.remove(u);
            utenti.sort(new ComparatoreUtenti());
        }
        
    }
    
    /**
     * @brief Cerca utenti nell'archivio.
     * 
     * Effettua una ricerca case-insensitive su `nome`, 
     * `cognome` e `matricola` degli utenti. Se il parametro testo è vuoto,
     * restituisce l'intera lista degli utenti. 
     * 
     * @param[in] testo La stringa da cercare.
     * @return Una lista di Utente contenente i risultati della ricerca.
     */
    public List<Utente> cercaUtente(String testo){
        
        if(testo.trim().isEmpty()){
            
            return this.utenti;
            
        }
        
        String testoMinuscolo = testo.toLowerCase();
        List<Utente> risultati = new ArrayList<>();
        
        for(Utente u : utenti){
            
            if (u.getNome().toLowerCase().contains(testoMinuscolo) ||
                u.getCognome().toLowerCase().contains(testoMinuscolo) ||
                u.getMatricola().toLowerCase().contains(testoMinuscolo) ||
                u.getEmail().toLowerCase().contains(testoMinuscolo)) {
                
                risultati.add(u);
            }
        }
        
        return risultati;
        
    }
    
    /**
     * @brief Sostituisce l'intera lista degli utenti con una nuova lista.
     * 
     * Questo metodo permette di sovrascrivere lo stato corrente del gestore utenti
     * con i dati forniti. Garantisce l'incapsulamento evitando che classi esterne
     * (come il FileManager) debbano manipolare direttamente la lista interna.
     * 
     * @param[in] nuovaLista La lista di oggetti {@link Utente} da impostare.
     * @pre nuovaLista != null.
     * 
     * @post La lista interna utenti è aggiornata con i dati forniti.
     */
    public void impostaUtenti(List<Utente> nuovaLista) {
    this.utenti.clear();
    this.utenti.addAll(nuovaLista);
    }
    
}