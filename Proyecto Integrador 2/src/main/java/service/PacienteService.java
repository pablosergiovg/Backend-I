package service;

import dao.IDao;
import dao.PacienteDAOH2;
import model.Paciente;

import java.util.List;

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

}
