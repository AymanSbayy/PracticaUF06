package Objectes.Comunitats_aut;

import java.util.Scanner;

public class Comunitat_aut {
    Scanner scan = new Scanner(System.in);
    int comunitat_aut_id;
    String nom;
    String codi_ine;

    public Comunitat_aut(int comunitat_aut_id, String nom, String codi_ine){
        this.comunitat_aut_id = IsInt(comunitat_aut_id);
        this.nom = StringLength45(nom);
        this.codi_ine = IsChar(codi_ine);
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
            if (s.length() > 7) flag = true;
            else {
                System.out.println("El String introduït es passa més de 6 caracters");
                s = scan.nextLine();
            }
        }
        return s;
    }
    private String StringLength45(String s){
        boolean flag = false;
        while (!flag){
            if (s.length() > 45) flag = true;
            else {
                System.out.println("El String introduït es passa més de 45 caracters");
                s = scan.nextLine();
            }
        }
        return s;
    }

    //GETTERS
    public int getComunitat_aut_id() {
        return comunitat_aut_id;
    }

    public String getNom() {
        return nom;
    }

    public String getCodi_ine() {
        return codi_ine;
    }

    //SETTERS
    public void setComunitat_aut_id(int comunitat_aut_id) {
        this.comunitat_aut_id = comunitat_aut_id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodi_ine(String codi_ine) {
        this.codi_ine = codi_ine;
    }
}
