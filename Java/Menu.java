package Main;

import Candidatures.Candidatura;
import Connection.ConnectionDB;
import Main.Model;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Controlador {

    private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String IP, BD, usuari, contraseña;
        System.out.println("Primer de tot has d'iniciar sessió en la base de dades.");
        System.out.println("Fes-ho seguint aquest fromat. 'IP' - 'NomBD' - 'NomUsuari' - 'Contraseña'.");
        System.out.println("Exemple --> 192.168.48.146 EleccionsUF06 perepi pastanaga");
        String dades = scanner.nextLine();
        int primerEspacio = dades.indexOf(" ");
        int segundoEspacio = dades.indexOf(" ", primerEspacio + 1);
        int tercerEspacio = dades.indexOf(" ", segundoEspacio + 1);

        IP = dades.substring(0, primerEspacio);
        BD = dades.substring(primerEspacio + 1, segundoEspacio);
        usuari = dades.substring(segundoEspacio + 1, tercerEspacio);
        contraseña = dades.substring(tercerEspacio + 1);
        ConnectionDB.openCon(IP, BD, usuari, contraseña);

        int opcionPrincipal;

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
            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    clearConsole();
                    System.out.println("Has seleccionat l'opció CREATE.");
                    mostrarSubMenuCREATE("CREATE", scanner);
                    break;
                case 2:
                    System.out.println("Has seleccionat l'opció READ.");
                    mostrarSubMenuREAD("READ", scanner);
                    break;
                case 3:
                    System.out.println("Has seleccionat l'opció UPDATE.");
                    mostrarSubMenuUODATE("UPDATE", scanner);
                    break;
                case 4:
                    System.out.println("Has seleccionat l'opció DELETE.");
                    mostrarSubMenuDELETE("DELETE", scanner);
                    break;
                case 5:
                    System.out.println("Has seleccionat l'opció EXISTS.");
                    mostrarSubMenuEXISTS("EXISTS", scanner);
                    break;
                case 6:
                    System.out.println("Has seleccionat l'opció COUNT.");
                    mostrarSubMenuCOUNT("COUNT", scanner);
                    break;
                case 7:
                    System.out.println("Has seleccionat l'opció LISTALL.");
                    mostrarSubMenuLISTALL("LISTALL", scanner);
                    break;
                case 0:
                    System.out.println("Gràcies per utilitzar el programa. Fins aviat!");
                    break;
                default:
                    System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                    break;
            }
            System.out.println();
        } while (opcionPrincipal != 0);

        scanner.close();

    }

    public static void mostrarSubMenuCREATE(String accion, Scanner scanner) {
        int opcionSubMenu;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "      ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Candidats              ║");
            System.out.println("║ 3. Persones               ║");
            System.out.println("║ 4. Comunitats Autònomes   ║");
            System.out.println("║ 5. Provincies             ║");
            System.out.println("║ 6. Municipis              ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            opcionSubMenu = scanner.nextInt();

            switch (opcionSubMenu) {
                case 1:
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

                    System.out.println("Ara, introdueix la candidatura_id");
                    int candidatura_id = scanner.nextInt();
                    scanner.nextLine();

                    Candidatura candi = new Candidatura(candidatura_id, eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia
                            , codi_acumulacio_ca, codi_acumulario_nacional);
                    Model.CrearCand(candi);

                    break;
                case 2:
                    System.out.println("Has seleccionat la taula Candidats.");

                    break;
                case 3:
                    System.out.println("Has seleccionat la taula Persones.");

                    break;
                case 4:
                    System.out.println("Has seleccionat la taula Comunitats Autònomes.");

                    break;
                case 5:
                    System.out.println("Has seleccionat la taula Provincies.");

                    break;
                case 6:
                    System.out.println("Has seleccionat la taula Municipis.");

                    break;
                case 0:
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                    break;
            }
            System.out.println();
        } while (opcionSubMenu != 0);
    }

    public static void mostrarSubMenuCOUNT(String accion, Scanner scanner) {
        int opcionSubMenu;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "      ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Candidats              ║");
            System.out.println("║ 3. Persones               ║");
            System.out.println("║ 4. Comunitats Autònomes   ║");
            System.out.println("║ 5. Provincies             ║");
            System.out.println("║ 6. Municipis              ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            opcionSubMenu = scanner.nextInt();

            switch (opcionSubMenu) {
                case 1:
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

                    System.out.println("Ara, introdueix la candidatura_id");
                    int candidatura_id = scanner.nextInt();
                    scanner.nextLine();

                    Candidatura candi = new Candidatura(candidatura_id, eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia
                            , codi_acumulacio_ca, codi_acumulario_nacional);
                    Model.CrearCand(candi);

                    break;
                case 2:
                    System.out.println("Has seleccionat la taula Candidats.");

                    break;
                case 3:
                    System.out.println("Has seleccionat la taula Persones.");

                    break;
                case 4:
                    System.out.println("Has seleccionat la taula Comunitats Autònomes.");

                    break;
                case 5:
                    System.out.println("Has seleccionat la taula Provincies.");

                    break;
                case 6:
                    System.out.println("Has seleccionat la taula Municipis.");

                    break;
                case 0:
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                    break;
            }
            System.out.println();
        } while (opcionSubMenu != 0);
    }

    public static void mostrarSubMenuLISTALL(String accion, Scanner scanner) {
        int opcionSubMenu;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "      ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Candidats              ║");
            System.out.println("║ 3. Persones               ║");
            System.out.println("║ 4. Comunitats Autònomes   ║");
            System.out.println("║ 5. Provincies             ║");
            System.out.println("║ 6. Municipis              ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            opcionSubMenu = scanner.nextInt();

            switch (opcionSubMenu) {
                case 1:
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

                    System.out.println("Ara, introdueix la candidatura_id");
                    int candidatura_id = scanner.nextInt();
                    scanner.nextLine();

                    Candidatura candi = new Candidatura(candidatura_id, eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia
                            , codi_acumulacio_ca, codi_acumulario_nacional);
                    Model.CrearCand(candi);

                    break;
                case 2:
                    System.out.println("Has seleccionat la taula Candidats.");

                    break;
                case 3:
                    System.out.println("Has seleccionat la taula Persones.");

                    break;
                case 4:
                    System.out.println("Has seleccionat la taula Comunitats Autònomes.");

                    break;
                case 5:
                    System.out.println("Has seleccionat la taula Provincies.");

                    break;
                case 6:
                    System.out.println("Has seleccionat la taula Municipis.");

                    break;
                case 0:
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                    break;
            }
            System.out.println();
        } while (opcionSubMenu != 0);
    }

    public static void mostrarSubMenuEXISTS(String accion, Scanner scanner) {
        int opcionSubMenu;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "      ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Candidats              ║");
            System.out.println("║ 3. Persones               ║");
            System.out.println("║ 4. Comunitats Autònomes   ║");
            System.out.println("║ 5. Provincies             ║");
            System.out.println("║ 6. Municipis              ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            opcionSubMenu = scanner.nextInt();

            switch (opcionSubMenu) {
                case 1:
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

                    System.out.println("Ara, introdueix la candidatura_id");
                    int candidatura_id = scanner.nextInt();
                    scanner.nextLine();

                    Candidatura candi = new Candidatura(candidatura_id, eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia
                            , codi_acumulacio_ca, codi_acumulario_nacional);
                    Model.CrearCand(candi);

                    break;
                case 2:
                    System.out.println("Has seleccionat la taula Candidats.");

                    break;
                case 3:
                    System.out.println("Has seleccionat la taula Persones.");

                    break;
                case 4:
                    System.out.println("Has seleccionat la taula Comunitats Autònomes.");

                    break;
                case 5:
                    System.out.println("Has seleccionat la taula Provincies.");

                    break;
                case 6:
                    System.out.println("Has seleccionat la taula Municipis.");

                    break;
                case 0:
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                    break;
            }
            System.out.println();
        } while (opcionSubMenu != 0);
    }

    public static void mostrarSubMenuREAD(String accion, Scanner scanner) {
        int opcionSubMenu;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "      ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Candidats              ║");
            System.out.println("║ 3. Persones               ║");
            System.out.println("║ 4. Comunitats Autònomes   ║");
            System.out.println("║ 5. Provincies             ║");
            System.out.println("║ 6. Municipis              ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            opcionSubMenu = scanner.nextInt();

            switch (opcionSubMenu) {
                case 1:
                    int id;
                    clearConsole();
                    System.out.println("Has seleccionat la taula Candidatures.");
                    System.out.print("Escriu l'ID de la candidatura que vols que es mostri: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    Model.READCand(id);

                    break;
                case 2:
                    System.out.println("Has seleccionat la taula Candidats.");

                    break;
                case 3:
                    System.out.println("Has seleccionat la taula Persones.");

                    break;
                case 4:
                    System.out.println("Has seleccionat la taula Comunitats Autònomes.");

                    break;
                case 5:
                    System.out.println("Has seleccionat la taula Provincies.");

                    break;
                case 6:
                    System.out.println("Has seleccionat la taula Municipis.");

                    break;
                case 0:
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                    break;
            }
            System.out.println();
        } while (opcionSubMenu != 0);
    }

    public static void mostrarSubMenuUODATE(String accion, Scanner scanner) {
        int opcionSubMenu;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "      ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Candidats              ║");
            System.out.println("║ 3. Persones               ║");
            System.out.println("║ 4. Comunitats Autònomes   ║");
            System.out.println("║ 5. Provincies             ║");
            System.out.println("║ 6. Municipis              ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            opcionSubMenu = scanner.nextInt();

            switch (opcionSubMenu) {
                case 1:
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

                    System.out.println("Ara, introdueix la candidatura_id");
                    int candidatura_id = scanner.nextInt();
                    scanner.nextLine();

                    Candidatura candi = new Candidatura(candidatura_id, eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia
                            , codi_acumulacio_ca, codi_acumulario_nacional);
                    Model.CrearCand(candi);

                    break;
                case 2:
                    System.out.println("Has seleccionat la taula Candidats.");

                    break;
                case 3:
                    System.out.println("Has seleccionat la taula Persones.");

                    break;
                case 4:
                    System.out.println("Has seleccionat la taula Comunitats Autònomes.");

                    break;
                case 5:
                    System.out.println("Has seleccionat la taula Provincies.");

                    break;
                case 6:
                    System.out.println("Has seleccionat la taula Municipis.");

                    break;
                case 0:
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                    break;
            }
            System.out.println();
        } while (opcionSubMenu != 0);
    }

    public static void mostrarSubMenuDELETE(String accion, Scanner scanner) {
        int opcionSubMenu;

        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║     SUBMENU - " + accion + "      ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Candidatures           ║");
            System.out.println("║ 2. Candidats              ║");
            System.out.println("║ 3. Persones               ║");
            System.out.println("║ 4. Comunitats Autònomes   ║");
            System.out.println("║ 5. Provincies             ║");
            System.out.println("║ 6. Municipis              ║");
            System.out.println("║ 0. TORNAR                 ║");
            System.out.println("╚═══════════════════════════╝");
            System.out.println();

            System.out.print("Selecciona una opció: ");
            opcionSubMenu = scanner.nextInt();

            switch (opcionSubMenu) {
                case 1:
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

                    System.out.println("Ara, introdueix la candidatura_id");
                    int candidatura_id = scanner.nextInt();
                    scanner.nextLine();

                    Candidatura candi = new Candidatura(candidatura_id, eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia
                            , codi_acumulacio_ca, codi_acumulario_nacional);
                    Model.CrearCand(candi);

                    break;
                case 2:
                    System.out.println("Has seleccionat la taula Candidats.");

                    break;
                case 3:
                    System.out.println("Has seleccionat la taula Persones.");

                    break;
                case 4:
                    System.out.println("Has seleccionat la taula Comunitats Autònomes.");

                    break;
                case 5:
                    System.out.println("Has seleccionat la taula Provincies.");

                    break;
                case 6:
                    System.out.println("Has seleccionat la taula Municipis.");

                    break;
                case 0:
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
                    break;
            }
            System.out.println();
        } while (opcionSubMenu != 0);
    }

    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
