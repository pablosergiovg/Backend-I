package presencial.dao;

public interface IDao<T> {
   T guardar(T t);

   T buscar(Integer id);

}
