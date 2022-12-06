package com.example.clase33s.service;

import com.example.clase33s.entity.Equipo;
import com.example.clase33s.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    private EquipoRepository profesorRepository;

    @Autowired
    public EquipoService(EquipoRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public Equipo registrarProfesor(Equipo profesor){
        return profesorRepository.save(profesor);
    }

    public List<Equipo> listarProfesores(){
        return profesorRepository.findAll();
    }

}
