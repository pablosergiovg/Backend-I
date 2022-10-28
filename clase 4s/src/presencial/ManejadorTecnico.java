package presencial;

public class ManejadorTecnico extends Manejador{
    @Override
    public String comprobarMail(Mail mail) {
        //soy el área tecnica
        //solo veo correos que son tecnica@colmena.com o tema tecnico
        if (mail.getTema().equals("tecnico")||
                mail.getDestino().equals("tecnica@colmena.com")){
            System.out.println("Correo pasando por tecnica");
            return "El correo se envió a tecnica";
        }
        else{
            System.out.println("No lo ve tecnica, pasa al siguiente");
            return this.getSiguienteManejador().comprobarMail(mail);
        }
    }
}
