package presencial;

public class Computadora {

    private Integer ram;
    private Integer discoDuro;
    private String id;
    private static Integer contador = 0;

    public Computadora(Integer ram, Integer discoDuro, String id) {
        this.ram = ram;
        this.discoDuro = discoDuro;
        this.id = id;

        contador++;
        System.out.println("Valor actual del contador: " + contador);
    }

    @Override
    public String toString() {
        return "Comutadora{" +
                "ram=" + ram +
                ", discoDuro=" + discoDuro +
                ", id='" + id + '\'' +
                '}';
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(Integer discoDuro) {
        this.discoDuro = discoDuro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static Integer getContador() {
        return contador;
    }

    public static void setContador(Integer contador) {
        Computadora.contador = contador;
    }
}
