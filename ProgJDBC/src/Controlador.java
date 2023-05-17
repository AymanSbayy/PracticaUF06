import ConnectionDB.ConnectionDB;
import Objectes.Candidatures.candidatura;
import Objectes.Comunitats_aut.comunitat_aut;
import Objectes.Persones.persona;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Controlador {

    private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean flag;
        do {
            flag = true;

            Scanner scanner = new Scanner(System.in);
            String IP, BD, usuari, contraseña;
            System.out.println("Primer de tot has d'iniciar sessió en la base de dades.");
            System.out.println("Fes-ho seguint aquest format. 'IP' - 'NomBD' - 'NomUsuari' - 'Contraseña'.");
            System.out.println("Exemple --> 192.168.163.131 mydb perepi pastanaga");
            String dades = scanner.nextLine();

            String[] dadesSeparadas = dades.split(" ");
            if (dadesSeparadas.length != 4) {
                System.out.println("Error: No se proporcionaron los valores adecuados. Asegúrate de seguir el formato especificado.");
                flag = false;
            } else {
                IP = dadesSeparadas[0];
                BD = dadesSeparadas[1];
                usuari = dadesSeparadas[2];
                contraseña = dadesSeparadas[3];
                if (!IP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
                    System.out.println("Error: La dirección IP no tiene el formato adecuado (111.111.111.111).");
                    flag = false;
                } else if (BD.isEmpty() || usuari.isEmpty() || contraseña.isEmpty()) {
                    System.out.println("Error: Las variables de base de datos, usuario o contraseña están vacías.");
                    flag = false;
                } else {
                    ConnectionDB.openCon(IP, BD, usuari, contraseña);
                }

                int opcionPrincipal = 0;

                do {
                    System.out.println("            ╔═══════════════════════════╗");
                    System.out.println("            ║        MENU PRINCIPAL     ║");
                    System.out.println("            ╠═══════════════════════════╣");
                    System.out.println("            ║ 1. CREATE (Crear)         ║");
                    System.out.println("            ║ 2. READ (Llegir)          ║");
                    System.out.println("            ║ 3. UPDATE (Actualitzar)   ║");
                    System.out.println("            ║ 4. DELETE (Eliminar)      ║");
                    System.out.println("            ║ 5. EXISTS (Existeix)      ║");
                    System.out.println("            ║ 6. COUNT (Comptar)        ║");
                    System.out.println("            ║ 7. LISTALL (Llistar tot)  ║");
                    System.out.println("            ║ 0. SORTIR                 ║");
                    System.out.println("            ╚═══════════════════════════╝");

                    System.out.print("Selecciona una opció: ");
                    String input = scanner.nextLine();

                    if (input.matches("[0-7]")) {
                        int numero = Integer.parseInt(input);

                        opcionPrincipal = numero;
                        switch (numero) {
                            case 1:
                                clearConsole();
                                System.out.println("Has seleccionat l'opció CREATE.");
                                mostrarSubMenuCREATE("CREATE", scanner);
                                break;
                            case 2:
                                clearConsole();
                                System.out.println("Has seleccionat l'opció READ.");
                                mostrarSubMenuREAD("READ", scanner);
                                break;
                            case 3:
                                clearConsole();
                                System.out.println("Has seleccionat l'opció UPDATE.");
                                mostrarSubMenuUPDATE("UPDATE", scanner);
                                break;
                            case 4:
                                clearConsole();
                                System.out.println("Has seleccionat l'opció DELETE.");
                                mostrarSubMenuDELETE("DELETE", scanner);
                                break;
                            case 5:
                                clearConsole();
                                System.out.println("Has seleccionat l'opció EXISTS.");
                                mostrarSubMenuEXISTS("EXISTS", scanner);
                                break;
                            case 6:
                                clearConsole();
                                System.out.println("Has seleccionat l'opció COUNT.");
                                mostrarSubMenuCOUNT("COUNT", scanner);
                                break;
                            case 7:
                                clearConsole();
                                System.out.println("Has seleccionat l'opció LISTALL.");
                                mostrarSubMenuLISTALL("LISTALL", scanner);
                                break;
                            case 0:
                                clearConsole();
                                System.out.println("Gràcies per utilitzar el programa. Fins aviat!");
                                break;
                            default:
                                System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                                break;
                        }
                        System.out.println();
                    } else {
                        clearConsole();
                        System.out.println("Error: debe ingresar un número del 0 al 7.");
                    }
                } while (opcionPrincipal != 0);
                scanner.close();
            }
        }while (!flag);
    }

    public static void mostrarSubMenuCREATE(String accion, Scanner scanner) {
        int opcionSubMenu = 0;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "      ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Persones               ║");
            System.out.println("║ 3. Comunitats Autònomes   ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            String input = scanner.nextLine();
            if (input.matches("[0-3]")) {
                int numero = Integer.parseInt(input);
                opcionSubMenu = numero;

            switch (numero) {
                case 1:
                    try {
                        int eleccio_id;
                        String codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulario_nacional;
                        clearConsole();
                        System.out.println("Has seleccionat la taula Candidatures.");
                        System.out.println("Els camps d'aquesta taula son: eleccio_id, codi_candidatura, nom_curt," +
                                " nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulario_nacional");
                        System.out.println("Introdueix els valors que vols introduïr amb el mateix format i orde que s'ha utilitzat en la línea anterior," +
                                " però en lloc de comas utilitza només espais.");
                        eleccio_id = scanner.nextInt();
                        codi_candidatura = scanner.next().trim();
                        nom_curt = scanner.next().trim();
                        nom_llarg = scanner.next().trim();
                        codi_acumulacio_provincia = scanner.next().trim();
                        codi_acumulacio_ca = scanner.next().trim();
                        codi_acumulario_nacional = scanner.next().trim();
                        scanner.nextLine();

                        int candidatura_id = 1;

                        candidatura candi = new candidatura(candidatura_id, eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia
                                , codi_acumulacio_ca, codi_acumulario_nacional);
                        Model.crearCand(candi);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    break;
                case 2:
                    try {
                        clearConsole();
                        String nom, cog1, cog2, sexe, data_naixement, dni;
                        System.out.println("Has seleccionat la taula Persones.");
                        System.out.println("Els camps d'aquesta taula son: nom, cog2, cog2," +
                                " sexe, data_naixement(aaaa/mm/dd), dni");
                        System.out.println("Introdueix els valors que vols introduïr amb el mateix format i orde que s'ha utilitzat en la línea anterior," +
                                " però en lloc de comas utilitza només espais.");
                        nom = scanner.next().trim();
                        cog1 = scanner.next().trim();
                        cog2 = scanner.next().trim();
                        sexe = scanner.next().trim();
                        data_naixement = scanner.next().trim();
                        dni = scanner.next().trim();
                        scanner.nextLine();

                        int persona_id = 1;

                        persona perso = new persona(persona_id, nom, cog1, cog2, sexe, data_naixement, dni);
                        Model.crearPerso(perso);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try {
                        clearConsole();
                        String codi_ine, nom;
                        System.out.println("Has seleccionat la taula Comunitats autonomes.");
                        System.out.println("Els camps d'aquesta taula son: nom, codi_ine");
                        System.out.println("Introdueix els valors que vols introduïr amb el mateix format i orde que s'ha utilitzat en la línea anterior," +
                                " però en lloc de comas utilitza només espais.");
                        nom = scanner.next().trim();
                        codi_ine = scanner.next().trim();
                        scanner.nextLine();

                        int comunitat_aut_id = 1;

                        comunitat_aut comuaut = new comunitat_aut(comunitat_aut_id, nom, codi_ine);
                        Model.crearComunitataut(comuaut);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 0:
                    clearConsole();
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                    break;
                }
            }else {
                clearConsole();
                System.out.println("Error: debe ingresar un número del 0 al 3.");
            }
            System.out.println();
        } while (opcionSubMenu != 0);
    }
    public static void mostrarSubMenuREAD(String accion, Scanner scanner) {
        int opcionSubMenu = 0;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "        ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Persones               ║");
            System.out.println("║ 3. Comunitats Autònomes   ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            String input = scanner.nextLine();
            if (input.matches("[0-3]")) {
                int numero = Integer.parseInt(input);
                opcionSubMenu = numero;

                switch (numero) {
                    case 1:
                        int id;
                        clearConsole();
                        System.out.println("Has seleccionat la taula Candidatures.");
                        System.out.print("Escriu l'ID de la candidatura que vols que es mostri: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        Model.readCand(id);

                        break;
                    case 2:
                        clearConsole();
                        System.out.println("Has seleccionat la taula Persones.");
                        System.out.print("Escriu l'ID de la Comunitat_autonomes que vols que es mostri: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        Model.readPersona(id);

                        break;
                    case 3:
                        clearConsole();
                        System.out.println("Has seleccionat la taula Comunitats autonomes.");
                        System.out.print("Escriu l'ID de la Comunitat_autonomes que vols que es mostri: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        Model.readComaut(id);

                        break;
                    case 0:
                        clearConsole();
                        System.out.println("Tornant al menú principal...");
                        break;
                    default:
                        System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                        break;
                }
                System.out.println();
            }else {
                clearConsole();
                System.out.println("Error: debe ingresar un número del 0 al 3.");
            }
        }while (opcionSubMenu != 0) ;
    }

    public static void mostrarSubMenuUPDATE(String accion, Scanner scanner) {
        int opcionSubMenu = 0;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "      ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Persones               ║");
            System.out.println("║ 3. Comunitats Autònomes   ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            String input = scanner.nextLine();
            if (input.matches("[0-3]")) {
                int numero = Integer.parseInt(input);
                opcionSubMenu = numero;

                switch (opcionSubMenu) {
                    case 1:
                        try {
                            clearConsole();
                            int id = 0;
                            String nom_curt = "", nom_llarg = "";
                            System.out.println("Has seleccionat la taula Candidatures.");
                            System.out.println("Pots cambiar les columnes de 'nom_curt' i 'nom_llarg'.");
                            System.out.println("Escriu les noves dades i al final l'id del camp que vols que s'editi. En aquest fromat: nom_curt nom_llarg ID:");
                            String parametres = scanner.nextLine();

                            int primerEspacio = parametres.indexOf(" ");
                            int segundoEspacio = parametres.indexOf(" ", primerEspacio + 1);

                            nom_llarg = parametres.substring(0, primerEspacio);
                            nom_curt = parametres.substring(primerEspacio + 1, segundoEspacio);
                            id = Integer.parseInt(parametres.substring(segundoEspacio + 1));
                            Model.updateCandi(nom_llarg, nom_curt, id);

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case 2:
                        try {
                            clearConsole();
                            int id = 0;
                            String nom = "", cog1 = "";
                            System.out.println("Has seleccionat la taula Persones.");
                            System.out.println("Pots cambiar les columnes de 'nom' i 'cog1'.");
                            System.out.println("Escriu les noves dades i al final l'id del camp que vols que s'editi. En aquest fromat: nom cog1 ID:");
                            String parametres = scanner.nextLine();

                            int primerEspacio = parametres.indexOf(" ");
                            int segundoEspacio = parametres.indexOf(" ", primerEspacio + 1);

                            nom = parametres.substring(0, primerEspacio);
                            cog1 = parametres.substring(primerEspacio + 1, segundoEspacio);
                            id = Integer.parseInt(parametres.substring(segundoEspacio + 1));
                            Model.updatePersona(nom, cog1, id);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case 3:
                        try {
                            clearConsole();
                            int id = 0;
                            String codi_ine = "", nom = "";
                            System.out.println("Has seleccionat la taula Comunitats autonomes.");
                            System.out.println("Pots cambiar les columnes de 'nom' i 'codi_ine'.");
                            System.out.println("Escriu les noves dades i al final l'id del camp que vols que s'editi. En aquest fromat: nom codi_ine ID:");
                            String parametres = scanner.nextLine();

                            int primerEspacio = parametres.indexOf(" ");
                            int segundoEspacio = parametres.indexOf(" ", primerEspacio + 1);

                            nom = parametres.substring(0, primerEspacio);
                            codi_ine = parametres.substring(primerEspacio + 1, segundoEspacio);
                            id = Integer.parseInt(parametres.substring(segundoEspacio + 1));
                            Model.updateComaut(nom, codi_ine, id);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case 0:
                        clearConsole();
                        System.out.println("Tornant al menú principal...");
                        break;
                    default:
                        System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                        break;
                }
                System.out.println();
            }else {
                clearConsole();
                System.out.println("Error: debe ingresar un número del 0 al 3.");
            }
        } while (opcionSubMenu != 0);
    }

    public static void mostrarSubMenuDELETE(String accion, Scanner scanner) {
        int opcionSubMenu = 0;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "      ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Persones               ║");
            System.out.println("║ 3. Comunitats Autònomes   ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            String input = scanner.nextLine();
            if (input.matches("[0-3]")) {
                int numero = Integer.parseInt(input);
                opcionSubMenu = numero;

                switch (opcionSubMenu) {
                    case 1:
                        try {
                            int id;
                            System.out.println("Has seleccionat el camp Candidatures.");
                            System.out.println("Quin camp vols eliminar? Escriu la candidatura_id del camp:");
                            id = scanner.nextInt();
                            scanner.nextLine();

                            Model.delCand(id);
                        }catch (Exception e){
                            System.out.println(e);
                        }

                        break;
                    case 2:
                        try{
                            int id;
                            System.out.println("Has seleccionat la taula Persones.");
                            System.out.println("Quin camp vols eliminar? Escriu la candidatura_id del camp:");
                            id = scanner.nextInt();
                            scanner.nextLine();

                            Model.delPersona(id);
                        }catch (Exception e){
                            System.out.println(e);
                        }
                        break;
                    case 3:
                        try{
                            int id;
                            System.out.println("Has seleccionat la taula Comunitats autonomes.");
                            System.out.println("Quin camp vols eliminar? Escriu la candidatura_id del camp:");
                            id = scanner.nextInt();
                            scanner.nextLine();

                            Model.delComaut(id);
                        }catch (Exception e){
                            System.out.println(e);
                        }

                        break;
                    case 0:
                        clearConsole();
                        System.out.println("Tornant al menú principal...");
                        break;
                    default:
                        System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                        break;
                }
                System.out.println();
            }else {
                clearConsole();
                System.out.println("Error: debe ingresar un número del 0 al 3.");
            }
        } while (opcionSubMenu != 0);
    }
    public static void mostrarSubMenuEXISTS(String accion, Scanner scanner) {
        int opcionSubMenu = 0;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "      ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Persones               ║");
            System.out.println("║ 3. Comunitats Autònomes   ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            String input = scanner.nextLine();
            if (input.matches("[0-3]")) {
                int numero = Integer.parseInt(input);
                opcionSubMenu = numero;

                switch (opcionSubMenu) {
                    case 1:
                        try{
                            int id;
                            clearConsole();
                            System.out.println("Has seleccionat la taula Candidatures.");
                            System.out.print("Escriu l'ID de la candidatura la qual vols saber si existeix: ");
                            id = scanner.nextInt();
                            scanner.nextLine();
                            Model.candiExists(id);
                        }catch (Exception e){
                            System.out.println(e);
                        }

                        break;
                    case 2:
                        try{
                            int id;
                            clearConsole();
                            System.out.println("Has seleccionat la taula Persones.");
                            System.out.print("Escriu l'ID de la candidatura la qual vols saber si existeix: ");
                            id = scanner.nextInt();
                            scanner.nextLine();
                            Model.personaExists(id);
                        }catch (Exception e){
                            System.out.println(e);
                        }

                        break;
                    case 3:
                        try{
                            int id;
                            clearConsole();
                            System.out.println("Has seleccionat la taula Comunitats Autonomes.");
                            System.out.print("Escriu l'ID de la candidatura la qual vols saber si existeix: ");
                            id = scanner.nextInt();
                            scanner.nextLine();
                            Model.comautExists(id);
                        }catch (Exception e){
                            System.out.println(e);
                        }

                        break;
                    case 0:
                        clearConsole();
                        System.out.println("Tornant al menú principal...");
                        break;
                    default:
                        System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                        break;
                }
                System.out.println();
            }else {
                clearConsole();
                System.out.println("Error: debe ingresar un número del 0 al 3.");
            }
        } while (opcionSubMenu != 0);
    }

    public static void mostrarSubMenuCOUNT(String accion, Scanner scanner) {
        int opcionSubMenu = 0;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "       ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Persones               ║");
            System.out.println("║ 3. Comunitats Autònomes   ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            String input = scanner.nextLine();
            if (input.matches("[0-3]")) {
                int numero = Integer.parseInt(input);
                opcionSubMenu = numero;

                switch (opcionSubMenu) {
                    case 1:
                        try{
                            clearConsole();
                            System.out.println("Has seleccionat la taula Candidatures.");
                            Model.countCand();
                        }catch (Exception e){
                            System.out.println(e);
                        }
                        break;
                    case 2:
                        try{
                            clearConsole();
                            System.out.println("Has seleccionat la taula Persones.");
                            Model.countPersona();
                        }catch (Exception e){
                            System.out.println(e);
                        }
                        break;
                    case 3:
                        try {
                            clearConsole();
                            System.out.println("Has seleccionat la taula Comunitats Autonomes.");
                            Model.countComaut();
                        }catch (Exception e){
                            System.out.println(e);
                        }

                        break;
                    case 0:
                        clearConsole();
                        System.out.println("Tornant al menú principal...");
                        break;
                    default:
                        System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                        break;
                }
                System.out.println();
            }else {
                clearConsole();
                System.out.println("Error: debe ingresar un número del 0 al 3.");
            }
        } while (opcionSubMenu != 0);
    }

    public static void mostrarSubMenuLISTALL(String accion, Scanner scanner) {
        int opcionSubMenu = 0;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "     ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Persones               ║");
            System.out.println("║ 3. Comunitats Autònomes   ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            String input = scanner.nextLine();
            if (input.matches("[0-3]")) {
                int numero = Integer.parseInt(input);
                opcionSubMenu = numero;

                switch (opcionSubMenu) {
                    case 1:
                        try{
                            System.out.println("Has seleccionat la taula Candidatures.");
                            Model.listCand();
                        }catch (Exception e){
                            System.out.println(e);
                        }
                        break;
                    case 2:
                        try {
                            System.out.println("Has seleccionat la taula Persones.");
                            Model.listPersona();
                        }catch (Exception e){
                            System.out.println(e);
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("Has seleccionat la taula Comunitats Autonomes.");
                            Model.listComaut();
                        }catch (Exception e){
                            System.out.println(e);
                        }
                        break;
                    case 0:
                        clearConsole();
                        System.out.println("Tornant al menú principal...");
                        break;
                    default:
                        System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                        break;
                }
                System.out.println();
            }else {
                clearConsole();
                System.out.println("Error: debe ingresar un número del 0 al 3.");
            }
        } while (opcionSubMenu != 0);
    }

    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}