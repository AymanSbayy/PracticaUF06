package Objectes.Persones;

import java.util.Scanner;

public class persona {
    Scanner scan = new Scanner(System.in);
    int persona_id;
    String nom;
    String cog1;
    String cog2;
    String sexe;
    String data_naixement;
    String dni;

    public persona(int persona_id, String nom, String cog1, String cog2, String sexe, String data_naixement, String dni) {
        this.persona_id = IsInt(persona_id);
        this.nom = StringLength30(nom);
        this.cog1 = StringLength30(cog1);
        this.cog2 = StringLength30(cog2);
        this.sexe = comprovacioSexe(sexe);
        this.data_naixement = data_naixement;
        this.dni = IsChar(dni);
    }

    public persona(){

    }
    @Override
    public String toString(){
        return "\n"+"persona_id: "+persona_id+ "  | nom: "+nom+"  | cognom1: "+cog1+"  | cognom2: "+cog2+"  | sexe: "+sexe+"  | data_naixement: "+data_naixement +
                "  | dni: "+dni+"\n";
    }
    private int IsInt(int num){
        boolean flag = false;
        while(!flag){
            if (num > 0) flag = true;
            else {
                System.out.println("El numero no es un numero positiu, torna a posar-ho:");
                num = scan.nextInt();
            }
        }
        return num;
    }
    private String IsChar(String s){
        boolean flag = false;
        while (!flag){
            if (s.length() < 11) flag = true;
            else {
                System.out.println("El String introduït es passa més de 10 caracters");
                s = scan.nextLine();
            }
        }
        return s;
    }
    private String StringLength30(String s){
        boolean flag = false;
        while (!flag){
            if (s.length() < 30) flag = true;
            else {
                System.out.println("El String introduït es passa més de 30 caracters");
                s = scan.nextLine();
            }
        }
        return s;
    }
    private String comprovacioSexe(String s){
        boolean flag = false;
        while (!flag) {
            if (s.equals("M") || s.equals("F")) flag = true;
            else {
                System.out.println("El caracter introduït no es ni 'M' ni 'F'");
                s = scan.nextLine();
            }
        }
        return s;
    }

    //GETTERS

    public int getPersona_id() {
        return persona_id;
    }

    public String getNom() {
        return nom;
    }

    public String getCog1() {
        return cog1;
    }

    public String getCog2() {
        return cog2;
    }

    public String getSexe() {
        return sexe;
    }

    public String getData_naixement() {
        return data_naixement;
    }

    public String getDni() {
        return dni;
    }


    //SETTERS

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCog1(String cog1) {
        this.cog1 = cog1;
    }

    public void setCog2(String cog2) {
        this.cog2 = cog2;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setData_naixement(String data_naixement) {
        this.data_naixement = data_naixement;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}