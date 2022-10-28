import java.util.Map;

public class Arbol {

    private String tipo;
    private Integer alto;
    private Integer horizontal;
    private String color;

    public Arbol(String tipo, Integer alto, Integer horizontal, String color) {
        this.tipo = tipo;
        this.alto = alto;
        this.horizontal = horizontal;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Arbol{" +
                "tipo='" + tipo + '\'' +
                ", alto=" + alto +
                ", horizontal=" + horizontal +
                ", color='" + color + '\'' +
                '}';
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getAlto() {
        return alto;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public Integer getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(Integer horizontal) {
        this.horizontal = horizontal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
