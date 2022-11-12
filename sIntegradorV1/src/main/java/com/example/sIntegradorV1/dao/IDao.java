package com.example.sIntegradorV1.dao;

import java.util.List;

public interface IDao<T>{

    T guardar(T t);
    T buscar(Integer id);
    void actualizar(T t);
    //usas el t.getId()
    void eliminar(Integer id);
    List<T> buscarTodo();

    T buscarXString(String valor);

}
