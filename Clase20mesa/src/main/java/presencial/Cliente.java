package presencial;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {

        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado("Juan", "Perez", "emple", 1234.0));
        empleados.add(new Empleado("Leopolda", "Perez", "empla", 1235.0));
        empleados.add(new Empleado("Mariantoñeta", "Perez", "empla", 1223.0));

        //ManejadorEntradaSalida.guardarListaEmpleadosFormatoEspecial(empleados);

        Empresa empresa = new Empresa("1234", "4321");
        empresa.agregarEmpleado(new Empleado("Juan", "Perez", "emple", 1234.0));
        empresa.agregarEmpleado(new Empleado("Leopolda", "Perez", "empla", 1235.0));
        empresa.agregarEmpleado(new Empleado("Mariantoñeta", "Perez", "empla", 1223.0));

        ManejadorEntradaSalida.guardarEmpresaEnArchivo(empresa, "Empleados.txt");

        ManejadorEntradaSalida.leerArchivo("Empleados.txt");

    }

}
