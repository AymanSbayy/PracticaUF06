package Objectes.Persones;

import CRUD.CRUD;
import ConnectionDB.ConnectionDB;
import Objectes.Candidatures.candidatura;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class personaDAO extends ConnectionDB implements CRUD<persona> {

    @Override
    public boolean create(persona persona) {
        String query = " INSERT INTO persones (nom,cog1,cog2,sexe,data_naixement,dni)"
                + " values (?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setString(1, persona.getNom());
            preparedStmt.setString(2, persona.getCog1());
            preparedStmt.setString(3, persona.getCog2());
            preparedStmt.setString(4, persona.getSexe());
            preparedStmt.setString(5, persona.getData_naixement());
            preparedStmt.setString(6, persona.getDni());
            preparedStmt.execute();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public List<persona> read(int id) {
        String query = "SELECT * FROM persones WHERE persona_id = ?";
        persona c = new persona();
        List<persona> camps = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                c.setPersona_id(rs.getInt("persona_id"));
                c.setNom(rs.getString("nom"));
                c.setCog1(rs.getString("cog1"));
                c.setCog2(rs.getString("cog2"));
                c.setSexe(rs.getString("sexe"));
                c.setData_naixement(rs.getString("data_naixement"));
                c.setDni(rs.getString("dni"));
                camps.add(c);
            }
            return camps;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public boolean update(String nom, String cog1,int id) {
        String query = "UPDATE persones SET nom = ?," + "cog1 = ? WHERE persona_id = ?";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, cog1);
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
        String query = "DELETE FROM persones WHERE persona_id = ?";

        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            preparedStmt.execute();

            int rowsAffected = preparedStmt.executeUpdate();

            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean exists(int id) {
        String query = "SELECT * FROM persones WHERE persona_id = ?";
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
        String query = "SELECT COUNT(*) FROM persones";

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
    public List<persona> all() {
        String query = "SELECT * FROM persones";
        List<persona> camps = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()){
                persona c = new persona();
                c.setPersona_id(rs.getInt("persona_id"));
                c.setNom(rs.getString("nom"));
                c.setCog1(rs.getString("cog1"));
                c.setCog2(rs.getString("cog2"));
                c.setSexe(rs.getString("sexe"));
                c.setData_naixement(rs.getString("data_naixement"));
                c.setDni(rs.getString("dni"));
                camps.add(c);
            }

            return camps;
        }catch (Exception e){
            System.out.println(e);
            return camps;
        }
    }
}
