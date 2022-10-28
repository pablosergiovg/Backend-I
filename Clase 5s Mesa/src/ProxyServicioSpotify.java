public class ProxyServicioSpotify implements DescargaSpotify{

    private DescargaSpotify servicioDescarga;

    public ProxyServicioSpotify() {
    }

    @Override
    public String puedeDescargarCancion(Usuario usuario) {
        if(usuario.getTipoUsuario().equals("premium")){
            servicioDescarga = new ServicioDescarga();
            return servicioDescarga.puedeDescargarCancion(usuario);
        }else{
            return "no puedes descargar, debes ser premium";
        }
    }

}
