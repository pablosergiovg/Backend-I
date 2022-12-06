package com.example.sIntegradorV1.Service;

import com.example.sIntegradorV1.dto.TurnoDTO;
import com.example.sIntegradorV1.exception.ResourceNotFoundException;
import com.example.sIntegradorV1.model.Domicilio;
import com.example.sIntegradorV1.model.Odontologo;
import com.example.sIntegradorV1.model.Paciente;
import com.example.sIntegradorV1.model.Turno;
import com.example.sIntegradorV1.service.OdontologoService;
import com.example.sIntegradorV1.service.PacienteService;
import com.example.sIntegradorV1.service.TurnoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class TurnoServiceTest {

    private TurnoService turnoService;
    private OdontologoService odontologoService;
    private PacienteService pacienteService;

    private Turno turno;

    @Autowired
    public TurnoServiceTest(TurnoService turnoService, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }

    @Test
    @Order(1)
    public void registrarTurnoTest(){
        Odontologo odontologoAGuardar = odontologoService.registrarOdontologo(new Odontologo(1234, "Gabriela", "De Nobrega"));
        Paciente pacienteAGuardar = pacienteService.registrarPaciente(new Paciente("Gil", "Sergio", "23423",
                LocalDate.of(2022,11,28), "pablo@gmail.com",
                new Domicilio("Varela", 323,"Salto", "Salto")));

        TurnoDTO turnoDTOARegistrar = turnoService.registrarTurno(new TurnoDTO(LocalDate.of(2022,12,2), 1L, 1L));
        assertEquals(1, turnoDTOARegistrar.getId());
    }

    @Test
    @Order(2)
    public void buscarTurnoPorIdTest(){
        Long idABuscar = 1L;
        Optional<TurnoDTO> turnoBuscado = turnoService.buscarTurno(idABuscar);
        assertNotNull(turnoBuscado.get());
    }

    @Test
    @Order(3)
    public void buscarTurnosTest(){
        List<TurnoDTO> turnos = turnoService.buscarTodosTurno();
        Integer cantidadEsperada = 1;
        assertEquals(cantidadEsperada,turnos.size());
    }

    @Test
    @Order(4)
    public void actualilzarTurnoTest(){
        Odontologo odontologoAGuardar = odontologoService.registrarOdontologo(new Odontologo(1234, "Gabriela", "De Nobrega"));
        Paciente pacienteAGuardar = pacienteService.registrarPaciente(new Paciente("Gil", "Sergio", "23423",
                LocalDate.of(2022,11,28), "pablo@gmail.com",
                new Domicilio("Varela", 323,"Salto", "Salto")));
        TurnoDTO turnoDTOAActualizar = turnoService.registrarTurno(new TurnoDTO(LocalDate.of(2022,12,2), 1L, 1L));
        turnoService.actualizarTurno(turnoDTOAActualizar);
        Optional<TurnoDTO> turnoAActualizado = turnoService.buscarTurno(turnoDTOAActualizar.getId());
        assertEquals(2L, turnoAActualizado.get().getId());
    }

    @Test
    @Order(5)
    public void aliminarTurnoTest() throws ResourceNotFoundException {
        Long idAEliminar = 1L;
        turnoService.eliminarTurno(idAEliminar);
        Optional<TurnoDTO> turnoEliminado = turnoService.buscarTurno(idAEliminar);
        assertFalse(turnoEliminado.isPresent());
    }


}
