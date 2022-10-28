package presencial;

public class Supermercado {
    public static void main(String[] args) {
        //una fachada
        //una tarjeta
        //un producto
        //una cantidad

        DescuentoImpl facade=new DescuentoImpl();
        Tarjeta tarjeta= new Tarjeta("5448258425865896","Star Bank");
        Producto producto= new Producto("Gaseosa","Bebidas");
        int cantidad=18;
        int descuentoTotal= facade.descuento(tarjeta,producto,cantidad);
        //el descuento es de 35
        System.out.println("El porcentaje total de descuento es: "+descuentoTotal);
    }
}
