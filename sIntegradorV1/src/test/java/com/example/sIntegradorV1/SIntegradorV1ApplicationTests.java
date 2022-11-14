package com.example.sIntegradorV1;

import com.example.sIntegradorV1.dao.BD;
import com.example.sIntegradorV1.model.Domicilio;
import com.example.sIntegradorV1.model.Odontologo;
import com.example.sIntegradorV1.model.Paciente;
import com.example.sIntegradorV1.service.OdontologoService;
import com.example.sIntegradorV1.service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class SIntegradorV1ApplicationTests {

	@Test
	public void listarOdontologosTest(){

		OdontologoService odontologoService = new OdontologoService();
		BD.crearTablas();
		List<Odontologo> listaEncontrada = odontologoService.buscarTodosOdontologos();
		Assertions.assertEquals(1,listaEncontrada.size());

	}

	@Test
	void contextLoads() {
	}

}
