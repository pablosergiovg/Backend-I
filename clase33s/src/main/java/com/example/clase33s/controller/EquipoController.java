package com.example.clase33s.controller;


import com.example.clase33s.entity.Equipo;
import com.example.clase33s.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    private EquipoService equipoService;

    @Autowired
    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @PostMapping
    public ResponseEntity<Equipo> crearEquipo(@RequestBody Equipo equipo){
        return ResponseEntity.ok(equipoService.registrarEquipo(equipo));
    }

    @GetMapping
    public ResponseEntity<List<Equipo>> listarEquipos(){
        return ResponseEntity.ok(equipoService.listarEquipos());
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Equipo> buscarEquipoPorNombre(@PathVariable String nombre){
        Optional<Equipo> equipoBuscado=equipoService.buscarEquipoPorNombre(nombre);
        if(equipoBuscado.isPresent()){
            return ResponseEntity.ok(equipoBuscado.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping("/mayores/{copas}")
    public ResponseEntity<List<Equipo>> buscarEquipoPor(@PathVariable Integer copas){
        return ResponseEntity.ok(equipoService.buscarEquiposMasCopasQue(copas));
    }

    @PutMapping
    public ResponseEntity<String> actualizarEquipo(@RequestBody Equipo equipo){
        if(equipoService.buscarEquipo(equipo.getId()) != null){
            equipoService.actualizarEquipo(equipo);
            return ResponseEntity.ok("Se ha actualizado el equipo con id: " + equipo.getId());
        }else{
            return ResponseEntity.badRequest().body("No se ha podido actualizar el equipo.");
        }
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarEquipo(@RequestBody Equipo equipo){
        String nombreEquipo = equipo.getNombre();
        if(equipoService.buscarEquipo(equipo.getId()) != null){
            equipoService.eliminarEquipo(equipo);
            return ResponseEntity.ok("Se ha eliminado el equipo : " + nombreEquipo);
        }else{
            return ResponseEntity.badRequest().body("No se ha podido eliminar el equipo.");
        }
    }

}
