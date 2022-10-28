import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {

    private static Map<String, Arbol> arbolMap;

    private static ArbolFactory arbolFactory;

    private static Integer contador = 0;

    private ArbolFactory() {
        arbolMap = new HashMap<>();
    }

    public static ArbolFactory getArbolFactory(){
        if(arbolFactory == null){
            arbolFactory = new ArbolFactory();
        }
        return arbolFactory;
    }

    public Arbol crearArbol(String tipo, Integer alto, Integer horizontal, String color){

        if(!arbolMap.containsKey(tipo)){
            arbolMap.put(tipo, new Arbol(tipo, alto, horizontal, color));
            contador++;
        }
        return arbolMap.get(tipo);
    }

    public static Integer getContador() {
        return contador;
    }
}
