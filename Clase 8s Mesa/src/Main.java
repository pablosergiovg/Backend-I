public class Main {
    public static void main(String[] args) {

        BusquedaImpl busqueda = new BusquedaImpl();

        Hotel hotel1 = new Hotel("20-12-2022", "20-1-2023", "Copacabana", "Gostoso");
        Hotel hotel2 = new Hotel("23-12-2022", "23-1-2023", "Buenos Aires", "Messirve");
        Hotel hotel3 = new Hotel("21-12-2022", "21-1-2023", "Punta del Este", "Bo");

        Vuelo vuelo1 = new Vuelo("20-12-2022", "20-1-2023", "Lima", "Copacabana");
        Vuelo vuelo2 = new Vuelo("19-12-2022", "19-1-2023", "Santiago", "Buenos Aires");
        Vuelo vuelo3 = new Vuelo("21-12-2022", "21-1-2023", "Maracay", "Punta del Este");

        busqueda.agregarHotel(hotel1);
        busqueda.agregarHotel(hotel2);
        busqueda.agregarHotel(hotel3);

        busqueda.agregarVuelo(vuelo1);
        busqueda.agregarVuelo(vuelo2);
        busqueda.agregarVuelo(vuelo3);

        System.out.println(busqueda.busqueda("Copacabana","20-12-2022", "20-1-2023"));
        System.out.println(busqueda.busqueda("Qatar","20-12-2022", "20-1-2023"));



    }
}