package mesas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FiguraTest {
    @Test
    public void calcularAreaCuadrado(){
        //DADO
        Figura figuraDePrueba= new Cuadrado(5.0);
        String respEsperada="El área del cuadrado es de 25.0 unidades";
        //CUANDO
        String area= figuraDePrueba.calcularArea();
        //ENTONCES
        Assertions.assertEquals(respEsperada,area);
    }
    @Test
    public void calcularAreaCirculo(){
        //DADO
        Figura figuraDePrueba= new Circulo(10.0);
        String respEsperada="El área del círculo es de 314.1592653589793 unidades";
        //CUANDO
        String area= figuraDePrueba.calcularArea();
        //ENTONCES
        Assertions.assertEquals(respEsperada,area);
    }
}
