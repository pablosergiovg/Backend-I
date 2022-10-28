package presencial;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {

    private static Map<String, Computadora> computadoraMap;

    public ComputadoraFactory(){
        computadoraMap = new HashMap<>();
    }

    public static Computadora getComputadora(Integer ram, Integer disco){
        //construir la key, si es que no me dicen como realizarla.
        //en este caso la key es la combinacion de las especificaciones ram y disco.
        //preguntar si la key existe en el map.
        //si existe devolver dicho value(no se instancia).
        //caso contrario, instanciar la compu y devolver.
        String clave = "key: " + ram + ": " + disco;
        System.out.println(clave);

        if(!computadoraMap.containsKey(clave)){
            //instanciar porque no existe en el map.
            computadoraMap.put(clave, new Computadora(ram, disco, "a10"));
        }
        return computadoraMap.get(clave);
    }

}
