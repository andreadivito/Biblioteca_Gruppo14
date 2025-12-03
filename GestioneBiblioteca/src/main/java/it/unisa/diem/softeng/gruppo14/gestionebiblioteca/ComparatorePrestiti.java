package it.unisa.diem.softeng.gruppo14.gestionebiblioteca;

import java.util.Comparator;

/**
 * @brief Comparatore per l'ordinamento degli oggetti Prestito.
 * 
 * Implementa l'interfaccia 'Comparator' per ordinare la
 * visualizzazione dei prestiti.
 * Utile per visualizzare per prime le scadenze più imminenti
 * L'ordinamento avviene secondo un criterio:
 * 1. Data di restituzione (dalla più vicina alla più lontana).
 * 
 * @author gruppo14
 */
public class ComparatorePrestiti implements Comparator<Prestito>{

    /**
     * @brief Confronta due oggetti Prestito.
     * 
     * Verifica la data di Restituzione dei due prestiti.
     * 
     * @param[in] o1 Il primo prestito da confrontare
     * @param[in] o2 Il secondo prestito da confrontare
     * 
     * @return Un intero negativo, nullo o positivo se il primo argomento è rispettivamente minore, uguale o maggiore del secondo.
     */
    @Override
    public int compare(Prestito o1, Prestito o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
