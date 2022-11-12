import dao.BD;
import model.Odontologo;
import service.OdontologoService;

public class Cliente {
    public static void main(String[] args) {

        OdontologoService odontologoService = new OdontologoService();
        BD.crearTabla();
        Odontologo odontologo1 = new Odontologo(123, "Ricardo", "Quaresma");
        Odontologo odontologo2 = new Odontologo(124, "Ronaldinho", "Gaucho");
        Odontologo odontologo3 = new Odontologo(125, "Messi", "Sabe");
        Odontologo odontologo4 = new Odontologo(126, "Juan", "Guerra");

        odontologoService.registrarOdontologo(odontologo1);
        odontologoService.registrarOdontologo(odontologo2);
        odontologoService.registrarOdontologo(odontologo3);
        odontologoService.registrarOdontologo(odontologo4);

        System.out.println(odontologoService.listarOdontologos());

    }
}