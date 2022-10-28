package presencial;

public class Vacunatorio implements VacunatorioInterface{
    @Override
    public String vacunar(Persona persona) {
        //aqui gasto o utilizo el recurso
        System.out.println("Verificando el documento");
        return "Verificación correcta. Se ha registrado " +
                "el DNI:"+persona.getDni()+" como persona" +
                " vacunada con "+persona.getNombreVacuna();
    }
}
