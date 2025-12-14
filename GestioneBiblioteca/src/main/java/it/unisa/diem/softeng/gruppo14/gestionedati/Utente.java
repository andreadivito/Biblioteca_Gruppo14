package it.unisa.diem.softeng.gruppo14.gestionedati;

import java.io.Serializable;
import java.util.List;

/**
 * @brief Classe che rappresenta un utente nel database della biblioteca.
 * 
 * La classe permette di memorizzare e gestire le informazioni anagrafiche 
 * e di contatto di una persona registrata nell'archivio.
 * 
 * @invariant Tutti i campi (`nome`, `cognome`, `matricola`, `email`) non devono essere `null`.
 * 
 * @author gruppo14
 */
public class Utente implements Serializable{
    
    /// brief Il nome dell'utente.
    private String nome;
    
    /// @brief Il cognome dell'utente.
    private String cognome;
    
    /// @brief La matricola univoca dell'utente. 
    private String matricola;
    
    /// @brief L'indirizzo email dell'utente. 
    private String email;
    
    /**
     * @brief Costruttore.
     * 
     * Inizializza un nuovo utente con i dati anagrafici specificati.
     * 
     * @param[in] nome Il nome dell'utente.
     * @param[in] cognome Il cognome dell'utente.
     * @param[in] matricola La matricola identificativa.
     * @param[in] email L'indirizzo email di contatto.
     * 
     * @post Viene creato un oggetto `Utente` con i campi inizializzati.
     */
    public Utente(String nome, String cognome, String matricola, String email){
        
        if(nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome non valido");
        this.nome = nome;
        if(cognome == null || cognome.trim().isEmpty()) throw new IllegalArgumentException("Cognome non valido");
        this.cognome = cognome;
        if(matricola == null || matricola.matches("//d{10}")) throw new IllegalArgumentException("Matricola non valida");
        this.matricola = matricola;
        if(email == null || email.trim().isEmpty() || (!email.endsWith("@studenti.unisa.it") && !email.endsWith("@unisa.it")) ) throw new IllegalArgumentException("E-mail non valida");
        this.email = email;
        
    }
    
    /**
     * @brief Restituisce il nome dell'utente.
     * 
     * @return Stringa contenente il nome.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @brief Restituisce il cognome dell'utente.
     * 
     * @return Stringa contenente il cognome.
     */
    public String getCognome() {
        return cognome;
    }
    
    /**
     * @brief Restituisce la matricola dell'utente.
     * 
     * @return Stringa contenente la matricola.
     */
    public String getMatricola() {
        return matricola;
    }
    
    /**
     * @brief Restituisce l'email dell'utente.
     * 
     * @return Stringa contenente l'email.
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * @brief Imposta il nome dell'utente.
     * 
     * @param[in] nome Il nuovo nome da assegnare.
     * 
     * @post Il campo `nome` viene aggiornato.
     */
    public void setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome non valido");
        this.nome = nome;
    }
    
    /**
     * @brief Imposta il cognome dell'utente.
     * 
     * @param[in] cognome Il nuovo cognome da assegnare.
     * 
     * @post Il campo `cognome` viene aggiornato.
     */
    public void setCognome(String cognome) {
        if(cognome == null || cognome.trim().isEmpty()) throw new IllegalArgumentException("Cognome non valido");
        this.cognome = cognome;
    }
    
    /**
     * @brief Imposta la matricola dell'utente.
     * 
     * @param[in] matricola La nuova matricola da assegnare.
     * 
     * @post Il campo `matricola` viene aggiornato.
     */
    public void setMatricola(String matricola) {
        if(matricola == null || matricola.matches("//d{10}")) throw new IllegalArgumentException("Matricola non valida");
        this.matricola = matricola;
    }
    
    /**
     * @brief Imposta l'email dell'utente.
     * 
     * @param[in] email La nuova email da assegnare.
     * 
     * @post Il campo `email` viene aggiornato.
     */
    public void setEmail(String email) {
        if(email == null || email.trim().isEmpty() || (!email.endsWith("@studenti.unisa.it") && !email.endsWith("@unisa.it"))) throw new IllegalArgumentException("E-mail non valida");
        this.email = email;
    }
    
    /**
     * @brief Restituisce una rappresentazione in stringa dell'oggetto Utente.
     * 
     * @return Stringa contenente i dettagli dell'utente.
     */
    @Override
    public String toString() {
        return "Utente{" + "nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + ", email=" + email + '}';
    }
    
}
