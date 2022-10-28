public class MenuVegetariano extends Menu {
    private Integer cantidadSalsas;
    private Boolean especias;

    public MenuVegetariano(Double precioBase, Integer cantidadSalsas, Boolean especias) {
        super(precioBase);
        this.cantidadSalsas = cantidadSalsas;
        this.especias = especias;
    }

    public Boolean getEspecias() {
        return especias;
    }

    public Integer getCantidadSalsas() {
        return cantidadSalsas;
    }
}
