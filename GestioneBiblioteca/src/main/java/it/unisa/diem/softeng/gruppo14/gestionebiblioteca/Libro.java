/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo14.gestionebiblioteca;

import java.util.List;

/**
 * @brief Classe che rappresenta un libro nella Biblioteca
 * 
 * La classe 'Libro' permette di memorizzare e gestire le 
 * informazioni riguardanti un libro presente nella biblioteca
 * 
 * @invariant I campi che identificano il libro devono essere
 * non null
 * 
 */

public class Libro {
    
    /** @brief Titolo del libro. */
    private String titolo;
    
    /** @brief Lista che memorizza gli autori del libro. */
    private List<String> autori;
    
    /** @brief Anno di pubblicazione del libro. */
    private int annoPubblicazione;
    
    /** @brief ISBN del libro */
    private String ISBN;
    
    /** @brief Numero di copie del libro. */
    private int numCopie;
    
    /**
     * @brief Costruttore
     * @param[in] titolo Titolo del libro
     * @param[in] annoPubblicazione Anno di pubblicazione del libro
     * @param[in] ISBN ISBN del libro
     * @param[in] numCopie Numero di copie del libro
     */
    public Libro(String titolo, int annoPubblicazione, String ISBN, int numCopie){
        
        
        
    }
    
    /**
     * @brief Restituisce il titolo del libro
     * @return Titolo del libro
     */
    public String getTitolo(){
        return titolo;
    }

    /**
     * @brief Restituisce la lista degli autori del libro
     * @return Gli autori del libro
     */
    public List<String> getAutori() {
        return autori;
    }

    /**
     * @brief Restituisce la data di pubblicazione del libro
     * @return La data di pubblicazione del libro
     */
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    /**
     * @brief Restituisce il codice identificativo del libro
     * @return ISBN del libro
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @brief Restituisce il numero di copie del libro
     * @return Numero di copie del libro
     */
    public int getNumCopie() {
        return numCopie;
    }

    /**
     * @brief Imposta il titolo del libro
     * @param[in] titolo Titolo da assegnare al libro 
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * @brief Imposta la lista degli autori
     * @param[in] autori Lista di autori da assegnare al libro
     */
    public void setAutori(List<String> autori) {
        this.autori = autori;
    }

    /**
     * @brief Imposta l'anno di pubblicazione del libro
     * @param[in] annoPubblicazione Imposta l'anno di pubblicazione del libro 
     */
    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    /**
     * @brief Imposta l'ISBN del libro
     * @param[in] ISBN da assegnare al libro 
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @brief Imposta il numero di copie del libro
     * @param[in] numCopie Numero di copia da assegnare al libro
     */
    public void setNumCopie(int numCopie) {
        this.numCopie = numCopie;
    }
    
    
    /**
     * @brief Incrementa il numero di copie del libro
     * 
     * 
     */
    public void decrementaCopie(){
        
        
        
    }
 
    
    public void incrementaCopie(){
        
        
    }

    @Override
    public String toString() {
        return "Libro{" + "titolo=" + titolo + ", autori=" + autori + ", annoPubblicazione=" + annoPubblicazione + ", ISBN=" + ISBN + ", numCopie=" + numCopie + '}';
    }
    
    
}
