package Candidatures;
import Connection.ConnectionDB;
import Interf.CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class candidaturesDAO extends ConnectionDB implements CRUD<candidatures> {
    @Override
    public boolean create(candidatures candidatures) {
        String query = " INSERT INTO candidatures (eleccio_id,codi_candidatura,nom_curt,nom_llarg,codi_acumulacio_provincia,codi_acumulacio_ca,codi_acumulario_nacional)"
                + " values (?, ?, ?, ?, ?)";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, candidatures.getEleccio_id());
            preparedStmt.setString(2, candidatures.getCodi_candidatura());
            preparedStmt.setString(3, candidatures.getNom_curt());
            preparedStmt.setString(4, candidatures.getNom_llarg());
            preparedStmt.setString(5, candidatures.getCodi_acumulacio_provincia());
            preparedStmt.setString(6, candidatures.getCodi_acumulacio_ca());
            preparedStmt.setString(7, candidatures.getCodi_acumulario_nacional());
            preparedStmt.execute();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public candidatures read(int id) {
        String query = "SELECT * FROM candidatures WHERE id = ?";
        candidatures c = null;
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                c.setEleccio_id(rs.getInt("eleccio_id"));
                c.setCodi_candidatura(rs.getString("codi_candidatura"));
                c.setNom_curt(rs.getString("nom_curt"));
                c.setNom_llarg(rs.getString("nom_llarg"));
                c.setCodi_acumulacio_provincia(rs.getString("codi_acumulacio_provincia"));
                c.setCodi_acumulacio_ca(rs.getString("codi_acumulacio_ca"));
                c.setCodi_acumulario_nacional(rs.getString("codi_acumulario_nacional"));
            }
            return c;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public boolean update(candidatures candidatures, int id) {
        String query = "UPDATE candidatures SET eleccio_id = ?, codi_candidatura = ?, nom_curt = ?," +
                "nom_llarg = ?, codi_acumulacio_provincia = ?, codi_acumulacio_ca = ?, codi_acumulario_nacional = ? WHERE id = ?";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, candidatures.getEleccio_id());
            preparedStmt.setString(2, candidatures.getCodi_candidatura());
            preparedStmt.setString(3, candidatures.getNom_curt());
            preparedStmt.setString(4, candidatures.getNom_llarg());
            preparedStmt.setString(5, candidatures.getCodi_acumulacio_provincia());
            preparedStmt.setString(6, candidatures.getCodi_acumulacio_ca());
            preparedStmt.setString(7, candidatures.getCodi_acumulario_nacional());
            preparedStmt.setInt(8, id);
            preparedStmt.execute();

            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM candidatures WHERE id = ?";

        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();

            if (rs.next()) return true;
            else return false;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean exists(int id) {
        String query = "SELECT * FROM candidatures WHERE candidatura_id = ?";
        candidatures c = null;
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
    public boolean count() {
        String query = "SELECT COUNT(*) FROM candidatures";

        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);

            ResultSet rs = preparedStmt.executeQuery();

            if (rs.next()) return true;
            else return false;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public List<candidatures> all() {
        String query = "SELECT * FROM candidatures";
        List<candidatures> camps = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()){
                candidatures c = null;
                c.setEleccio_id(rs.getInt("eleccio_id"));
                c.setCodi_candidatura(rs.getString("codi_candidatura"));
                c.setNom_curt(rs.getString("nom_curt"));
                c.setNom_llarg(rs.getString("nom_llarg"));
                c.setCodi_acumulacio_provincia(rs.getString("codi_acumulacio_provincia"));
                c.setCodi_acumulacio_ca(rs.getString("codi_acumulacio_ca"));
                c.setCodi_acumulario_nacional(rs.getString("codi_acumulario_nacional"));
                camps.add(c);
            }
            return camps;
        }catch (Exception e){
            System.out.println(e);
            return camps;
        }
    }
}
