package presencial;

public class ApiCantidad {
    public static int descuentoXCantidad(int cantidad){
        if (cantidad>12){
            return 15;
        }
        else {
            return 0;
        }
    }
}
