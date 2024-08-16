package logic;

public class ProvServComplementarios {

    private int id_proveedor;
    private String representante;

    public ProvServComplementarios() {
    }

    public ProvServComplementarios(int id_proveedor, String representante) {
        setId_proveedor(id_proveedor);
        setRepresentante(representante);
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }
}
