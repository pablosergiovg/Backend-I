package com.example.clase33s.controller;

import com.example.clase33s.entity.Equipo;
import com.example.clase33s.entity.Jugador;
import com.example.clase33s.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    private JugadorService jugadorService;

    @Autowired
    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @PostMapping
    public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador jugador){
        return ResponseEntity.ok(jugadorService.registrarJugador(jugador));
    }

    @GetMapping
    public ResponseEntity<List<Jugador>> listarJugadores(){
        return ResponseEntity.ok(jugadorService.listarJugadores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> buscarJugadorPorId(@PathVariable Long id){
        return ResponseEntity.ok(jugadorService.buscarJugador(id));
    }

    @PutMapping
    public ResponseEntity<String> actualizarJugador(@RequestBody Jugador jugador){
        if(jugadorService.buscarJugador(jugador.getId()) != null){
            jugadorService.actualizarJugador(jugador);
            return ResponseEntity.ok("Se ha actualizado el Jugador con id: " + jugador.getId());
        }else{
            return ResponseEntity.badRequest().body("No se ha podido actualizar el Jugador.");
        }
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarJugador(@RequestBody Jugador jugador){
        String nombreJugador = jugador.getNombre();
        if(jugadorService.buscarJugador(jugador.getId()) != null){
            jugadorService.eliminarJugador(jugador);
            return ResponseEntity.ok("Se ha eliminado el Jugador : " + nombreJugador);
        }else{
            return ResponseEntity.badRequest().body("No se ha podido eliminar el Jugador.");
        }
    }


}
