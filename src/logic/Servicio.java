package logic;

public class Servicio {

    private int id_servicio;
    private double precio;
    private String modalidad, tipo_servicio;

    public Servicio() {
    }

    public Servicio(int id_servicio, double precio, String modalidad, String tipo_servicio) {
        setId_servicio(id_servicio);
        setPrecio(precio);
        setModalidad(modalidad);
        setTipo_servicio(tipo_servicio);
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }
}
