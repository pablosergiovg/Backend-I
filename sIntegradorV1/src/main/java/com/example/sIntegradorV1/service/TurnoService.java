package com.example.sIntegradorV1.service;

import com.example.sIntegradorV1.dao.IDao;
import com.example.sIntegradorV1.dao.TurnoDAOLista;
import com.example.sIntegradorV1.model.Paciente;
import com.example.sIntegradorV1.model.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    private IDao<Turno> turnoDAOLista;

    public TurnoService(){
        turnoDAOLista = new TurnoDAOLista();
    }

    public Turno guardarTurno(Turno turno){
        return turnoDAOLista.guardar(turno);
    }

    public Turno buscarTurno(Integer id){
        return turnoDAOLista.buscar(id);
    }

    public void actualizarTurno(Turno turno){
        turnoDAOLista.actualizar(turno);
    }

    public void eliminarTurno(Integer id){
        turnoDAOLista.eliminar(id);
    }

    public List<Turno> buscarTodosTurnos(){
        return turnoDAOLista.buscarTodo();
    }

}
