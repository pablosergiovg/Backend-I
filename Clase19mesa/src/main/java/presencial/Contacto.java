package presencial;

import java.io.Serializable;

public class Contacto implements Serializable {

    private String nombre;
    private String apellido;
    private String email;
    private String telefonos;

    public Contacto(String nombre, String apellido, String email, String telefonos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefonos = telefonos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefonos='" + telefonos + '\'' +
                '}';
    }
}
