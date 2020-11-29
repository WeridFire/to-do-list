package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int n_task_corrente = 0;
    int n_task_max = 100;

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    Attivita[] lista_task = new Attivita[n_task_max];

    public static void main(String[] args) throws IOException {

        Main programma = new Main();
        programma.start();
    }

    public void start() throws IOException {

        boolean ciclo = false;
        boolean esci;
        boolean chiudi = false;
        String buff = null;

        while (!chiudi) {

            while (!ciclo) {

                System.out.println("\nCosa vuoi fare?\n");
                buff = scelgli_attivita().toLowerCase();

                if ( buff.equals("aggiungi task") ||  buff.equals("modifica task") || buff.equals("rimuovi task") || buff.equals("esci") || buff.equals("mostra task")) {
                    ciclo = true;
                }
            }


            esci = false;

            while (!esci) {

                n_task_corrente++;
                switch (buff) {
                    case ("aggiungi task") -> {
                        aggiungi_task(n_task_corrente);
                        esci=true;
                    }
                    case ("modifica task") -> {
                        modifica_task();
                        n_task_corrente--;
                        esci=true;
                    }
                    case ("rimuovi task") -> {
                        rimuovi_task();
                        esci=true;
                    }
                    case ("mostra task") -> {
                        mostra_task();
                        n_task_corrente--;
                        esci=true;
                    }
                    case ("esci") -> chiudi = true;
                    default -> throw new IllegalStateException("Unexpected value: " + buff);
                }
            }
            ciclo = false;
        }
    }

    public String scelgli_attivita() throws IOException {
        System.out.println(">>Aggiungi task\n>>Modifica task\n>>Rimuovi task\n>>Mostra task\n>>Esci");
        return input.readLine();
    }

    public void aggiungi_task(int n_task_corrente) throws IOException {

        lista_task[n_task_corrente] = new Attivita();

        System.out.println("Titolo >> ");
        lista_task[n_task_corrente].setTitolo(input.readLine());
        System.out.println("Descrizione >> ");
        lista_task[n_task_corrente].setDescrizione(input.readLine());
        System.out.println("Ora Inizio >> ");
        lista_task[n_task_corrente].setInizio(input.readLine());
        System.out.println("Ora Fine >> ");
        lista_task[n_task_corrente].setFine(input.readLine());

        lista_task[n_task_corrente].setNtask(n_task_corrente);

    }

    public void modifica_task() throws IOException {

        int ntask = trova_task();

        if (ntask != -1) {
            System.out.println("Nuovo Titolo >> ");
            lista_task[ntask].setTitolo(input.readLine());
            System.out.println("Nuova Descrizione >> ");
            lista_task[ntask].setDescrizione(input.readLine());
            System.out.println("Nuova Ora Inizio >> ");
            lista_task[ntask].setInizio(input.readLine());
            System.out.println("Nuova Ora Fine >> ");
            lista_task[ntask].setFine(input.readLine());
        }
    }

    public void rimuovi_task() throws IOException {

        int ntask = trova_task();
        lista_task[ntask] = null;

    }

    public void mostra_task(){

        int cont = 1;

        for (Attivita task:
             lista_task) {
            if(task!= null){
                System.out.println("Attivita n."+cont+" del giorno");
                cont++;
                System.out.println("Titolo assegnato : \n   "+task.getTitolo());
                System.out.println("Descrizione assegnata : \n   "+task.getDescrizione());
                System.out.println("Orario di Inizio assegnato : \n   "+task.getInizio());
                System.out.println("Ora di Fine assegnata : \n   "+task.getFine()+"\n");
            }
        }

    }

    public int trova_task() throws IOException {

        boolean trovato = false;
        int ntask=0;

        System.out.println(" Inserisci il titolo del task");
        String buff = input.readLine();

        for (Attivita task:
                lista_task) {
            if(task != null) {
                if (buff.equals(task.getTitolo())) {
                    ntask = task.getNtask();
                    trovato = true;
                }
            }
        }

       if(trovato) {
           return ntask;
       }else{
           return -1;
       }
    }

}
