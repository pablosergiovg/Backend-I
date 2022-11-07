package presencial;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {

        //manejador de archivos
        ManejoDeArchivos manejoDeArchivos = new ManejoDeArchivos();

        //lista de contactos
        Contacto  contacto1 = new Contacto("Juan", "Perez", "juanperez@gmail.com", "123456789");
        Contacto  contacto2 = new Contacto("Antonio", "Perez", "antonioperez@gmail.com", "123456790");
        Contacto  contacto3 = new Contacto("Maria", "Perez", "mariaperez@gmail.com", "123456791");

        //agregando contactos al array Contactos
        manejoDeArchivos.agregarContactosALista(contacto1);
        manejoDeArchivos.agregarContactosALista(contacto2);
        manejoDeArchivos.agregarContactosALista(contacto3);

        //Escribir archivo Contactos
        manejoDeArchivos.guardarColeccionEnArchivo();

        //recuperar Informacion del archivo ArchivoContactos.txt y guardarlo en otro array

        manejoDeArchivos.recuperarObjetos("ArchivoContactos.txt");

    }

}
