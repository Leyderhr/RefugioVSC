package logic;

public class Clinica {

    private int id_clinica;
    private String direccion;
    private  String nombre;

    public  Clinica(){}

    public Clinica(int id_clinica, String direccion, String nombre) {
        setId_clinica(id_clinica);
        setDireccion(direccion);
        setNombre(nombre);
    }

    public int getId_clinica() {
        return id_clinica;
    }

    public void setId_clinica(int id_clinica) {
        this.id_clinica = id_clinica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
