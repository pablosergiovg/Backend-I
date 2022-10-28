package presencial;

import java.util.Date;

public class Persona {
    private String apellido;
    private String nombre;
    private String dni;
    private String nombreVacuna;
    private Date fechaAsignada;

    public Persona(String apellido, String nombre, String dni, String nombreVacuna, Date fechaAsignada) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.nombreVacuna = nombreVacuna;
        this.fechaAsignada = fechaAsignada;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public Date getFechaAsignada() {
        return fechaAsignada;
    }

    public void setFechaAsignada(Date fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }
}
