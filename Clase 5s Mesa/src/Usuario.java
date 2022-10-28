public class Usuario {

    private String tipoUsuario;
    private Integer id;

    public Usuario(String tipoUsuario, Integer id) {
        this.tipoUsuario = tipoUsuario;
        this.id = id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
