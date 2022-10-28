package presencial;

public class DescuentoImpl implements Descuento{

    @Override
    public int descuento(Tarjeta tarj, Producto prod, int cant) {
        //usar las APIs para conocer el valor final del porcentaje
        int respDescuento=0;
        respDescuento=respDescuento+ApiTarjeta.descuentoXTarjeta(tarj);
        respDescuento=respDescuento+ApiProducto.descuentoXProducto(prod);
        respDescuento=respDescuento+ApiCantidad.descuentoXCantidad(cant);
        return respDescuento;
    }
}
