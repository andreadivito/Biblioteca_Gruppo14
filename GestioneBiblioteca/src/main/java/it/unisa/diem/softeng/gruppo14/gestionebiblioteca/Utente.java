/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo14.gestionebiblioteca;

import java.util.List;

/**
 *
 * @author andre
 */
public class Utente {
    
    private String nome;
    
    private String cognome;
    
    private String matricola;
    
    private String email;
    
    
    public Utente(String nome, String cognome, String matricola, String email){
        
        
        
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
    @Override
    public String toString() {
        return "Utente{" + "nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + ", email=" + email + '}';
    }
    
}
