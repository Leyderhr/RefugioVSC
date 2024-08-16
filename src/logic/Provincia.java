package logic;

public class Provincia {

    private String nombre;
    private int id_provinvcia;

    public Provincia(){}

    public Provincia(String nombre, int id_provinvcia) {
        setNombre(nombre);
        setId_provinvcia(id_provinvcia);
    }

    public int getId_provinvcia() {
        return id_provinvcia;
    }

    public void setId_provinvcia(int id_provinvcia) {
        this.id_provinvcia = id_provinvcia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
