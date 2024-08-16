package logic;

public class Animal {
    private int id_animal, edad, cant_dias_refugio;
    private double peso;
    private String nombre, especie, raza;
    public Animal() {
    }

    public Animal(int id_animal, int edad, int cant_dias_refugio, double peso, String nombre, String especie, String raza) {
        setId_animal(id_animal);
        setEdad(edad);
        setCant_dias_refugio(cant_dias_refugio);
        setPeso(peso);
        setNombre(nombre);
        setEspecie(especie);
        setRaza(raza);
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCant_dias_refugio() {
        return cant_dias_refugio;
    }

    public void setCant_dias_refugio(int cant_dias_refugio) {
        this.cant_dias_refugio = cant_dias_refugio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }


}
