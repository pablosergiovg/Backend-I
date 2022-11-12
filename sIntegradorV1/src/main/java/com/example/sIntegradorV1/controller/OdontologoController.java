package com.example.sIntegradorV1.controller;

import com.example.sIntegradorV1.model.Odontologo;
import com.example.sIntegradorV1.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/odontologo")
public class OdontologoController {

    private OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public String buscarOdontologoPorID(Model model, @RequestParam("ID") Integer id){
        Odontologo odontologoBuscado = odontologoService.buscarOdontologo(id);
        model.addAttribute("nombre", odontologoBuscado.getNombre());
        model.addAttribute("apellido", odontologoBuscado.getApellido());
        model.addAttribute("matricula", odontologoBuscado.getMatricula());
        return "busOdontologo";
    }

}