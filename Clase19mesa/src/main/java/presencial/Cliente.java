package presencial;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {

        //manejador de archivos

        //lista de contactos
        Contacto  contacto1 = new Contacto("Juan", "Perez", "juanperez@gmail.com", "123456789");
        Contacto  contacto2 = new Contacto("Antonio", "Perez", "antonioperez@gmail.com", "123456790");
        Contacto  contacto3 = new Contacto("Maria", "Perez", "mariaperez@gmail.com", "123456791");

        List<Contacto> contactos = new ArrayList<>();

        contactos.add(contacto1);
        contactos.add(contacto2);
        contactos.add(contacto3);

        //agregando contactos al array Contactos

        //Escribir archivo Contactos
        ManejoDeArchivos.guardarColeccionEnArchivo(contactos);

        //recuperar Informacion del archivo ArchivoContactos.txt y guardarlo en otro array

        ManejoDeArchivos.recuperarObjetos("ArchivoContactos.txt");

    }

}
