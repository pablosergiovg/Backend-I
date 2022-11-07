import dao.BD;
import model.Impresora;
import service.ImpresoraService;

public class Cliente {

    public static void main(String[] args) {

        ImpresoraService impresoraService = new ImpresoraService();
        BD.crearTabla();
        Impresora impresora1 = new Impresora("HP", "315", "Negro");
        Impresora impresora2 = new Impresora("EPSON", "315", "Blanca");
        Impresora impresora3 = new Impresora("HP", "200", "Gris");
        impresoraService.registrarImpresora(impresora1);
        impresoraService.registrarImpresora(impresora2);
        impresoraService.registrarImpresora(impresora3);

        System.out.println(impresoraService.buscarImpresora(3));
        System.out.println(impresoraService.buscarImpresora(impresora2.getId()));
        System.out.println(impresoraService.buscarImpresora(impresora3.getId()));

    }

}
