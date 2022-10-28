package presencial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class GrupoTest {
    @Test
    public void casoUno(){
        //DADO
        Persona juan= new Persona("Juan",20);
        Persona pedro= new Persona("Pedro",21);
        Persona ana= new Persona("Ana",22);
        Persona luz= new Persona("Luz",23);
        Persona julian= new Persona("Julian",24);
        Grupo grupo1= new Grupo();

        //CUANDO
        grupo1.agregarPersona(juan);
        grupo1.agregarPersona(pedro);
        grupo1.agregarPersona(ana);
        grupo1.agregarPersona(luz);
        grupo1.agregarPersona(julian);
        //ENTONCES
        Assertions.assertTrue(grupo1.getPersonas().size()==2);
    }
    @Test
    public void casoDos(){
        //DADO
        Persona juan= new Persona("Juana",18);
        Persona pedro= new Persona("Pedro",17);
        Persona ana= new Persona("Analia",22);
        Persona luz= new Persona("Luciana",14);
        Persona julian= new Persona("Julian",32);
        Grupo grupo1= new Grupo();

        //CUANDO
        grupo1.agregarPersona(juan);
        grupo1.agregarPersona(pedro);
        grupo1.agregarPersona(ana);
        grupo1.agregarPersona(luz);
        grupo1.agregarPersona(julian);
        //ENTONCES
        Assertions.assertTrue(grupo1.getPersonas().size()==3);
    }
    @Test
    public void casoTres(){
        //DADO
        Persona nicolas= new Persona("N1c0las",20);
        Persona tomas= new Persona("Tomas",21);
        Persona esteban= new Persona("3steban",22);
        Persona carlos= new Persona("Carlos\\sV",23);
        Persona francisco= new Persona("Francisco\\sII",24);
        Grupo grupo1= new Grupo();

        //CUANDO
        grupo1.agregarPersona(nicolas);
        grupo1.agregarPersona(tomas);
        grupo1.agregarPersona(esteban);
        grupo1.agregarPersona(carlos);
        grupo1.agregarPersona(francisco);
        //ENTONCES
        Assertions.assertEquals(1,grupo1.getPersonas().size());
    }
}
