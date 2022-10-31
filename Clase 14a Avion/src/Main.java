import daos.AvionDAOH2;
import entidades.Avion;
import servicios.AvionService;

public class Main {
    public static void main(String[] args) {

        Avion avion1 = new Avion();
        Avion avion2 = new Avion();
        Avion avion3 = new Avion();

        //avion1.setId(1L);
        //avion1.setMarca("Boing");
        //avion1.setModelo("El Veloz");
        //avion1.setMatricula("1234asdf");
        //avion1.setFechaEntradaServicio("4-2-2015");
//
        //avion2.setId(2L);
        //avion2.setMarca("AIRWEY");
        //avion2.setModelo("El tranqui");
        //avion2.setMatricula("5678ghjk");
        //avion2.setFechaEntradaServicio("4-2-2014");

        //avion3.setId(3L);
        //avion3.setMarca("HONDA");
        //avion3.setModelo("El AutitoVolador");
        //avion3.setMatricula("swuanfonson");
        //avion3.setFechaEntradaServicio("4-2-2020");

        AvionService avionService = new AvionService();
        //Setear estrategia de persistencia, es decir el DAO
        avionService.setAvionDao(new AvionDAOH2());

        //avionService.registrarAvion(avion1);
        //avionService.registrarAvion(avion2);
        //avionService.registrarAvion(avion3);

        avionService.eliminarAvion(3L);

        //System.out.println(avionService.buscarAvion(2L));
        System.out.println(avionService.buscarTodos());



    }
}