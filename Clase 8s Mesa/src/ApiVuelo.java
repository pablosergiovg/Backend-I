import java.util.ArrayList;
import java.util.List;

public class ApiVuelo {

    private List<Vuelo> vueloList;

    public ApiVuelo(){
        vueloList = new ArrayList<>();
    }

    public void agregarVuelo(Vuelo vuelo){
        vueloList.add(vuelo);
    }

    public Vuelo buscarVuelo(String destino, String fechaDeSalida, String fechaDeRegreso){
        for (Vuelo vuelo : vueloList) {
            if(vuelo.getDestino().equals(destino) && vuelo.getFechaDeSalida().equals(fechaDeSalida) && vuelo.getFechaDeRegreso().equals(fechaDeRegreso)){
                return vuelo;
            }
        }
        return null;
    }

}
