package presencial;

public class CompruebaMail {
    private Manejador cadena;

    //crear la cadena
    public CompruebaMail(){
        //punto inicial
        cadena= new ManejadorGerencial();
        //creo objetos de cada eslabon
        Manejador comercial= new ManejadorComercial();
        Manejador tecnica= new ManejadorTecnico();
        Manejador spam= new ManejadorSpam();
        //unimos los eslabones
        cadena.setSiguienteManejador(comercial);
        comercial.setSiguienteManejador(tecnica);
        tecnica.setSiguienteManejador(spam);
    }

    public String checkCorreo(Mail mail){
        return cadena.comprobarMail(mail);
    }
}
