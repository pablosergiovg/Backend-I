package com.example.sIntegradorV1.service;
import com.example.sIntegradorV1.dto.TurnoDTO;
import com.example.sIntegradorV1.exception.BadRequestException;
import com.example.sIntegradorV1.exception.ResourceNotFoundException;
import com.example.sIntegradorV1.model.Odontologo;
import com.example.sIntegradorV1.model.Paciente;
import com.example.sIntegradorV1.model.Turno;
import com.example.sIntegradorV1.repository.TurnoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private TurnoRepository turnoRepository;

    private static final Logger LOGGER = Logger.getLogger(TurnoService.class);


    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }


    public TurnoDTO registrarTurno (TurnoDTO turnoDTO){
        LOGGER.info("Se ha iniciado el registro de un turno");
        Turno turnoAGuardar=turnoDTOaTurno(turnoDTO);
        Turno turnoGuardado=turnoRepository.save(turnoAGuardar);
        return turnoATurnoDTO(turnoGuardado);
    }


    public Optional<TurnoDTO> buscarTurno(Long id){
        Optional<Turno> turnoBuscado = turnoRepository.findById(id);
        if (turnoBuscado.isPresent()){
            LOGGER.info("Se ha iniciado la busqueda del turno con id: " + id);
            return Optional.of(turnoATurnoDTO(turnoBuscado.get()));
        }else{
            return Optional.empty();
        }
    }


    public void eliminarTurno(Long id) throws ResourceNotFoundException {
        Optional<TurnoDTO> turnoAEliminar = buscarTurno(id);
        if(turnoAEliminar.isPresent()){
            LOGGER.info("Se ha iniciado la eliminación del turno con id: " + id);
            turnoRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No se ha podido eliminar el turno.");
        }
    }


    public void actualizarTurno(TurnoDTO turnoDTO){
        LOGGER.info("Se ha iniciado la actualización de un turno");
        Turno turnoAActualizar = turnoDTOaTurno(turnoDTO);
        turnoRepository.save(turnoAActualizar);
    }


    public List<TurnoDTO> buscarTodosTurno(){
        LOGGER.info("Se ha iniciado la busqueda de todos los turnos");
        List<Turno>turnosEncontrados=turnoRepository.findAll();
        List<TurnoDTO> turnosDTO = new ArrayList<>();
        for (Turno t:turnosEncontrados) {
            turnosDTO.add(turnoATurnoDTO(t));
        }
        return turnosDTO;
    }


    private TurnoDTO turnoATurnoDTO(Turno turno){
        //convertir ese turno en un turno DTO
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setId(turno.getId());
        turnoDTO.setFecha(turno.getFecha());
        turnoDTO.setOdontologoId(turno.getOdontologo().getId());
        turnoDTO.setPacienteId(turno.getPaciente().getId());
        return turnoDTO;
    }


    private Turno turnoDTOaTurno(TurnoDTO turnoDTO){
        Turno turno = new Turno();
        Paciente paciente = new Paciente();
        Odontologo odontologo= new Odontologo();
        //cargar los elementos
        paciente.setId(turnoDTO.getPacienteId());
        odontologo.setId(turnoDTO.getOdontologoId());
        turno.setId(turnoDTO.getId());
        turno.setFecha(turnoDTO.getFecha());
        //asociar cada elemento
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        //salida
        return turno;
    }


}
