package com.example.ormC31.service;

import com.example.ormC31.entity.Movimiento;
import com.example.ormC31.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {

    private MovimientoRepository movimientoRepository;

    @Autowired
    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    public List<Movimiento> obtenerListaMovimientos(){
        return movimientoRepository.findAll();
    }

    public Movimiento registrarMovimiento(Movimiento movimiento){
        return movimientoRepository.save(movimiento);
        //El .save se utiliza tanto para guardar como para actualizar.
    }

    //Opcion 1.
    public Optional<Movimiento> buscarMovimiento(Integer id){
        return movimientoRepository.findById(id);
    }

    /*
    Opcion 2(no recomendada).
    public Movimiento buscarMovimiento(Integer id){
        return movimientoRepository.findById(id).get;
    }*/

}
