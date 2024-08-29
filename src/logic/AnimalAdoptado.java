package logic;

public class AnimalAdoptado {

    private int id_animal;
    private double precio_Total_adopcion;
    private double cant_dondaciones;

    public AnimalAdoptado(int id_animal) {
        setId_animal(id_animal);
    }

    public AnimalAdoptado() {
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public double getCant_dondaciones() {
        return cant_dondaciones;
    }

    public void setCant_dondaciones(double cant_dondaciones) {
        this.cant_dondaciones = cant_dondaciones;
    }

    public double getPrecio_Total_adopcion() {
        return precio_Total_adopcion;
    }

    public void setPrecio_Total_adopcion(double precio_Total_adopcion) {
        this.precio_Total_adopcion = precio_Total_adopcion;
    }
}
