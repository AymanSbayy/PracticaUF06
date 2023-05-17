package Objectes.Comunitats_aut;

import CRUD.CRUD;
import ConnectionDB.ConnectionDB;
import Objectes.Candidatures.candidatura;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class comunitat_autDAO extends ConnectionDB implements CRUD<comunitat_aut> {

    @Override
    public boolean create(comunitat_aut comunitat_aut) {
        String query = " INSERT INTO comunitats_autonomes (nom,codi_ine)"
                + " values (?, ?)";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setString(1, comunitat_aut.getNom());
            preparedStmt.setString(2, comunitat_aut.getCodi_ine());
            preparedStmt.execute();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public List<comunitat_aut> read(int id) {
        String query = "SELECT * FROM comunitats_autonomes WHERE comunitat_aut_id = ?";
        comunitat_aut c = new comunitat_aut();
        List<comunitat_aut> camps = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                c.setComunitat_aut_id(rs.getInt("comunitat_aut_id"));
                c.setNom(rs.getString("nom"));
                c.setCodi_ine(rs.getString("codi_ine"));
                camps.add(c);
            }
            return camps;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public boolean update(String nom, String codi_ine, int id) {
        String query = "UPDATE comunitats_autonomes SET nom = ?, codi_ine = ? WHERE comunitat_aut_id = ?";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, codi_ine);
            preparedStmt.setInt(3, id);
            preparedStmt.execute();

            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM comunitats_autonomes WHERE comunitat_aut_id = ?";

        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            preparedStmt.execute();

            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean exists(int id) {
        String query = "SELECT * FROM comunitats_autonomes WHERE comunitat_aut_id = ?";
        candidatura c = null;
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();

            if (rs.next())return true;
            else return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public int count() {
        String query = "SELECT COUNT(*) FROM comunitats_autonomes";

        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);

            ResultSet rs = preparedStmt.executeQuery();

            if (rs.next()) return rs.getInt(1);
            else return 0;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public List<comunitat_aut> all() {
        String query = "SELECT * FROM comunitats_autonomes";
        List<comunitat_aut> camps = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()){
                comunitat_aut c = new comunitat_aut();
                c.setComunitat_aut_id(rs.getInt("comunitat_aut_id"));
                c.setNom(rs.getString("nom"));
                c.setCodi_ine(rs.getString("codi_ine"));
                camps.add(c);
            }

            return camps;
        }catch (Exception e){
            System.out.println(e);
            return camps;
        }
    }
}
