package presencial;

public class ApiTarjeta {
    public static int descuentoXTarjeta(Tarjeta tarjeta){
        if (tarjeta.getBanco().equals("Star Bank")){
            return 20;
        }
        else{
            return 0;
        }
    }
}
