package ConnectionDB;

import java.sql.*;

public class ConnectionDB {
    public static Connection con;

    public static Connection openCon(String ip, String bd, String usuari, String password){
        con = null;

        try{
            con = DriverManager.getConnection("jdbc:mysql://"+ ip +"/"+ bd + "?serverTimezone=UTC", usuari, password);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return con;
    }

    public static void closeCon(){
        try{
            if (con != null) con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
