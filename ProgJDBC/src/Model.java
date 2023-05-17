import Objectes.Candidatures.candidatura;
import Objectes.Candidatures.candidaturaDAO;
import Objectes.Comunitats_aut.comunitat_aut;
import Objectes.Comunitats_aut.comunitat_autDAO;
import Objectes.Persones.persona;
import Objectes.Persones.personaDAO;

import java.util.List;

public class Model {

    //CREATE
    public static void crearCand(candidatura candi) {
        candidaturaDAO candidatures = new candidaturaDAO();
        Vista.mostrarCrear(candidatures.create(candi));

    }

    public static void crearPerso(persona perso) {
        personaDAO persona = new personaDAO();
        Vista.mostrarCrear(persona.create(perso));
    }

    public static void crearComunitataut(comunitat_aut comaut) {
        comunitat_autDAO comunitat_aut = new comunitat_autDAO();
        Vista.mostrarCrear(comunitat_aut.create(comaut));
    }

    //READ
    public static void readCand(int id) {
        List<candidatura> candicamps;
        candidaturaDAO candidatures = new candidaturaDAO();
        candicamps = candidatures.read(id);
        Vista.mostrarReadCandidatura(candicamps);
    }

    public static void readPersona(int id) {
        List<persona> camps;
        personaDAO perso = new personaDAO();
        camps = perso.read(id);
        Vista.mostrarReadPersona(camps);
    }

    public static void readComaut(int id) {
        List<comunitat_aut> camps;
        comunitat_autDAO comaut = new comunitat_autDAO();
        camps = comaut.read(id);
        Vista.mostrarReadComaut(camps);
    }
    //UPDATE
    public static void updateCandi(String nom_llarg, String nom_curt, int id) {
        candidaturaDAO candidatures = new candidaturaDAO();
        Vista.Upd(candidatures.update(nom_curt, nom_llarg, id));
    }
    public static void updatePersona(String nom, String cog1,int id) {
        personaDAO perso = new personaDAO();
        Vista.Upd(perso.update(nom, cog1, id));
    }
    public static void updateComaut(String nom, String codi_ine,int id) {
        comunitat_autDAO comaut = new comunitat_autDAO();
        Vista.Upd(comaut.update(nom, codi_ine, id));
    }

    //DELETE
    public static void delCand(int id) {
        candidaturaDAO candidatures = new candidaturaDAO();
        Vista.Delete(candidatures.delete(id));
    }
    public static void delPersona(int id) {
        personaDAO perso = new personaDAO();
        Vista.Delete(perso.delete(id));
    }
    public static void delComaut(int id) {
        comunitat_autDAO comaut = new comunitat_autDAO();
        Vista.Delete(comaut.delete(id));
    }

    //EXISTS
    public static void candiExists(int id) {
        candidaturaDAO candidatures = new candidaturaDAO();
        Vista.exists(candidatures.exists(id));
    }
    public static void personaExists(int id) {
        personaDAO perso = new personaDAO();
        Vista.exists(perso.exists(id));
    }
    public static void comautExists(int id) {
        comunitat_autDAO comaut = new comunitat_autDAO();
        Vista.exists(comaut.exists(id));
    }

    //COUNT
    public static void countCand() {
        candidaturaDAO candi = new candidaturaDAO();
        Vista.mostrarCount(candi.count());
    }
    public static void countPersona() {
        personaDAO perso = new personaDAO();
        Vista.mostrarCount(perso.count());
    }
    public static void countComaut() {
        comunitat_autDAO comaut = new comunitat_autDAO();
        Vista.mostrarCount(comaut.count());
    }

    //LISTALL
    public static void listCand() {
        candidaturaDAO candidatures = new candidaturaDAO();
        Vista.mostrarReadCandidatura(candidatures.all());
    }
    public static void listPersona() {
        personaDAO perso = new personaDAO();
        Vista.mostrarReadPersona(perso.all());
    }
    public static void listComaut() {
        comunitat_autDAO comaut = new comunitat_autDAO();
        Vista.mostrarReadComaut(comaut.all());
    }
}