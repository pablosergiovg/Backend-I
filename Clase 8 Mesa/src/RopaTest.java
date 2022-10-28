import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public class RopaTest {

    @Test

    public void pantalon(){
        //dado
        Ropa pantalon1 = RopaFactory.getRopa("xs","pantalon",true,false);
        Ropa pantalon2 = RopaFactory.getRopa("xs","pantalon",true,false);
        Ropa pantalon3 = RopaFactory.getRopa("xs","pantalon",true,false);
        Ropa pantalon4 = RopaFactory.getRopa("xs","pantalon",true,false);
        Ropa pantalon5 = RopaFactory.getRopa("xs","pantalon",true,false);


        Ropa remera1 = RopaFactory.getRopa("m","remera",true,false);
        Ropa remera2 = RopaFactory.getRopa("m","remera",true,false);
        Ropa remera3 = RopaFactory.getRopa("m","remera",true,false);

        Integer resultadoEsperado = 2;

        //entonces
        Integer resultadoActual = RopaFactory.getRopaMap().size();

        Assertions.assertEquals(resultadoEsperado, resultadoActual);

    }

}
