public class ProveedorDeDocumento implements IProveedorDeDocumento{

    @Override
    public void getDocumento(String documentoId) {
        System.out.println("Documento encontrado" + documentoId);
    }
}
