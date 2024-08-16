package logic;

public class ProvAlimentos {



    private int id_proveedor;
    private String representante;

    public ProvAlimentos(int id_proveedor, String representante) {
        setId_proveedor(id_proveedor);
        setRepresentante(representante);
    }

    public ProvAlimentos() {
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
