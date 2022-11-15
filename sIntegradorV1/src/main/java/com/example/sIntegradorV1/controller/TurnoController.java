package com.example.sIntegradorV1.controller;


import com.example.sIntegradorV1.model.Turno;
import com.example.sIntegradorV1.service.OdontologoService;
import com.example.sIntegradorV1.service.PacienteService;
import com.example.sIntegradorV1.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService){
        this.turnoService = turnoService;
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        PacienteService pacienteService = new PacienteService();
        OdontologoService odontologoService = new OdontologoService();
        ResponseEntity<Turno> respuesta;

        if(pacienteService.buscarPaciente(turno.getPaciente().getId()) != null && odontologoService.buscarOdontologo(turno.getOdontologo().getId()) != null){
            //ambos existen en la BD
            //podemos registrar el turno sin problemas, indicamos ok (200)
            respuesta = ResponseEntity.ok(turnoService.guardarTurno(turno));
        }else{
            //uno o ambos no existen, deben bloquear la operacion
            respuesta = ResponseEntity.badRequest().build();
            //alternativa para seleccionar cualquie codigo.
            //respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable("id") Integer id){
        Turno turnoEsperado = turnoService.buscarTurno(id);
        if(turnoEsperado != null){
            return ResponseEntity.ok(turnoEsperado);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos(){
        return ResponseEntity.ok(turnoService.buscarTodosTurnos());
    }

    @PutMapping
    public ResponseEntity<String> actualizarTurno(@RequestBody Turno turno){
        if(turnoService.buscarTurno(turno.getId()) != null){
            turnoService.actualizarTurno(turno);
            return ResponseEntity.ok("Se ha actualizado el turno con id: " + turno.getId());
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable("id") Integer id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("EL turno con el id: " + id + " se ha eliminado.");
    }


}
