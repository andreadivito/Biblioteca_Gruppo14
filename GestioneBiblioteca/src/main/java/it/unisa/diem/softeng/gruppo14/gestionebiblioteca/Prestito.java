/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo14.gestionebiblioteca;

import java.time.LocalDate;

/**
 *
 * @author andre
 */
public class Prestito {
 
    private Libro libro;
    
    private Utente utente;
    
    private LocalDate dataRestituzione;
    
    public Prestito(Libro libro, Utente utente, LocalDate dataRestituzione){
        
    }

    public Libro getLibro() {
        return libro;
    }

    public Utente getUtente() {
        return utente;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }
    
    public boolean verificaRitardo(){
        
        return false;
        
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }
    
    @Override
    public String toString() {
        return "Prestito{" + "libro=" + libro + ", utente=" + utente + ", dataRestituzione=" + dataRestituzione + '}';
    }
    
    
    
}
