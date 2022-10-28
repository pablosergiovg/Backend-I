import java.util.HashMap;
import java.util.Map;

public class RopaFactory {

    private static Map<String, Ropa> ropaMap = new HashMap<>();

    public static Ropa getRopa(String talle, String tipo, Boolean esNuevo, Boolean ropaImp){
        String clave = "key: " + talle + "," + tipo + "," + esNuevo + "," + ropaImp;
        System.out.println(clave);

        Ropa ropa = ropaMap.get(clave);
        if(ropa == null){
            ropa = new Ropa(talle, tipo, esNuevo, ropaImp);
            ropaMap.put(clave, ropa);
        }
        return ropa;

    }

    public static Map<String, Ropa> getRopaMap() {
        return ropaMap;
    }
}
