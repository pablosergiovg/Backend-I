package com.example.sIntegradorV1.Service;


import com.example.sIntegradorV1.exception.ResourceNotFoundException;
import com.example.sIntegradorV1.model.Odontologo;
import com.example.sIntegradorV1.service.OdontologoService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    public void guardarOdontologoTest(){
        Odontologo odontologoAGuardar = new Odontologo(1234, "Peter", "Sech");
        Odontologo odontologoGuardado = odontologoService.registrarOdontologo(odontologoAGuardar);
        assertEquals(1L, odontologoGuardado.getId());
    }

    @Test
    @Order(2)
    public void buscarOdontologoPorIdTest(){
        Long idABuscar = 1L;
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologo(idABuscar);
        assertNotNull(odontologoBuscado.get());
    }

    @Test
    @Order(3)
    public void buscarOdontologosTest(){
        List<Odontologo> odontologos = odontologoService.buscarTodosOdontologos();
        Integer cantidadEsperada = 1;
        assertEquals(cantidadEsperada, odontologos.size());
    }

    @Test
    @Order(4)
    public void actualizarOdontologoTest(){
        Odontologo odontologoAActualizar = new Odontologo(1L, 1235, "Fredegundo", "De Los Altos");
        odontologoService.actualizarOdontologo(odontologoAActualizar);
        Optional<Odontologo> odontologoActualizado = odontologoService.buscarOdontologo(odontologoAActualizar.getId());
        assertEquals("Fredegundo", odontologoActualizado.get().getNombre());
    }

    @Test
    @Order(5)
    public void eliminarOdontologoTest() throws ResourceNotFoundException {
        Long idAEliminar = 1L;
        odontologoService.eliminarOdontologo(idAEliminar);
        Optional<Odontologo> odontologoEliminado = odontologoService.buscarOdontologo(idAEliminar);
        assertFalse(odontologoEliminado.isPresent());
    }

}
