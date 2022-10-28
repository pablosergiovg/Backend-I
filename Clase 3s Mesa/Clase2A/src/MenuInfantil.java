public class MenuInfantil extends Menu {
    private Integer cantidadJuguetes;

    public MenuInfantil(Double precioBase, Integer cantidadJuguetes) {
        super(precioBase);
        this.cantidadJuguetes = cantidadJuguetes;
    }

    public Integer getCantidadJuguetes() {
        return cantidadJuguetes;
    }
}
