package com.example.entrenador.controller;

import com.example.entrenador.model.Entrenador;
import com.example.entrenador.service.model.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//@Controller cuando tenemos tecnologia de vista en nuestro proyecto
//@Controller
//@RestController cuando no tenemos tecnologia de vista, generalmente
// pensando en crear una API que va ser consumida por otra API o cliente
@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @Autowired
    public EntrenadorController(EntrenadorService entrenadorService){
        this.entrenadorService = entrenadorService;
    }

    @GetMapping
    public List<Entrenador> obtenerListaEntrenadores() {
        return entrenadorService.listarEntrenadores();
    }


}
