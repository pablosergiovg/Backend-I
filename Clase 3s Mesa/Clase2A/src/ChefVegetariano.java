public class ChefVegetariano extends Chef {
    @Override
    protected String armar(Menu menu) {
        return "se preparo un menu vegetariano";
    }

    @Override
    protected Double calcularPrecio(Menu menu) {
        if (menu instanceof MenuVegetariano) {
            MenuVegetariano menuVegetariano = (MenuVegetariano) menu;
            if (menuVegetariano.getEspecias()) {
                return (menu.getPrecioBase() + (menuVegetariano.getCantidadSalsas() * 2)) * 1.01;
            }
            return menu.getPrecioBase() + (menuVegetariano.getCantidadSalsas() * 2);
        }
        return 0.0;
    }
}
