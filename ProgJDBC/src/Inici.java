import ConnectionDB.ConnectionDB;
import Objectes.Candidatures.candidaturaDAO;
import Objectes.Comunitats_aut.comunitat_autDAO;
import Objectes.Persones.persona;
import Objectes.Persones.personaDAO;

import java.util.ArrayList;
import java.util.List;


public class Inici {
    public static void main(String[] args) {
        ConnectionDB.openCon("192.168.163.131","mydb", "perepi", "pastanaga");
        boolean createFlag = false;
        boolean updateFlag = false;
        boolean deleteFlag = false;
        boolean existsFlag = false;
        int numCamps = 0;
        boolean countFlag = false;
        List<persona> candicamps = new ArrayList<>();


        //Candidatura candi = new Candidatura(1,1,"1","1","Test","SA","AS","SS");
        //Candidatura candi2 = new Candidatura(2,1,"2","2","Test2","SA2","AS2","SS2");
        //Candidatura candi3 = new Candidatura(3,2,"3","3","Test3","SA3","AS3","SS3");
        //Comunitat_aut comu = new Comunitat_aut(1,"Angel","a1");
        //Comunitat_aut comu2 = new Comunitat_aut(2,"Ayman","a2");
        //Comunitat_aut comu3 = new Comunitat_aut(3,"Mario","m3");
        persona persona = new persona(1,"Angel","Tarensi","Moran","M","2004/12/11/","12345678C");
        Objectes.Persones.persona persona2 = new persona(2,"Ayman","Sbay","","M","2002/05/02/","61261241S");
        Objectes.Persones.persona persona3 = new persona(3,"Mario","Flores","","F","2003/04/10/","51245942W");
        
        candidaturaDAO candidatures = new candidaturaDAO();
        comunitat_autDAO comaut = new comunitat_autDAO();
        personaDAO perso = new personaDAO();
        //createFlag = perso.create(persona3);
        //updateFlag = perso.update(persona, 2);
        //candicamps = perso.read(2);
        //deleteFlag = perso.delete(2);
        //existsFlag = perso.exists(3);
        //numCamps = perso.count();
        //candicamps = perso.all();
        
        if (createFlag) System.out.println("CREATED");
        else System.out.println("NOT CREATED");
        if (updateFlag) System.out.println("UPDATED");
        else System.out.println("NOT UPDATED");
        if (deleteFlag) System.out.println("DELETED");
        else System.out.println("NOT DELETED");
        if (existsFlag) System.out.println("EXISTS");
        else System.out.println("NOT EXISTS");
        System.out.println(numCamps);

        for (int i = 0; i < candicamps.size(); i++){
            System.out.println(candicamps.get(i).toString());
        }


    }
}
