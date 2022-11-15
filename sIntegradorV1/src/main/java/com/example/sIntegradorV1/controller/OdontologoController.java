package com.example.sIntegradorV1.controller;

import com.example.sIntegradorV1.model.Odontologo;
import com.example.sIntegradorV1.model.Paciente;
import com.example.sIntegradorV1.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    private OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    /*
    @GetMapping
    public String buscarOdontologoPorID(Model model, @RequestParam("ID") Integer id){
        Odontologo odontologoBuscado = odontologoService.buscarOdontologo(id);
        model.addAttribute("nombre", odontologoBuscado.getNombre());
        model.addAttribute("apellido", odontologoBuscado.getApellido());
        model.addAttribute("matricula", odontologoBuscado.getMatricula());
        return "busOdontologo";
    }*/

    @GetMapping("/{id}")
    public Odontologo buscarOdontologo(@PathVariable("id") Integer id) {
        return odontologoService.buscarOdontologo(id);
    }

    @PostMapping
    public Odontologo registrarNuevoOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardarOdontologo(odontologo);
    }

    @PutMapping
    public String actualizarOdontologo(@RequestBody Odontologo odontologo){
        Odontologo odontologoBuscado = odontologoService.buscarOdontologo(odontologo.getId());
        if(odontologoBuscado != null){
            odontologoService.actualizarOdontologo(odontologo);
            return "Se actualizó el odontologo con apellido: " + odontologo.getApellido();
        }else{
            return "El odontologo con id: " + odontologo.getId() + " no existe en la base de datos.";
        }
    }

    @DeleteMapping("/{id}")
    public String eliminarOdontologo(@PathVariable("id") Integer id){
        Odontologo odontologoBuscado = odontologoService.buscarOdontologo(id);
        if(odontologoBuscado != null) {
            odontologoService.eliminarOdontologo(id);
            return "Se ha eliminado el odontologo con el id: " + id;
        }else{
            return "El odontologo con id: " + id + " no existe en la base de datos.";
        }
    }
    @GetMapping()
    public List<Odontologo> listarOdontologos(){
        List<Odontologo> odontologoList = new ArrayList<>();
        odontologoList = odontologoService.buscarTodosOdontologos();
        if(odontologoList != null){
            return odontologoList;
        }
        return odontologoList;

    }

}
