package model;

public class Impresora {

    private Integer id;
    private String nombre;
    private String marca;
    private String color;

    public Impresora(Integer id, String nombre, String marca, String color) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
    }

    public Impresora(String nombre, String marca, String color) {
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "id: " + id + ", nombre: " + nombre + ", marca: " + marca + ", color: " + color;
    }
}
