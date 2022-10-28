public class Main {
    public static void main(String[] args) {


        App aplicacion = new App();

        for (int i = 1; i < 15; i++) {
            aplicacion.agregarEntero(i);
        }

        aplicacion.calcularMinimo();

        aplicacion.borrarItems();
    }

}