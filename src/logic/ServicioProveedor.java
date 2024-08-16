package logic;

public class ServicioProveedor {

    private int id_proveedor, id_servicio;

    public ServicioProveedor() {
    }

    public ServicioProveedor(int id_proveedor, int id_servicio) {
        setId_proveedor(id_proveedor);
        setId_servicio(id_servicio);
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }
}
