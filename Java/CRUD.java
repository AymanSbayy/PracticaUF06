package CRUD;

import Objectes.Candidats.Candidats;

public interface CRUD<T> {
    // CRUD
    boolean create(T t);
    T read(int id);
    boolean update(T t, int id);
    boolean delete(int id);

}
