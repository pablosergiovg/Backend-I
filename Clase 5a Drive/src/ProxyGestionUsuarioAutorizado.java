import java.util.Map;

public class ProxyGestionUsuarioAutorizado implements IProveedorDeDocumento{

    private IProveedorDeDocumento proveedorDeDocumento;
    private Map documentos;
    private Map usuariosAutorizados;

    public ProxyGestionUsuarioAutorizado(IProveedorDeDocumento proveedorDeDocumento, Map documentos, Map usuariosAutorizados) {
        this.proveedorDeDocumento = proveedorDeDocumento;
        this.documentos = documentos;
        this.usuariosAutorizados = usuariosAutorizados;
    }

    

}
