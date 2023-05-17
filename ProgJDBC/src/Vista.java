import Objectes.Candidatures.candidatura;
import Objectes.Comunitats_aut.comunitat_aut;
import Objectes.Persones.persona;

import java.util.List;

public class Vista {

    //CREATE
    public static void mostrarCrear(boolean CREAT) {
        if (CREAT) System.out.println("El camp s'ha creat de manera correcte.");
        else System.out.println("No s'ha pogut crear el teu camp.");
        sleep();
    }
    //READ - LISTALL
    public static void mostrarReadCandidatura(List<candidatura> camps) {
        for (int i = 0; i < camps.size(); i++) {
            System.out.println(camps.get(i).toString());
        }
        sleep();
    }
    public static void mostrarReadPersona(List<persona> camps) {
        for (int i = 0; i < camps.size(); i++) {
            System.out.println(camps.get(i).toString());
        }
        sleep();
    }
    public static void mostrarReadComaut(List<comunitat_aut> camps) {
        for (int i = 0; i < camps.size(); i++) {
            System.out.println(camps.get(i).toString());
        }
        sleep();
    }
    //UPDATE
    public static void Upd(boolean upd) {
        if (upd) System.out.println("S'han actualitzat els camps correctament.");
        else System.out.println("No s'han actualitzat els camps correctament.");
        sleep();
    }

    //DELETE
    public static void Delete(boolean del) {
        if (del) System.out.println("S'ha eliminat el camp correctament.");
        else System.out.println("No s'ha eliminat correctament.");
        sleep();
    }

    //EXISTS
    public static void exists(boolean exists) {
        if (exists) System.out.println("El camp existeix.");
        else System.out.println("El camp no existeix.");
        sleep();
    }

    //COUNT
    public static void mostrarCount(int count) {
        System.out.println("El numero de camps totals en aquesta taula és: " + count);
        sleep();
    }

    public static void sleep() {
        int count = 0;

        System.out.println("Començant compte enrere...");
        while (count < 3) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count++;
            System.out.print("\rCount: " + count);
        }
        clearConsole();
    }

    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}