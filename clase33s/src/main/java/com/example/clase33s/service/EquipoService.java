package com.example.clase33s.service;

import com.example.clase33s.entity.Equipo;
import com.example.clase33s.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    private EquipoRepository equipoRepository;

    @Autowired
    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public Equipo registrarEquipo(Equipo equipo){
        return equipoRepository.save(equipo);
    }

    public Equipo buscarEquipo(Long id){
        return equipoRepository.getReferenceById(id);
    }

    public Optional<Equipo> buscarEquipoPorNombre(String nombre){
        return equipoRepository.buscarEquipo(nombre);
    }

    public List<Equipo> buscarEquiposMasCopasQue(Integer copas){
        return equipoRepository.findByCantidadCopasGreaterThan(copas);
    }

    public List<Equipo> listarEquipos(){
        return equipoRepository.findAll();
    }

    public String eliminarEquipo(Equipo equipo){
        String nombreEquipo = equipo.getNombre();
        equipoRepository.delete(equipo);
        return "Se ha eliminado el equipo: " + nombreEquipo;
    }

    public String actualizarEquipo(Equipo equipo){
        Long idEquipo = equipo.getId();
        equipoRepository.save(equipo);
        return "Se ha actualizado el equipo con id: " + idEquipo;
    }


}
