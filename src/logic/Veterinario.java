package logic;

public class Veterinario {

    private int id_proveedor;
    private String clinica, fax, especialidad;

    public Veterinario() {
    }

    public Veterinario(int id_proveedor, String clinica, String fax, String especialidad) {
        this.id_proveedor = id_proveedor;
        this.clinica = clinica;
        this.fax = fax;
        this.especialidad = especialidad;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
