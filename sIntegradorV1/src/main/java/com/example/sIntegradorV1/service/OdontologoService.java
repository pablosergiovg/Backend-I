package com.example.sIntegradorV1.service;

import com.example.sIntegradorV1.dao.IDao;
import com.example.sIntegradorV1.dao.OdontologoDAOH2;
import com.example.sIntegradorV1.model.Odontologo;
import com.example.sIntegradorV1.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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

    public void eliminarOdontologo(Integer id){
        odontologoIDao.eliminar(id);
    }

    public void actualizarOdontologo(Odontologo odontologo){
        odontologoIDao.actualizar(odontologo);
    }

    public Odontologo buscarOdontologo(Integer id){
        return odontologoIDao.buscar(id);
    }

}
