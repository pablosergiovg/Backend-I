package daos;

import entidades.Avion;

import java.util.List;

public interface IDAO<T> {

    public Avion registrar(T t);
    public Avion buscar(Long id);
    public void eliminar(Long id);
    public List<T> buscarTodos();

}
