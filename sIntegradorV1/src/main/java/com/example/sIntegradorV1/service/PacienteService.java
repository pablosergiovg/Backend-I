package com.example.sIntegradorV1.service;



import com.example.sIntegradorV1.dao.IDao;
import com.example.sIntegradorV1.dao.PacienteDAOH2;
import com.example.sIntegradorV1.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService() {
        this.pacienteIDao = new PacienteDAOH2();
    }

    public Paciente guardarPaciente(Paciente paciente){
        return pacienteIDao.guardar(paciente);
    }

    public Paciente buscarPaciente(Integer id){
        return pacienteIDao.buscar(id);
    }

    public void actualizarPaciente(Paciente paciente){
        pacienteIDao.actualizar(paciente);
    }

    public void eliminarPaciente(Integer id){
        pacienteIDao.eliminar(id);
    }

    public List<Paciente> buscarTodosPacientes(){
        return pacienteIDao.buscarTodo();
    }

    public Paciente buscarPacientePorEmail(String email){
        return pacienteIDao.buscarXString(email);
    }

}
