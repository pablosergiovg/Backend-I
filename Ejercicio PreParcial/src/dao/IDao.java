package dao;

public interface IDao<T>{

    T registrar(T t);
    void eliminar(Integer id);
    T buscar(Integer id);

}
