package it.unisa.diem.softeng.gruppo14.gestionebiblioteca;

import java.util.Comparator;

/**
 * @brief Comparatore per l'ordinamento degli oggetti Libro.
 * 
 * Implementa l'interfaccia 'Comparator' per ordinare l'elenco
 * dei libri presenti nell'archivio. 
 * L'ordinamento avviene secondo due criteri:
 * 1. Titolo (ordine alfabetico A-Z, case-insentive)
 * 2. Anno di pubblicazione (dal più recente al meno recente)
 * 
 * @author gruppo14
 */
public class ComparatoreLibri implements Comparator<Libro>{

    /**
     * @brief Confronta due oggetti Libro.
     * 
     * Esegue il confronto sul titolo o, a parità di titolo, 
     * sull'anno di pubblicazione (in ordine decrescente).
     * Tutti i confronti sulle stringhe sono case-insensitive.
     * 
     * @param[in] o1 Il primo libro da confrontare
     * @param[in] o2 Il secondo libro da confrontare
     * 
     * @return Un intero negativo, nullo o positivo se il primo argomento è rispettivamente minore, uguale o maggiore del secondo.
     */
    @Override
    public int compare(Libro o1, Libro o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
