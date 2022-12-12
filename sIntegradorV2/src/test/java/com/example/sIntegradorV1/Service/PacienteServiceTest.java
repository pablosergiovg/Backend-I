package com.example.sIntegradorV1.Service;
import com.example.sIntegradorV1.exception.ResourceNotFoundException;
import com.example.sIntegradorV1.model.Domicilio;
import com.example.sIntegradorV1.model.Paciente;
import com.example.sIntegradorV1.service.PacienteService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    public void guardarPacienteTest(){
        Paciente pacienteAGuardar = new Paciente("Viera", "Pablo", "23423",
                LocalDate.of(2022,11,28), "pablo@gmail.com",
                new Domicilio("Varela", 323,"Salto", "Salto"));
        Paciente pacienteGuardado = pacienteService.registrarPaciente(pacienteAGuardar);
        assertEquals(1L,pacienteGuardado.getId());
    }

    @Test
    @Order(2)
    public void buscarPacientePorIdTest(){
        Long idABuscar = 1L;
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(idABuscar);
        assertNotNull(pacienteBuscado.get());
    }
    @Test
    @Order(3)
    public void buscarPacientesTest(){
        List<Paciente> pacientes = pacienteService.buscarTodosPacientes();
        //por la cantidad de los pacientes
        Integer cantidadEsperada = 1;
        assertEquals(cantidadEsperada,pacientes.size());
    }
    @Test
    @Order(4)
    public void actualizarPacienteTest(){
        Paciente pacienteAActualizar = new Paciente(1L,"Gil", "Sergio", "23423",
                LocalDate.of(2022,11,28), "sergio@gmail.com",
                new Domicilio("Varela", 323,"Salto", "Salto"));
        pacienteService.actualizarPaciente(pacienteAActualizar);
        Optional<Paciente> pacienteActualizado = pacienteService.buscarPaciente(pacienteAActualizar.getId());
        assertEquals("Sergio",pacienteActualizado.get().getNombre());
    }
    @Test
    @Order(5)
    public void eliminarPacienteTest()throws ResourceNotFoundException {
        Long idAEliminar = 1L;
        pacienteService.eliminarPaciente(idAEliminar);
        Optional<Paciente> pacienteEliminado=pacienteService.buscarPaciente(idAEliminar);
        assertFalse(pacienteEliminado.isPresent());
    }

}