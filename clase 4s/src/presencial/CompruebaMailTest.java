package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompruebaMailTest {
    @Test
    public void mailATecnica(){
        //dado
        Mail mail=new Mail("rodolfo@gmail.com",
                "tecnica@colmena.com","Consulta de PC");
        CompruebaMail gestor= new CompruebaMail();
        String respEsperada="El correo se envió a tecnica";
        //cuando
        String procesamiento=gestor.checkCorreo(mail);
        //entonces
        Assertions.assertEquals(respEsperada,procesamiento);
    }
    @Test
    public void mailASpam(){
        //dado
        Mail mail=new Mail("rodolfo@gmail.com",
                "quejas@colmena.com","Consulta de PC");
        CompruebaMail gestor= new CompruebaMail();
        String respEsperada="El correo se envió a spam";
        //cuando
        String procesamiento=gestor.checkCorreo(mail);
        //entonces
        Assertions.assertEquals(respEsperada,procesamiento);
    }
}
