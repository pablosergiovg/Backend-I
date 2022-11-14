package com.example.sIntegradorV1.controller;

import com.example.sIntegradorV1.model.Paciente;
import com.example.sIntegradorV1.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    /*
    @GetMapping
    public String traerPacienteXEmail(Model model, @RequestParam("email") String email){
        Paciente pacienteBuscado = pacienteService.buscarPacientePorEmail(email);
        model.addAttribute("nombre", pacienteBuscado.getNombre());
        model.addAttribute("apellido", pacienteBuscado.getApellido());
        return "index";
    }*/

    @PostMapping
    public Paciente registrarNuevoPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping
    public String actualizarPaciente(@RequestBody Paciente paciente){
        Paciente pacienteBuscado = pacienteService.buscarPaciente(paciente.getId());
        if(pacienteBuscado != null){
            pacienteService.actualizarPaciente(paciente);
            return "Se actualizó el paciente con apellido: " + paciente.getApellido();
        }else{
            return "El paciente con id: " + paciente.getId() + " no existe en la base de datos.";
        }

    }

    @DeleteMapping
    public String eliminarPaciente(@PathVariable("id") Integer id){
        Paciente pacienteBuscado = pacienteService.buscarPaciente(id);
        if(pacienteBuscado != null) {
            pacienteService.eliminarPaciente(id);
            return "Se ha eliminado el paciente con el id: " + id;
        }else{
            return "El paciente con id: " + id + " no existe en la base de datos.";
        }
    }

    @GetMapping("/{id}")
    public Paciente buscarPaciente(@PathVariable("id") Integer id){
        return pacienteService.buscarPaciente(id);
    }

    @GetMapping()
    public List<Paciente> listarPacientes(){
        List<Paciente> pacienteList = new ArrayList<>();
        pacienteList = pacienteService.buscarTodosPacientes();
        if(pacienteList != null){
            return pacienteList;
        }
        return pacienteList;

    }





}
