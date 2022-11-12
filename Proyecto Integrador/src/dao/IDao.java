package dao;

import model.Paciente;

import java.util.List;

public interface IDao<T>{

    T guardar(T t);
    T buscar(Integer id);
    void actualizar(T t);
    //usas el t.getId()
    void eliminar(Integer id);
    List<T> buscarTodo();

}
