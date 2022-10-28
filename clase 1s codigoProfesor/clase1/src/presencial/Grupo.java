package presencial;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Persona> personas;
    public Grupo(){
        personas= new ArrayList<>();
    }

    public void agregarPersona(Persona per){
        boolean checkMayoria=per.esMayorDeEdad();
        boolean cantLetras= per.checkNombre4Letras();
        boolean soloLetras= per.checkLetrasAZ();
        boolean checkEdad= per.checkEdad();

        if (checkMayoria&&cantLetras&&soloLetras&&checkEdad){
            personas.add(per);
            System.out.println("Se agregó a la persona: "+per.getNombre());
        }
        else{
            System.err.println("No se puede agregar a la persona: "+per.getNombre());
            if (!checkMayoria){
                System.err.println("La persona tiene que ser mayor de 18 años");
            }
            if (!cantLetras){
                System.err.println("El nombre de la persona tiene que ser de 5 letras o más");
            }
            if (!soloLetras){
                System.err.println("El nombre de la persona tiene que contener letras de a-z");
            }
            if (!checkEdad){
                System.err.println("La edad tiene que ser de 0 a 120 años");
            }
            System.err.println("***************************************************");
        }
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
