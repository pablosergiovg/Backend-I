package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class VacunatorioTest {
    @Test
    public void casoCorrecto(){
        //dado
        VacunatorioProxy vacunatorioProxy= new VacunatorioProxy();
        Persona juan= new Persona("Perez","Juan","74885141", "Pfizer",new Date(2022-1900,10-1,05));
        System.out.println("Fecha de Juan: "+juan.getFechaAsignada());
        String respEsperada="Verificación correcta. Se ha registrado el DNI:" +
                "74885141 como persona vacunada con Pfizer";
        //cuando
        String respActual=vacunatorioProxy.vacunar(juan);
        //entonces
        Assertions.assertEquals(respEsperada,respActual);
    }
}
