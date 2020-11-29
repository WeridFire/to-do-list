package com.company;

public class Attivita {

    String titolo;
    String descrizione;
    String inizio;
    String fine;
    int ntask;

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setInizio(String inizio) {
        this.inizio = inizio;
    }

    public String getInizio() {
        return inizio;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setNtask(int ntask){this.ntask = ntask;}

    public int getNtask(){return ntask;}


}
