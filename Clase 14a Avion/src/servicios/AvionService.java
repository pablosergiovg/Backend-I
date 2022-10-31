package servicios;
import daos.IDAO;
import entidades.Avion;

import java.util.List;

public class AvionService {

    private IDAO avionDao;

    public AvionService(){
    }

    public void setAvionDao(IDAO avionDao) {
        this.avionDao = avionDao;
    }

    public Avion registrarAvion(Avion avion){
        //pasando responsabilidad de guardar al DAO.
        return avionDao.registrar(avion);
    }

    public Avion buscarAvion(Long id){
        //pasando responsabilidad de guardar al DAO.
        return avionDao.buscar(id);
    }

    public void eliminarAvion(Long id){
        //pasando responsabilidad de guardar al DAO.
        avionDao.eliminar(id);
    }

    public List<Avion> buscarTodos(){
        //pasando responsabilidad de guardar al DAO.
        return avionDao.buscarTodos();
    }


}
