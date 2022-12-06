package com.example.sIntegradorV1.service;
import com.example.sIntegradorV1.exception.ResourceNotFoundException;
import com.example.sIntegradorV1.model.Odontologo;
import com.example.sIntegradorV1.model.Paciente;
import com.example.sIntegradorV1.repository.OdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private OdontologoRepository odontologoRepository;

    private static final Logger LOGGER = Logger.getLogger(OdontologoService.class);

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo){
        LOGGER.info("Se ha iniciado el registro de un Odontologo");
        return odontologoRepository.save(odontologo);
    }

    public Optional<Odontologo> buscarOdontologo(Long id){
        LOGGER.info("Se ha iniciado la busqueda del Odontologo con id: " + id);
        return odontologoRepository.findById(id);
    }

    public void actualizarOdontologo(Odontologo odontologo){
        LOGGER.info("Se ha iniciado la actualización de un Odontologo");
        odontologoRepository.save(odontologo);
    }

    public void eliminarOdontologo(Long id) throws ResourceNotFoundException{
        //Eliminar se encargara de emitir la exception
        Optional<Odontologo> odontologoAEliminar = buscarOdontologo(id);
        if(odontologoAEliminar.isPresent()){
            LOGGER.info("Se ha iniciado la eliminación del Odontologo con id: " + id);
            odontologoRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("El odontologo con id: " + id + " no existe en la base de datos");
        }
    }

    public List<Odontologo> buscarTodosOdontologos(){
        LOGGER.info("Se ha iniciado la busqueda de todos los Odontologos");
        return odontologoRepository.findAll();
    }

}
