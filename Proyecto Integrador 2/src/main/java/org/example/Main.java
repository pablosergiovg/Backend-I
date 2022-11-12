package org.example;

import dao.BD;
import model.Domicilio;
import model.Odontologo;
import model.Paciente;
import service.OdontologoService;
import service.PacienteService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        OdontologoService odontologoService = new OdontologoService();
        PacienteService pacienteService = new PacienteService();
        BD.crearTablas();
        Odontologo odontologo1 = new Odontologo(123,"Pablo", "Viera");
        Odontologo odontologo2 = new Odontologo(124,"Sergio", "Gil");

        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);

        Domicilio domicilio1 = new Domicilio("Uruguay", 23254, "Montevideo", "Montevideo");
        Domicilio domicilio2 = new Domicilio("Brasil", 47643, "Montevideo", "Montevideo");
        Paciente paciente1 = new Paciente("Mejias", "Daniela", "1234", LocalDate.of(2020,03,23), domicilio1);
        Paciente paciente2 = new Paciente("De Nobrega", "Gabriela", "5753", LocalDate.of(2021,05,13), domicilio1);

        pacienteService.guardarPaciente(paciente1);
        pacienteService.guardarPaciente(paciente2);

        System.out.println(odontologoService.buscarTodosOdontologos());
        System.out.println(pacienteService.buscarPaciente(2));
    }
}