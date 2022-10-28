import java.util.List;

public class BusquedaImpl implements Busqueda{

    private ApiHotel apiHotel;
    private ApiVuelo apiVuelo;

    public BusquedaImpl(){
        apiHotel = new ApiHotel();
        apiVuelo = new ApiVuelo();
    }

    public void agregarHotel(Hotel hotel){
        apiHotel.agregarHotel(hotel);
    }

    public void agregarVuelo(Vuelo vuelo){
        apiVuelo.agregarVuelo(vuelo);
    }

    @Override
    public String busqueda(String destino, String fechaCheking, String fechaChekout) {
        Hotel hotel = apiHotel.buscarHotel(destino,fechaCheking,fechaChekout);
        Vuelo vuelo = apiVuelo.buscarVuelo(destino,fechaCheking,fechaChekout);
        if(vuelo != null && hotel != null){
            return "Vuelo: " + vuelo.getDestino() + "\n Hotel: " + hotel.getNombre();
        }
        return "No se encontraron hoteles/vuelos disponibles";
    }

}
