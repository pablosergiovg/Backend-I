package com.example.clase33s.service;

import com.example.clase33s.entity.Equipo;
import com.example.clase33s.entity.Jugador;
import com.example.clase33s.repository.EquipoRepository;
import com.example.clase33s.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    private JugadorRepository jugadorRepository;

    @Autowired
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }


    public Jugador registrarJugador(Jugador jugador){
        return jugadorRepository.save(jugador);
    }

    public Jugador buscarJugador(Long id){
        return jugadorRepository.getReferenceById(id);
    }

    public List<Jugador> listarJugadores(){
        return jugadorRepository.findAll();
    }

    public String eliminarJugador(Jugador jugador){
        String nombreJugador = jugador.getNombre();
        jugadorRepository.delete(jugador);
        return "Se ha eliminado el Jugador: " + nombreJugador;
    }

    public String actualizarJugador(Jugador jugador){
        Long idJugador = jugador.getId();
        jugadorRepository.save(jugador);
        return "Se ha actualizado el Jugador con id: " + idJugador;
    }

}
