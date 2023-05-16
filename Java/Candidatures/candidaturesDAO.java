package Objectes.Candidatures;
import ConnectionDB.ConnectionDB;
import CRUD.CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CandidaturaDAO extends ConnectionDB implements CRUD<Candidatura> {

    @Override
    public boolean create(Candidatura candidatures) {
        String query = " INSERT INTO candidatures (eleccio_id,codi_candidatura,nom_curt,nom_llarg,codi_acumulacio_provincia,codi_acumulacio_ca,codi_acumulacio_nacional)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, candidatures.getEleccio_id());
            preparedStmt.setString(2, candidatures.getCodi_candidatura());
            preparedStmt.setString(3, candidatures.getNom_curt());
            preparedStmt.setString(4, candidatures.getNom_llarg());
            preparedStmt.setString(5, candidatures.getCodi_acumulacio_provincia());
            preparedStmt.setString(6, candidatures.getCodi_acumulacio_ca());
            preparedStmt.setString(7, candidatures.getcodi_acumulacio_nacional());
            preparedStmt.execute();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public List<Candidatura> read(int id) {
        String query = "SELECT * FROM candidatures WHERE candidatura_id = ?";
        Candidatura c = new Candidatura();
        List<Candidatura> camps = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                c.setCandidatura_id(rs.getInt("candidatura_id"));
                c.setEleccio_id(rs.getInt("eleccio_id"));
                c.setCodi_candidatura(rs.getString("codi_candidatura"));
                c.setNom_curt(rs.getString("nom_curt"));
                c.setNom_llarg(rs.getString("nom_llarg"));
                c.setCodi_acumulacio_provincia(rs.getString("codi_acumulacio_provincia"));
                c.setCodi_acumulacio_ca(rs.getString("codi_acumulacio_ca"));
                c.setcodi_acumulacio_nacional(rs.getString("codi_acumulacio_nacional"));
                camps.add(c);
            }
            return camps;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public boolean update(Candidatura candidatures, int id) {
        String query = "UPDATE candidatures SET codi_candidatura = ?, nom_curt = ?," +
                "nom_llarg = ?, codi_acumulacio_provincia = ?, codi_acumulacio_ca = ?, codi_acumulacio_nacional = ? WHERE candidatura_id = ?";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setString(1, candidatures.getCodi_candidatura());
            preparedStmt.setString(2, candidatures.getNom_curt());
            preparedStmt.setString(3, candidatures.getNom_llarg());
            preparedStmt.setString(4, candidatures.getCodi_acumulacio_provincia());
            preparedStmt.setString(5, candidatures.getCodi_acumulacio_ca());
            preparedStmt.setString(6, candidatures.getcodi_acumulacio_nacional());
            preparedStmt.setInt(7, id);
            preparedStmt.execute();

            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM candidatures WHERE candidatura_id = ?";

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
        String query = "SELECT * FROM candidatures WHERE candidatura_id = ?";
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
        String query = "SELECT COUNT(*) FROM candidatures";

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
    public List<Candidatura> all() {
        String query = "SELECT * FROM candidatures";
        List<Candidatura> camps = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()){
                Candidatura c = new Candidatura();
                c.setCandidatura_id(rs.getInt("candidatura_id"));
                c.setEleccio_id(rs.getInt("eleccio_id"));
                c.setCodi_candidatura(rs.getString("codi_candidatura"));
                c.setNom_curt(rs.getString("nom_curt"));
                c.setNom_llarg(rs.getString("nom_llarg"));
                c.setCodi_acumulacio_provincia(rs.getString("codi_acumulacio_provincia"));
                c.setCodi_acumulacio_ca(rs.getString("codi_acumulacio_ca"));
                c.setcodi_acumulacio_nacional(rs.getString("codi_acumulacio_nacional"));
                camps.add(c);
            }

            return camps;
        }catch (Exception e){
            System.out.println(e);
            return camps;
        }
    }
}
