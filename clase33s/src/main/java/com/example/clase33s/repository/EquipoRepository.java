package com.example.clase33s.repository;

import com.example.clase33s.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    //agregar un equipo mediante un .save
    //agregar un jugador al equipo???
    //al guardar un equipo se guarda con sus jugadores.

    @Query("SELECT e FROM Equipo e WHERE e.nombre =?1")
    Optional<Equipo> buscarEquipo(String nombre);


    List<Equipo> findByCantidadCopasGreaterThan(Integer copas);

}
