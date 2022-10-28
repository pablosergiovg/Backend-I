public class Ropa {

    private String talle;
    private String tipo;
    private Boolean esNuevo;
    private Boolean ropaInt;

    public Ropa(String talle, String tipo, Boolean esNuevo, Boolean ropaInt) {
        this.talle = talle;
        this.tipo = tipo;
        this.esNuevo = esNuevo;
        this.ropaInt = ropaInt;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(Boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public Boolean getRopaInt() {
        return ropaInt;
    }

    public void setRopaInt(Boolean ropaInt) {
        this.ropaInt = ropaInt;
    }
}
