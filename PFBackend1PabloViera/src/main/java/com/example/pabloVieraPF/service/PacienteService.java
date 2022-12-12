package com.example.pabloVieraPF.service;
import com.example.pabloVieraPF.exception.ResourceNotFoundException;
import com.example.pabloVieraPF.model.Paciente;
import com.example.pabloVieraPF.repository.PacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    private static final Logger LOGGER = Logger.getLogger(PacienteService.class);

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente registrarPaciente(Paciente paciente){
        LOGGER.info("Se ha iniciado el registro de un Paciente");
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscarPaciente(Long id){
        LOGGER.info("Se ha iniciado la busqueda del Paciente con id: " + id);
        return pacienteRepository.findById(id);
    }

    public void actualizarPaciente(Paciente paciente){
        LOGGER.info("Se ha iniciado la actualización de un Paciente");
        pacienteRepository.save(paciente);
    }

    public void eliminarPaciente(Long id) throws ResourceNotFoundException{
        Optional<Paciente> pacienteAEliminar = buscarPaciente(id);
        if(pacienteAEliminar.isPresent()){
            LOGGER.info("Se ha iniciado la eliminación del Paciente con id: " + id);
            pacienteRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("El paciente con id: " + id + " no existe en la base de datos");
        }
    }

    public List<Paciente> buscarTodosPacientes(){
        LOGGER.info("Se ha iniciado la busqueda de todos los Pacientes");
        return pacienteRepository.findAll();
    }

}
