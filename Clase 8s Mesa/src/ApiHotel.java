import java.util.ArrayList;
import java.util.List;

public class ApiHotel {

    private List<Hotel> hotelList;

    public ApiHotel() {
        hotelList = new ArrayList<>();
    }

    public void agregarHotel(Hotel hotel){
        hotelList.add(hotel);
    }

    public Hotel buscarHotel(String destino, String fechaCheking, String fechaChekout){
        for (Hotel hotel : hotelList) {
            if(hotel.getCiudad().equals(destino) && hotel.getChecking().equals(fechaCheking) && hotel.getChekout().equals(fechaChekout)){
                return hotel;
            }
        }
        return null;
    }

}
