package com.example.entrenador.service.model;

import com.example.entrenador.model.Entrenador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EntrenadorServiceImpl implements EntrenadorService{

    @Override
    public List<Entrenador> listarEntrenadores() {
        return Arrays.asList(
                new Entrenador("Pablo"),
                new Entrenador("Sergio")
        );
    }
}
