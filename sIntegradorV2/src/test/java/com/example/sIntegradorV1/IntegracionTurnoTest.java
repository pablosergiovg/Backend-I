package com.example.sIntegradorV1;

import com.example.sIntegradorV1.dto.TurnoDTO;
import com.example.sIntegradorV1.model.Domicilio;
import com.example.sIntegradorV1.model.Odontologo;
import com.example.sIntegradorV1.model.Paciente;
import com.example.sIntegradorV1.service.OdontologoService;
import com.example.sIntegradorV1.service.PacienteService;
import com.example.sIntegradorV1.service.TurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionTurnoTest {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private MockMvc mockMvc;

    public void cargarTurnoInicial(){
        Domicilio domicilio = new Domicilio("Varela", 32, "Salto", "Salto");
        Paciente paciente = new Paciente("Viera", "Pablo", "23423",
                LocalDate.of(2022,11,28), "pablo@gmail.com", domicilio);
        Paciente pacienteGuardado = pacienteService.registrarPaciente(paciente);
        Odontologo odontologo = new Odontologo(1234, "Peter", "Sech");
        Odontologo odontologoGuardado = odontologoService.registrarOdontologo(odontologo);
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setFecha(LocalDate.of(2022,12,12));
        turnoDTO.setPacienteId(pacienteGuardado.getId());
        turnoDTO.setOdontologoId(odontologoGuardado.getId());
        turnoService.registrarTurno(turnoDTO);
    }

    @Test
    public void listadoTurnoTest()throws Exception{
        cargarTurnoInicial();
        MvcResult respuesta = mockMvc.perform(MockMvcRequestBuilders.get("/turno").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertFalse(respuesta.getResponse().getContentAsString().isEmpty());
    }
}
