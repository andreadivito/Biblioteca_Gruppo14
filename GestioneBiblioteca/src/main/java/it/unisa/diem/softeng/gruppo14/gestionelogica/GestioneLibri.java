package it.unisa.diem.softeng.gruppo14.gestionelogica;

import it.unisa.diem.softeng.gruppo14.gestionedati.ComparatoreLibri;
import it.unisa.diem.softeng.gruppo14.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo14.gestionedati.Prestito;
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
        
        if (l != null) {
            
            // Controllo Duplicati per ISBN
            for (Libro esistente : this.libri) {
                if (esistente.getISBN().equals(l.getISBN())) {
                    throw new IllegalArgumentException("Esiste già un libro con questo ISBN: " + l.getISBN());
                }
            }
            
            this.libri.add(l);
            libri.sort(new ComparatoreLibri());
        }
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
        
        if (this.libri.contains(l1) && l2 != null) {
            
            // Aggiorno tutti i campi
            l1.setTitolo(l2.getTitolo());
            l1.setAutori(l2.getAutori());
            l1.setAnnoPubblicazione(l2.getAnnoPubblicazione());
            l1.setISBN(l2.getISBN());
            l1.setNumCopie(l2.getNumCopie());
            
            libri.sort(new ComparatoreLibri());
            
        }
        
    }
    
    /**
     * @brief Rimuove un libro dall'archivio.
     * 
     * @param[in] l Il libro da rimuovere.
     * 
     * @post Il libro `l` non è piu presente nella lista libri.
     */
    public void eliminaLibro(Libro l, List<Prestito> prestiti){
        
        if (l != null) {
            
            // Controllo Integrità: Non eliminare se in prestito
            for (Prestito p : prestiti) {
                // Controllo tramite ISBN per sicurezza
                if (p.getLibro().getISBN().equals(l.getISBN())) {
                    throw new IllegalArgumentException("Impossibile eliminare: il libro risulta in prestito!");
                }
            }
            
            this.libri.remove(l);
            libri.sort(new ComparatoreLibri());
        }
        
    }
    
    /**
     * @brief Cerca i libri nell'archivio.
     * 
     * Effettua una ricerca case-insensitive su titolo, 
     * ISBN e nomi degli autori. Se il parametro testo è vuoto,
     * restituisce l'intera lista dei libri. 
     * 
     * @param[in] testo La stringa da cercare.
     * 
     * @return Una lista di `Libro` contenente i risultati della ricerca.
     */
    public List<Libro> cercaLibro(String testo){
        
       if (testo.trim().isEmpty()) {
            return new ArrayList<>(this.libri);
        }
        
        String testoMinuscolo = testo.toLowerCase();
        List<Libro> risultati = new ArrayList<>();
        
        for (Libro l : this.libri) {
            boolean trovato = false;
            
            // Ricerca su Titolo e ISBN
            if (l.getTitolo().toLowerCase().contains(testoMinuscolo) || 
                l.getISBN().contains(testoMinuscolo)) { 
                trovato = true;
            }
            
            // Ricerca nella lista degli Autori
            if (!trovato) {
                for (String autore : l.getAutori()) {
                    if (autore.toLowerCase().contains(testoMinuscolo)) {
                        trovato = true;
                        break; // Trovato un autore, inutile controllare gli altri autori
                    }
                }
            }
            
            if (trovato) {
                risultati.add(l);
            }
        }
        
        return risultati;
    }
    
    /**
     * @brief Sostituisce l'intera lista dei libri con una nuova lista.
     * 
     * Questo metodo svuota la lista corrente dei libri e inserisce tutti gli elementi
     * presenti nella lista passata come parametro. Viene utilizzato principalmente
     * per ripristinare lo stato dell'applicazione dopo il caricamento da file.
     * 
     * @param[in] nuovaLista La lista di oggetti {@link Libro} da importare nel gestore.
     * 
     * @pre nuovaLista != null (la lista passata non deve essere nulla).
     * @post La lista interna libri contiene esattamente gli stessi elementi di nuovaLista.
     */
    public void impostaLibri(List<Libro> nuovaLista) {
    this.libri.clear();
    this.libri.addAll(nuovaLista);
    }
    
}