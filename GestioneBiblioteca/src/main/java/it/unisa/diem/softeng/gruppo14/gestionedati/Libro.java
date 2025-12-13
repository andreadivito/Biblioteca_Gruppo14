package it.unisa.diem.softeng.gruppo14.gestionedati;

import java.time.LocalDate;
import java.util.List;

/**
 * @brief Classe che rappresenta un libro della biblioteca.
 * 
 * La classe permette di memorizzare e gestire le 
 * informazioni riguardanti un libro presente nella biblioteca.
 * 
 * @invariant
 * I campi `titolo`, `autori` e `ISBN` non devono essere `null`.
 * Il numero di copie disponibili (`numCopie`) deve essere sempre maggiore o uguale a `0`.
 * 
 * @author gruppo14
 */
public class Libro {
    
    /// @brief Titolo del libro.
    private String titolo;
    
    /// @brief Lista che memorizza gli autori del libro.
    private List<String> autori;
    
    /// @brief Anno di pubblicazione del libro.
    private int annoPubblicazione;
    
    /// @brief ISBN del libro
    private String ISBN;
    
    /// @brief Numero di copie del libro.
    private int numCopie;
    
    /**
     * @brief Costruttore
     * 
     * Inizializza un nuovo libro con le informazioni specificate.
     * 
     * @param[in] titolo Titolo del libro.
     * @param[in] autori Lista degli autori.
     * @param[in] annoPubblicazione Anno di pubblicazione del libro.
     * @param[in] ISBN ISBN del libro.
     * @param[in] numCopie Numero di copie del libro.
     * 
     * @post Viene creato un oggetto `Libro` con i campi inizializzati.
     */
    public Libro(String titolo, List<String> autori, int annoPubblicazione, String ISBN, int numCopie){
        
        if(titolo == null || titolo.trim().isEmpty()) throw new IllegalArgumentException("Titolo non valido."); // trim() -> metodo per eliminare spazi (ad inizio e fine stringa)
        this.titolo = titolo;
        if(autori == null || autori.isEmpty()) throw new IllegalArgumentException("Autore non valido.");
        this.autori = autori;
        if(annoPubblicazione > LocalDate.now().getYear()) throw new IllegalArgumentException("Anno di pubblicazione non valido");
        this.annoPubblicazione = annoPubblicazione;
        if(ISBN == null || !ISBN.matches("^978-88-\\d{5}$"))  throw new IllegalArgumentException("ISBN non valido.");
        this.ISBN = ISBN;
        if(numCopie <= 0) throw new IllegalArgumentException("Numero di copie non valido");
        this.numCopie = numCopie;
        
    }
    
    /**
     * @brief Restituisce il titolo del libro.
     * 
     * @return Titolo del libro.
     */
    public String getTitolo(){
        return titolo;
    }

    /**
     * @brief Restituisce la lista degli autori del libro.
     * 
     * @return Gli autori del libro.
     */
    public List<String> getAutori() {
        return autori;
    }

    /**
     * @brief Restituisce la data di pubblicazione del libro.
     * 
     * @return La data di pubblicazione del libro.
     */
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    /**
     * @brief Restituisce il codice identificativo del libro.
     * 
     * @return ISBN del libro.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @brief Restituisce il numero di copie del libro.
     * 
     * @return Numero di copie del libro.
     */
    public int getNumCopie() {
        return numCopie;
    }

    /**
     * @brief Imposta il titolo del libro.
     * 
     * @param[in] titolo Titolo da assegnare al libro.
     * 
     * @post Il titolo del libro viene aggiornato.
     */
    public void setTitolo(String titolo) {
        if(titolo == null || titolo.trim().isEmpty()) throw new IllegalArgumentException("Titolo non valido.");
        this.titolo = titolo;
    }

    /**
     * @brief Imposta la lista degli autori.
     * 
     * @param[in] autori Lista di autori da assegnare al libro.
     * 
     * @post La lista degli autori viene aggiornata.
     */
    public void setAutori(List<String> autori) {
        if(autori == null || autori.isEmpty()) throw new IllegalArgumentException("Autore non valido.");
        this.autori = autori;
    }

    /**
     * @brief Imposta l'anno di pubblicazione del libro.
     * 
     * @param[in] annoPubblicazione Imposta l'anno di pubblicazione del libro.
     * 
     * @post L'anno di pubblicazione viene aggiornato.
     */
    public void setAnnoPubblicazione(int annoPubblicazione) {
        if(annoPubblicazione > LocalDate.now().getYear()) throw new IllegalArgumentException("Anno di pubblicazione non valido");
        this.annoPubblicazione = annoPubblicazione;
    }

    /**
     * @brief Imposta l'ISBN del libro.
     * @param[in] ISBN da assegnare al libro.
     * @post Il codice ISBN viene aggiornato.
     */
    public void setISBN(String ISBN) {
        if(ISBN == null || !ISBN.matches("^978-88-\\d{5}$"))  throw new IllegalArgumentException("ISBN non valido.");
        this.ISBN = ISBN;
    }

    /**
     * @brief Imposta il numero di copie del libro.
     * 
     * @param[in] numCopie Numero di copie da assegnare al libro.
     * 
     * @post Il numero di copie viene aggiornato se il valore è valido.
     */
    public void setNumCopie(int numCopie) {
        if(numCopie <= 0) throw new IllegalArgumentException("Numero di copie non valido");
        this.numCopie = numCopie;
    }
    
    
    /**
     * @brief Decrementa il numero di copie del libro.
     * 
     * Riduce di un'unità il numero di copie disponibili se queste sono maggiori di zero.
     * Da utilizzare quando viene effettuato un prestito.
     * 
     * @post `numCopie` è decrementato di 1.
     */
    public void decrementaCopie(){
        
        if(this.numCopie > 0){
            this.numCopie--;
        }
        
    }
 
    /**
     * @brief Incrementa il numero di copie del libro.
     * 
     * Aumenta di un'unità il numero di copie disponibili.
     * Da utilizzare quando viene restituito un prestito o acquistata una nuova copia.
     * 
     * @post `numCopie` è incrementato di 1.
     */
    public void incrementaCopie(){
        
        this.numCopie++;
        
    }
    
    /**
     * @brief Restituisce una rappresentazione in stringa dell'oggetto Libro.
     * 
     * @return Stringa contenente i dettagli del libro.
     */
    @Override
    public String toString() {
        return "Libro{" + "titolo=" + titolo + ", autori=" + autori + ", annoPubblicazione=" + annoPubblicazione + ", ISBN=" + ISBN + ", numCopie=" + numCopie + '}';
    }
    
    
}
