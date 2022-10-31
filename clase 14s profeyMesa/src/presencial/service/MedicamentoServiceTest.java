package presencial.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import presencial.dao.BD;
import presencial.model.Medicamento;

public class MedicamentoServiceTest {
    @Test
    public void busquedaTest(){
        //dado
        MedicamentoService medicamentoService= new MedicamentoService();
        BD.crearTablas();
        Medicamento medicamento= new Medicamento(1,"Paracetamol", "Pepito SRL",1500,200.0,987481);
        String respuestaEsperada = "1, Paracetamol, Pepito SRL, 1500, 200.0, 987481";

        //cuando
        medicamentoService.guardar(medicamento);

        //entonces
        Assertions.assertEquals(respuestaEsperada, medicamentoService.mostrarMedicamento(1).toString());

    }
}
