package presencial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejadorEntradaSalida {

    /*public static void guardarListaEmpleadosFormatoEspecial(List<Empleado> empleados){

        //vamos a guardar, pensamos en flujos de salida
        FileOutputStream fos = null;

        try {

            fos = new FileOutputStream("Empleados.txt");
            //vamos a usar la clase Buffer para guardar
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            //vamos a recorrer la lista
            for (Empleado empleado : empleados) {
                String linea = empleado.toString()+"\n";
                bos.write(linea.getBytes());
            }
            bos.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }*/

    public static void guardarEmpresaEnArchivo(Empresa empresa, String archivo){

        FileOutputStream fos = null;

        try {

            fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(empresa);
            oos.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void leerArchivo(String archivo){

        Empresa empresa = null;
        List<Empleado> empleadoList2 = new ArrayList<>();
        FileInputStream fis = null;

        try {

            fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            empresa = (Empresa) ois.readObject();
            ois.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(empresa);

    }

}
