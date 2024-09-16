package logic;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Animal {
    private int id_animal, edad, cant_dias_refugio;
    private double peso;
    private String nombre, especie, raza;
    private Date fecha_llegada;

    public Animal() {
    }

    public Animal(int id_animal, int edad, int cant_dias_refugio, double peso, String nombre, String especie, String raza, Date fecha_llegada) {
        setId_animal(id_animal);
        setEdad(edad);
        setCant_dias_refugio(cant_dias_refugio);
        setPeso(peso);
        setNombre(nombre);
        setEspecie(especie);
        setRaza(raza);
        setFecha_llegada(fecha_llegada);
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

    public Date getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(Date fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    public void actualizaCantDias(){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha_llegada);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        LocalDate fecha1 = LocalDate.of(year, month, dia);

        cant_dias_refugio = Math.toIntExact(ChronoUnit.DAYS.between(fecha1, LocalDate.now()));
    }
}
