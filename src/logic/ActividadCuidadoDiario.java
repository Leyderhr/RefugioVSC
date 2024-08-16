package logic;

import java.sql.Date;
import java.sql.Time;

public class ActividadCuidadoDiario {

    public ActividadCuidadoDiario(){}
    public ActividadCuidadoDiario(int id_contrato, int id_animal, Date fecha, Time hora, String desc_act) {
        setId_contrato(id_contrato);
        setId_animal(id_animal);
        setFecha(fecha);
        setHora(hora);
        setDesc_act(desc_act);
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getDesc_act() {
        return desc_act;
    }

    public void setDesc_act(String desc_act) {
        this.desc_act = desc_act;
    }

    private int id_contrato, id_animal;
    private Date fecha;
    private Time hora;
    private String desc_act;
}
