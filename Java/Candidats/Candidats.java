package Objectes.Candidats;

import java.util.Scanner;

public class Candidats {
    Scanner scan = new Scanner(System.in);
    int candidat_id;
    int candidatura_id;
    int persona_id;
    int provincia_id;
    int num_ordre;
    String tipus;
    //Constructor

    public Candidats(int candidat_id, int candidatura_id, int persona_id, int provincia_id, int num_ordre, String tipus){
        this.candidat_id = comprovarNumerosPositius(candidat_id);
        this.candidatura_id = comprovarNumerosPositius(candidatura_id);
        this.persona_id = comprovarNumerosPositius(persona_id);
        this. provincia_id = comprovarNumerosPositius(provincia_id);
        this.num_ordre = comprovarNumerosPositius(num_ordre);
        this.tipus = comprovarTipus(tipus);
    }
    //Comprovacions
    private int comprovarNumerosPositius(int num){
        boolean flag = false;

        while(!flag){
            if (num > 0) flag = true;
            else {
                System.out.println("El numero es negatiu o no es un numero positiu, torna a posar-ho:");
                num = scan.nextInt();
            }
        }
        return num;
    }
    private String comprovarTipus(String tipus){
        boolean flag = false;

        while (!flag){
            if (tipus.equals("T") || tipus.equals("S")) flag = true;
            else {
                System.out.println("El tipus elegit no es ni la T ni la S");
                tipus = scan.nextLine();
            }
        }
        return tipus;
    }

    //Getters
    public int getCandidat_id() {
        return candidat_id;
    }
    public int getCandidatura_id() {
        return candidatura_id;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public int getProvincia_id() {
        return provincia_id;
    }

    public int getNum_ordre() {
        return num_ordre;
    }

    public String getTipus() {
        return tipus;
    }

    //Setters
    public void setCandidat_id(int candidatura_id) {
        this.candidat_id = candidatura_id;
    }
    public void setCandidatura_id(int candidatura_id) {
        this.candidatura_id = candidatura_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }

    public void setNum_ordre(int num_ordre) {
        this.num_ordre = num_ordre;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
}
