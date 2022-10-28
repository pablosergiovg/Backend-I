public abstract class Chef {

    public String preparar(Menu menu) {
        Double precio = calcularPrecio(menu);
        if (precio > 0.0) {
            String armado = armar(menu);
            return armado + " y cuesta " + precio;
        }
        return "No se pudo preparar el menu";
    }

    protected abstract String armar(Menu menu);
    protected abstract Double calcularPrecio(Menu menu);
}
