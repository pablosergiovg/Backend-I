package mesas;

public class Cuadrado implements Figura{
    private Double lado;

    public Cuadrado(Double lado) {
        this.lado = lado;
    }

    public Double getLado() {
        return lado;
    }

    public void setLado(Double lado) {
        this.lado = lado;
    }

    @Override
    public String calcularArea() {
        Double area=lado*lado;
        return "El área del cuadrado es de "+area+" unidades";
    }
}
