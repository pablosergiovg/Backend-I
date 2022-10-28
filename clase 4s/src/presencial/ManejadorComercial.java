package presencial;

public class ManejadorComercial extends Manejador{
    @Override
    public String comprobarMail(Mail mail) {
        //soy el área comercial
        //solo veo correos que son comercial@colmena.com o tema comercial
        if (mail.getTema().equals("comercial")||
            mail.getDestino().equals("comercial@colmena.com")){
            System.out.println("Correo pasando por comercial");
            return "El correo se envió a comercial";
        }
        else{
            System.out.println("No lo ve comercial, pasa al siguiente");
            return this.getSiguienteManejador().comprobarMail(mail);
        }
    }
}
