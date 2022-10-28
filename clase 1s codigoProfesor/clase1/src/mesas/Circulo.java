package mesas;

public class Circulo implements Figura{
    private Double radio;

    public Circulo(Double radio) {
        this.radio = radio;
    }

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public String calcularArea() {
        Double area=Math.PI*(radio*radio);
        return "El área del círculo es de "+area+" unidades";
    }
}
