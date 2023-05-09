package Objectes.Candidats;

import CRUD.CRUD;
import ConnectionDB.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CandidatsDAO extends ConnectionDB implements CRUD<Candidats> {
    @Override
    public boolean create(Candidats candidats){
        String query = " INSERT INTO candidats (candidatura_id,persona_id,provincia_id,num_ordre,tipus)"
                + " values (?, ?, ?, ?, ?)";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, candidats.getCandidatura_id());
            preparedStmt.setInt(2, candidats.getPersona_id());
            preparedStmt.setInt(3, candidats.getProvincia_id());
            preparedStmt.setInt(4, candidats.getNum_ordre());
            preparedStmt.setString(5, candidats.getTipus());
            preparedStmt.execute();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Candidats read(int id) {
        String query = "SELECT * FROM candidats WHERE id = ?";
        Candidats c = null;
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                c.setCandidatura_id(rs.getInt("candidatura_id"));
                c.setPersona_id(rs.getInt("persona_id"));
                c.setProvincia_id(rs.getInt("provincia_id"));
                c.setNum_ordre(rs.getInt("num_ordre"));
                c.setTipus(rs.getString("tipus"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }

    @Override
    public boolean update(Candidats candidats, int id) {
        String query = "UPDATE candidats SET candidatura_id = ?, persona_id = ?, provincia_id = ?," +
                "num_ordre = ?, tipus = ? WHERE id = ?";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, candidats.getCandidatura_id());
            preparedStmt.setInt(2, candidats.getPersona_id());
            preparedStmt.setInt(3, candidats.getProvincia_id());
            preparedStmt.setInt(4, candidats.getNum_ordre());
            preparedStmt.setString(5, candidats.getTipus());
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
        String query = "DELETE FROM candidats WHERE id = ?";

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
}
