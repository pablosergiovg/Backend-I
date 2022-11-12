package service;

import dao.IDao;
import dao.OdontologoDAOH2;
import model.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService() {
        odontologoIDao = new OdontologoDAOH2();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> buscarTodosOdontologos(){
        return odontologoIDao.buscarTodo();
    }

}
