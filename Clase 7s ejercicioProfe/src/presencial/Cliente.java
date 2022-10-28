package presencial;

import java.util.ArrayList;

public class Cliente {

    public static void main(String[] args) {

        //necesito la fabrica.
        ComputadoraFactory computadoraFactory = new ComputadoraFactory();

        //necesito computadoras.
        Computadora pc1 = ComputadoraFactory.getComputadora(16, 500);
        Computadora pc2 = ComputadoraFactory.getComputadora(8, 500);
        Computadora pc3 = ComputadoraFactory.getComputadora(16, 500);
        Computadora pc4 = ComputadoraFactory.getComputadora(8, 500);

        System.out.println(pc1.toString());
        System.out.println(pc2.toString());
        System.out.println(pc3.toString());
        System.out.println(pc4.toString());

        System.out.println("Cantidad final de objetos: " + Computadora.getContador());

        //Probando
        ArrayList<Computadora> computadorasNegocio = new ArrayList<>();
        for (int i = 1; i < 2000; i++) {
            ComputadoraFactory.getComputadora(20, 800);
        }

        System.out.println("Cantidad final de objetos: " + Computadora.getContador());

    }

}
