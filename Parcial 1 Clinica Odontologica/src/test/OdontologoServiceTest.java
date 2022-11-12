package test;

import dao.BD;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

public class OdontologoServiceTest {

    @Test
    public void listarOdontologostTest(){

        //DADO
        OdontologoService odontologoService = new OdontologoService();
        BD.crearTabla();
        Odontologo odontologo1 = new Odontologo(123, "Ricardo", "Quaresma");
        Odontologo odontologo2 = new Odontologo(124, "Ronaldinho", "Gaucho");
        Odontologo odontologo3 = new Odontologo(125, "Messi", "Sabe");
        Odontologo odontologo4 = new Odontologo(126, "Juan", "Guerra");

        odontologoService.registrarOdontologo(odontologo1);
        odontologoService.registrarOdontologo(odontologo2);
        odontologoService.registrarOdontologo(odontologo3);
        odontologoService.registrarOdontologo(odontologo4);

        String respuestaEsperada = "[id: 1,Matricula: 123,Nombre: Ricardo,Apellido: Quaresma, id: 2,Matricula: 124,Nombre: Ronaldinho,Apellido: Gaucho, id: 3,Matricula: 125,Nombre: Messi,Apellido: Sabe, id: 4,Matricula: 126,Nombre: Juan,Apellido: Guerra]";

        //CUANDO
        //ENTONCES
        Assertions.assertEquals(respuestaEsperada, odontologoService.listarOdontologos().toString());

    }

}
