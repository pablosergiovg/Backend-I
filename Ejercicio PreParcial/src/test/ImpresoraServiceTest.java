package test;

import dao.BD;
import model.Impresora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.ImpresoraService;

public class ImpresoraServiceTest {

    @Test
    public void busquedaPorId(){

        //dado
        ImpresoraService impresoraService = new ImpresoraService();
        BD.crearTabla();
        Impresora impresora1 = new Impresora("HP", "315", "Negro");
        impresoraService.registrarImpresora(impresora1);
        String respuestaEsperada = "id: 1, nombre: HP, marca: 315, color: Negro";

        //cuando
        impresoraService.buscarImpresora(impresora1.getId());

        //entonces
        Assertions.assertEquals(respuestaEsperada, impresoraService.buscarImpresora(impresora1.getId()).toString());

    }

}
