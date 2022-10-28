public class Vuelo {

    private String fechaDeSalida;
    private String fechaDeRegreso;
    private String origen;
    private String destino;

    public Vuelo(String fechaDeSalida, String fechaDeRegreso, String origen, String destino) {
        this.fechaDeSalida = fechaDeSalida;
        this.fechaDeRegreso = fechaDeRegreso;
        this.origen = origen;
        this.destino = destino;
    }

    public String getFechaDeSalida() {
        return fechaDeSalida;
    }

    public void setFechaDeSalida(String fechaDeSalida) {
        this.fechaDeSalida = fechaDeSalida;
    }

    public String getFechaDeRegreso() {
        return fechaDeRegreso;
    }

    public void setFechaDeRegreso(String fechaDeRegreso) {
        this.fechaDeRegreso = fechaDeRegreso;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
