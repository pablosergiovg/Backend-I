package presencial;

public class Persona {
    private String nombre;
    private Integer edad;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public boolean esMayorDeEdad(){
       return edad>=18;
    }
    public boolean checkNombre4Letras(){
        return nombre.length()>4;
    }
    public boolean checkEdad(){
        boolean respuesta=false;
        //proceso
        if (edad>=0&&edad<=120){
            respuesta=true;
        }
        //salida
        return respuesta;
    }
    public boolean checkLetrasAZ(){
        boolean respuesta=false;
        //proceso
        //quiero chequear que cada caracter sea una letra
        char[] nombreAChars= nombre.toCharArray();
        for (char letra:nombreAChars) {
            if (!Character.isLetter(letra)){
                return respuesta;
            }
        }
        respuesta=true;
        //salida
        return respuesta;
    }
}
