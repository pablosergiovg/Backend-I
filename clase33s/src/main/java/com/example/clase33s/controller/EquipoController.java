package com.example.clase33s.controller;


import com.example.clase33s.entity.Equipo;
import com.example.clase33s.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class EquipoController {

    private EquipoService profesorService;

    @Autowired
    public EquipoController(EquipoService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public ResponseEntity<List<Equipo>> listarProfesores(){
        return ResponseEntity.ok(profesorService.listarProfesores());
    }

}
