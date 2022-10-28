public class Main {
    public static void main(String[] args) {

        ArbolFactory.getArbolFactory();

        Bosque bosque = new Bosque();

        bosque.plantarArbol(500000, ArbolFactory.getArbolFactory().crearArbol("Ornamentales", 200, 400, "verde"));
        bosque.plantarArbol(500000, ArbolFactory.getArbolFactory().crearArbol("Frutales", 500, 300, "rojo"));
        bosque.plantarArbol(0, ArbolFactory.getArbolFactory().crearArbol("NoRecuerdo", 100, 200, "celeste"));

        System.out.println(bosque.mostrarArbolesPlantados());

        System.out.println(ArbolFactory.getContador());

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

    }
}