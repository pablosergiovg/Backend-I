import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static final Logger logger = Logger.getLogger(App.class);
    private List<Integer> listaEnteros;

    public App() {
        listaEnteros = new ArrayList<>();
    }

    //metodo agregar numero a la lista.
    public void agregarEntero(Integer numero){

        listaEnteros.add(numero);

        if(listaEnteros.size() > 5 && listaEnteros.size() <= 10){
            //loguear que tiene mas de 5 elementos.
            logger.info("La lista tiene mas de 5 elementos, en total tiene: " + listaEnteros.size());
        }

        if(listaEnteros.size() > 10){
            //loguear que tiene mas de 10 elementos.
            logger.info("La lista tiene mas de 10 elementos, en total tiene: " + listaEnteros.size());
        }

        Double contador = 0.0;
        for (Integer entero : listaEnteros) {
            contador += entero;
        }
        logger.info("El promedio es: " + contador / listaEnteros.size());

    }

    public void borrarItems(){

        listaEnteros.clear();

        if (listaEnteros.size() == 0){
            logger.info("La lista no contiene ningun elemento.");
        }
    }

    public void calcularMinimo(){

        Integer minimo = listaEnteros.get(0);

        for (Integer entero : listaEnteros) {
            if(minimo > entero){
                minimo = entero;
            }
        }
        logger.info("El minimo es: " + minimo);
    }

}
