package presencial;

public class ManejadorGerencial extends Manejador{
    @Override
    public String comprobarMail(Mail mail) {
        //soy el área gerencial
        //solo veo correos que son gerencia@colmena.com o tema gerencia
        if (mail.getTema().equals("gerencia")||
                mail.getDestino().equals("gerencia@colmena.com")){
            System.out.println("Correo pasando por gerencia");
            return "El correo se envió a gerencia";
        }
        else{
            System.out.println("No lo ve gerencial, pasa al siguiente");
            return this.getSiguienteManejador().comprobarMail(mail);
        }
    }
}
