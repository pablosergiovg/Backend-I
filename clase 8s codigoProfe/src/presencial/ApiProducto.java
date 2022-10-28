package presencial;

public class ApiProducto {
    public static int descuentoXProducto(Producto producto){
        if (producto.getTipo().equals("Latas")){
            return 10;
        }
        else{
            return 0;
        }
    }
}
