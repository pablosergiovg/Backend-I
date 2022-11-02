import dao.BD;
import model.Impresora;
import service.ImpresoraService;

public class Cliente {

    public static void main(String[] args) {

        ImpresoraService impresoraService = new ImpresoraService();
        BD.crearTabla();
        Impresora impresora1 = new Impresora("HP", "315", "Negro");
        impresoraService.registrarImpresora(impresora1);

        System.out.println(impresoraService.buscarImpresora(impresora1.getId()));

    }

}
