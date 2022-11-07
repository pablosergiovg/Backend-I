package presencial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejoDeArchivos{

    public List<Contacto> contactos;

    public ManejoDeArchivos() {
        this.contactos = new ArrayList<>();
    }

    public void agregarContactosALista(Contacto contacto){
        contactos.add(contacto);
    }

    public void guardarColeccionEnArchivo(){

        //guardar lista en disco
        FileOutputStream fos = null;
        try {

            fos = new FileOutputStream("ArchivoContactos.txt");
            //usar objectOutPutLStream para guardar la informacion
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //el metodo witeObjet guarda un objeto
            oos.writeObject(contactos);
            oos.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void recuperarObjetos(String archivo){

        List<Contacto> listaContactos2 = new ArrayList<>();
        FileInputStream fis = null;

        try{

            //flujo de entrada
            fis = new FileInputStream("ArchivoContactos.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //casteamos porque readObjet() me devuelve un objeto de la clase Objet
            //los objetos no se olvidan de como nacen
            listaContactos2 = (ArrayList)ois.readObject();
            ois.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        for(Object contacto : listaContactos2){
            System.out.println(contacto);
        }

    }

}
