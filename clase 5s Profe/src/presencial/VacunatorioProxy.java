package presencial;

import java.util.Date;

public class VacunatorioProxy implements VacunatorioInterface{
    private Vacunatorio centroVacunatorio;

    public VacunatorioProxy(){
        centroVacunatorio= new Vacunatorio();
    }
    @Override
    public String vacunar(Persona persona) {
        //implementamos el control, si es positivo va al centro
        //sino descartamos
        //control-> si hoy es posterior a la fecha asignada, ok
        Date hoy= new Date();
        if (hoy.after(persona.getFechaAsignada())){
            //ok
            return centroVacunatorio.vacunar(persona);
        }
        else{
            return persona.getNombre()+" por favor retorna cuando" +
                    " sea tu turno :D";
        }

    }
}
