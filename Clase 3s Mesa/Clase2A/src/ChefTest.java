import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChefTest {
    @Test
    public void casoUno() {
        //dado
        Menu menu = new MenuClasico(100.0);
        Chef chef = new ChefClasico();
        String esperado = "Se preparo un menu clasico y cuesta 100.0";
        //cuando
        String resultado = chef.preparar(menu);
        //esperado
        Assertions.assertEquals(esperado, resultado);
    }
    @Test
    public void casoDos() {
        //dado
        Menu menu = new MenuVegetariano(100.0, 0, true);
        Chef chef = new ChefVegetariano();
        String esperado = "se preparo un menu vegetariano y cuesta 101.0";
        //cuando
        String resultado = chef.preparar(menu);
        //esperado
        Assertions.assertEquals(esperado, resultado);
    }
    @Test
    public void casoTres() {
        //dado
        Menu menu = new MenuInfantil(100.0, 4);
        Chef chef = new ChefInfantil();
        String esperado = "se preparo un menu infantil y cuesta 112.0";
        //cuando
        String resultado = chef.preparar(menu);
        //esperado
        Assertions.assertEquals(esperado, resultado);
    }

}