package presencial;

import presencial.dao.BD;
import presencial.model.Medicamento;
import presencial.service.MedicamentoService;

public class Cliente {
    public static void main(String[] args) {
        //necesitas el Service
        //necesitas crear las tablas
        //necesitas un medicamento para poder guardarlo con el service
        MedicamentoService medicamentoService= new MedicamentoService();
        BD.crearTablas();
        Medicamento medicamento= new Medicamento(1,"Paracetamol",
                "Pepito SRL",1500,200.0,987481);
        //pedirle al service que lo guarde
        medicamentoService.guardar(medicamento);

        System.out.println(medicamentoService.mostrarMedicamento(1));


    }
}
