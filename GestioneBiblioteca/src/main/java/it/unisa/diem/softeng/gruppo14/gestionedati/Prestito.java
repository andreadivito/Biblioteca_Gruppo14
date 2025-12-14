        package it.unisa.diem.softeng.gruppo14.gestionedati;

import java.io.Serializable;
        import java.time.LocalDate;

        /**
         * @brief Classe che rappresenta un **prestito** nella gestione della biblioteca.
         *
         * La classe gestisce l'associazione tra un oggetto `Libro` e un oggetto `Utente`, definendo
         * una data di scadenza per la restituzione. Fornisce inoltre funzionalità
         * per verificare se il prestito è in ritardo rispetto alla data odierna.
         * 
         * @invariant I campi `libro`, `utente` e `dataRestituzione` non devono essere `null`.
         * 
         * @author gruppo14
         */
        public class Prestito implements Serializable {

            /// @brief Il libro oggetto del prestito.
            private Libro libro;

            /// @brief L'utente che ha richiesto il prestito.
            private Utente utente;

            /// @brief La data entro cui il libro deve essere restituito. 
            private LocalDate dataRestituzione;

            /**
             * @brief Costruttore.
             * 
             * Inizializza un nuovo prestito associando un libro ad un utente, 
             * il prestito avrà una data di scadenza.
             * Verifica che nessuno dei parametri sia null.
             * Utilizza `assert` per verificare che la data di restituzione inserita sia valida.
             * 
             * @param[in] libro Il libro da prestare.
             * @param[in] utente L'utente che prende in prestito il libro.
             * @param[in] dataRestituzione La data limite per la restituzione.
             * 
             * @post Viene creato un oggetto `Prestito` valido.
             */
            public Prestito(Libro libro, Utente utente, LocalDate dataRestituzione){

                if(libro == null) throw new IllegalArgumentException("Libro non valido");
                this.libro = libro;
                if(utente == null) throw new IllegalArgumentException("Utente non valido");
                this.utente = utente;
                if(dataRestituzione == null) throw new IllegalArgumentException("Data di restituzione non valida");
                this.dataRestituzione = dataRestituzione;
                
            }

            /**
             * @brief Restituisce il libro prestato.
             * 
             * @return L'oggetto `Libro` associato al prestito.
             */
            public Libro getLibro() {
                return libro;
            }

            /**
             * @brief Restituisce l'utente beneficiario del prestito.
             * 
             * @return L'oggetto `Utente` associato al prestito.
             */
            public Utente getUtente() {
                return utente;
            }

            /**
             * @brief Restituisce la data di scadenza del prestito.
             * 
             * @return La data prevista per la restituzione.
             */
            public LocalDate getDataRestituzione() {
                return dataRestituzione;
            }


            /**
             * @brief Imposta un nuovo libro per il prestito.
             * 
             * @param[in] libro Il nuovo libro da associare.
             * 
             * @post Il libro associato viene aggiornato.
             */
            public void setLibro(Libro libro) {
                if(libro == null) throw new IllegalArgumentException("Libro non valido");
                this.libro = libro;
            }

            /**
             * @brief Imposta un nuovo utente per il prestito.
             * 
             * @param[in] utente Il nuovo utente da associare.
             * 
             * @post L'utente associato viene aggiornato.
             */
            public void setUtente(Utente utente) {
                if(utente == null) throw new IllegalArgumentException("Utente non valido");
                this.utente = utente;
            }

            /**
             * @brief Imposta una nuova data di restituzione.
             * 
             * @param[in] dataRestituzione La nuova data di scadenza.
             * 
             * @post La data di restituzione viene aggiornata.
             */
            public void setDataRestituzione(LocalDate dataRestituzione) {
                if(dataRestituzione == null) throw new IllegalArgumentException("Data di restituzione non valida");
                this.dataRestituzione = dataRestituzione;
            }

            /**
             * @brief Verifica se il prestito è in ritardo.
             * 
             * Confronta la data di restituzione prevista con la data corrente (`LocalDate.now()`).
             * 
             * @return true se la data corrente è successiva alla data di restituzione, false altrimenti.
             */
            public boolean verificaRitardo(){

                return LocalDate.now().isAfter(dataRestituzione);

            }

            /**
             * @brief Restituisce una rappresentazione in stringa del prestito.
             * 
             * @return Stringa contenente i dettagli del prestito (Libro, Utente, Data).
             */
            @Override
            public String toString() {
                return "Prestito{" + "libro=" + libro + ", utente=" + utente + ", dataRestituzione=" + dataRestituzione + '}';
            }

        }