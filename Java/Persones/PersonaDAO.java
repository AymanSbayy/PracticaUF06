package Objectes.Persones;

import CRUD.CRUD;
import ConnectionDB.ConnectionDB;
import Objectes.Candidatures.Candidatura;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO extends ConnectionDB implements CRUD<Persona> {

    @Override
    public boolean create(Persona persona) {
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
    public List<Persona> read(int id) {
        String query = "SELECT * FROM persones WHERE persona_id = ?";
        Persona c = new Persona();
        List<Persona> camps = new ArrayList<>();
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
    public boolean update(Persona persona, int id) {
        String query = "UPDATE persones SET nom = ?, cog1 = ?, cog2 = ?, sexe = ?, data_naixement = ? WHERE persona_id = ?";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setString(1,persona.getNom());
            preparedStmt.setString(2,persona.getCog1());
            preparedStmt.setString(3,persona.getCog2());
            preparedStmt.setString(4,persona.getSexe());
            preparedStmt.setString(5,persona.getData_naixement());
            preparedStmt.setInt(6, id);
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

            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean exists(int id) {
        String query = "SELECT * FROM persones WHERE persona_id = ?";
        Candidatura c = null;
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
    public List<Persona> all() {
        String query = "SELECT * FROM persones";
        List<Persona> camps = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()){
                Persona c = new Persona();
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
