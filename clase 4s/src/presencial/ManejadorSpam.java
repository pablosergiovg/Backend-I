package presencial;

public class ManejadorSpam extends Manejador{
    @Override
    public String comprobarMail(Mail mail) {
        System.out.println("quedó en spam");
        return "El correo se envió a spam";
    }
}
