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

    public Odontologo registrarOdontologo(Odontologo odontologo){
        return odontologoIDao.registrar(odontologo);
    }

    public List<Odontologo> listarOdontologos(){
        return odontologoIDao.listar();
    }

}
