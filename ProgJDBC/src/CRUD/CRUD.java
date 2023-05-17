package CRUD;


import java.util.List;

public interface CRUD<T> {
    // CRUD
    boolean create(T t);
    List<T> read(int id);
    boolean update(String a,String b, int id);
    boolean delete(int id);

    //Opcionals
    boolean exists(int id);
    int count();

    List<T> all();

}
