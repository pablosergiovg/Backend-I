package com.example.sIntegradorV1.controller;

import com.example.sIntegradorV1.model.Paciente;
import com.example.sIntegradorV1.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    private PacienteService pacienteService;
    @Autowired

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public String traerPacienteXEmail(Model model, @RequestParam("email") String email){
        Paciente pacienteBuscado = pacienteService.buscarPacientePorEmail(email);
        model.addAttribute("nombre", pacienteBuscado.getNombre());
        model.addAttribute("apellido", pacienteBuscado.getApellido());
        return "index";
    }

}
