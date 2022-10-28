public class ChefClasico extends Chef {
    @Override
    protected String armar(Menu menu) {
        return "Se preparo un menu clasico";
    }

    @Override
    protected Double calcularPrecio(Menu menu) {
        if (menu instanceof MenuClasico) {
            return menu.getPrecioBase();
        }
        return 0.0;
    }
}
