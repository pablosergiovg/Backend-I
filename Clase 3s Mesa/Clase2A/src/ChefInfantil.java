public class ChefInfantil extends Chef {
    @Override
    protected String armar(Menu menu) {
        return "se preparo un menu infantil";
    }

    @Override
    protected Double calcularPrecio(Menu menu) {
        if (menu instanceof MenuInfantil) {
            MenuInfantil menuInfantil = (MenuInfantil) menu;
            return menu.getPrecioBase() + (menuInfantil.getCantidadJuguetes() * 3);
        }
        return 0.0;
    }
}
