package it.unisa.diem.softeng.gruppo14.gestionebiblioteca;

import java.util.Comparator;

/**
 * @brief Comparatore per l'ordinamento degli oggetti `Utente`.
 * 
 * Implementa l'interfaccia `Comparator` per ordinare l'elenco
 * degli utenti registrati. 
 * L'ordinamento è alfabetico e gerarchico secondo i seguenti criteri:
 * * Cognome
 * * Nome (se i cognomi sono uguali)
 * * Matricola (se anche i nomi sono uguali, per garantire univocità).
 * 
 * @author gruppo14
 */
public class ComparatoreUtenti implements Comparator<Utente>{

    /**
     * @brief Confronta due oggetti `Utente`.
     * 
     * Verifica in sequenza cognome, nome ed infine matricola.
     * Tutti i confronti sulle stringhe sono case-insensitive.
     * 
     * @param[in] o1 Il primo utente da confrontare
     * @param[in] o2 Il secondo utente da confrontare
     * 
     * @return Un intero negativo, nullo o positivo se il primo argomento è rispettivamente minore, uguale o maggiore del secondo.
     */
    @Override
    public int compare(Utente o1, Utente o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
