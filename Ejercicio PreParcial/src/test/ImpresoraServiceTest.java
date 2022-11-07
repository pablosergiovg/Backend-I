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
        Impresora impresora2 = new Impresora("EPSON", "315", "Blanca");
        Impresora impresora3 = new Impresora("HP", "200", "Gris");

        impresoraService.registrarImpresora(impresora1);
        impresoraService.registrarImpresora(impresora2);
        impresoraService.registrarImpresora(impresora3);

        //String respuestaEsperada = "id: 1, nombre: HP, marca: 315, color: Negro";
        //String respuestaEsperada = "id: 2, nombre: EPSON, marca: 315, color: Blanca";
        String respuestaEsperada = "id: 3, nombre: HP, marca: 200, color: Gris";

        //cuando
        //impresoraService.buscarImpresora(impresora1.getId());
        //impresoraService.buscarImpresora(impresora2.getId());
        impresoraService.buscarImpresora(impresora3.getId());

        //entonces
        Assertions.assertEquals(respuestaEsperada, impresoraService.buscarImpresora(3).toString());

    }

}
