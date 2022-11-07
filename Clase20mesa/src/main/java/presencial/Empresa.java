package presencial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {

    private String cuit;
    private String razonSocial;
    private List<Empleado> empleadoList;

    public Empresa(String cuit, String razonSocial) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        empleadoList = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado){
        empleadoList.add(empleado);
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    @Override
    public String toString() {
        return "Cuit: " + cuit + "\n"
                + "Razón Social: " + razonSocial + "\n"
                + "Empleados:" + "\n" + empleadoList;
    }
}
