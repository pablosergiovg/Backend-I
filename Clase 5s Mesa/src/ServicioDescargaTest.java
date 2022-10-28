import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServicioDescargaTest {

    @Test
    public void prueba1(){
        //DADO
        Usuario usuario1 = new Usuario("premium", 4234234);
        DescargaSpotify proxy = new ProxyServicioSpotify();
        String respuestaEsperada = "puedes descargar tu cancion!";

        //CUANDO
        String respuestaActual = proxy.puedeDescargarCancion(usuario1);

        //ENTONCES
        Assertions.assertEquals(respuestaEsperada, respuestaActual);

    }


}
