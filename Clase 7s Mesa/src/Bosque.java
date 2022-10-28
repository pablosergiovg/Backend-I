import java.util.HashMap;
import java.util.Map;

public class Bosque {

    private static Map<String, Arbol> arbolMap;
    private static Integer contadorVerde = 0;
    private static Integer contadorRojo = 0;
    private static Integer contadorCeleste = 0;

    public Bosque() {
        arbolMap = new HashMap<>();
    }

    public void plantarArbol(Integer cantidadDeArboles, Arbol arbol){


        for (int i = 1; i <= cantidadDeArboles; i++) {

            switch (arbol.getColor()) {
                case "verde":
                        contadorVerde++;
                        break;
                case "rojo":
                        contadorRojo++;
                        break;
                case "celeste":
                        contadorCeleste++;
                        break;
            }

        }
    }

    public static Integer getContadorVerde() {
        return contadorVerde;
    }

    public static Integer getContadorRojo() {
        return contadorRojo;
    }

    public static Integer getContadorCeleste() {
        return contadorCeleste;
    }

    public String mostrarArbolesPlantados(){
        return "Cantidad de Arboles Verdes : " + getContadorVerde() + "\nCantidad de Arboles Rojos: " + getContadorRojo() + "\nCantidad de Arboles Celestes: " + getContadorCeleste();
    }


}
