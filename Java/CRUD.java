package CRUD;

import Objectes.Candidats.Candidats;

import java.util.List;

public interface CRUD<T> {
    // CRUD
    boolean create(T t);
    List<T> read(int id);
    boolean update(T t, int id);
    boolean delete(int id);

    //Opcionals
    boolean exists(int id);
    boolean count();

    List<T> all();

}
