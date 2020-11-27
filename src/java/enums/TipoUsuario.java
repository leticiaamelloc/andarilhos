package enums;

public enum TipoUsuario {

    ADMIN("admin"),
    AUTOR("autor"),
    COMENTARISTA("comentarista");

    public final String tipo;

    private TipoUsuario(String tipo) {
        this.tipo = tipo;
    }

}
