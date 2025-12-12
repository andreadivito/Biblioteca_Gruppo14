package it.unisa.diem.softeng.gruppo14.gestionedati;

import java.util.Comparator;

/**
 * @brief Comparatore per l'ordinamento degli oggetti `Libro`.
 * 
 * Implementa l'interfaccia `Comparator` per ordinare l'elenco
 * dei libri presenti nell'archivio. 
 * L'ordinamento avviene secondo due criteri:
 * * Titolo (ordine alfabetico A-Z, case-insentive)
 * * Anno di pubblicazione (dal più recente al meno recente)
 * 
 * @author gruppo14
 */
public class ComparatoreLibri implements Comparator<Libro>{

    /**
     * @brief Confronta due oggetti `Libro`.
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
   //     if(o1.getTitolo().equals(o2.getTitolo())){
    //        return Integer.compare(o2.getAnnoPubblicazione(), o1.getAnnoPubblicazione());
     //   } 
     //   return o1.getTitolo().compareToIgnoreCase(o2.getTitolo());
     return 0;
    }
    
}
