public class Hotel {

    private String checking;
    private String chekout;
    private String ciudad;
    private String nombre;

    public Hotel(String checking, String chekout, String ciudad, String nombre) {
        this.checking = checking;
        this.chekout = chekout;
        this.ciudad = ciudad;
        this.nombre = nombre;
    }

    public String getChecking() {
        return checking;
    }

    public void setChecking(String checking) {
        this.checking = checking;
    }

    public String getChekout() {
        return chekout;
    }

    public void setChekout(String chekout) {
        this.chekout = chekout;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }
}
