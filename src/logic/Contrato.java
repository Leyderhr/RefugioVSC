package logic;

import java.sql.Date;

public class Contrato {

    private int id_contrato, id_proveedor, id_servicio;
    private Date fecha_ini, Fecha_term, fecha_conc;
    private String desc_cont, nom_resp;
    private double recargo;

    public Contrato(int id_contrato, int id_proveedor, int id_servicio, Date fecha_ini, Date fecha_term, Date fecha_conc, String desc_cont, String nom_resp, double recargo) {
        setId_contrato(id_contrato);
        setId_proveedor(id_proveedor);
        setId_servicio(id_servicio);
        setFecha_ini(fecha_ini);
        setFecha_term(fecha_term);
        setFecha_conc(fecha_conc);
        setDesc_cont(desc_cont);
        setNom_resp(nom_resp);
        setRecargo(recargo);
    }

    public Contrato() {
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
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

    public Date getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(Date fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public Date getFecha_term() {
        return Fecha_term;
    }

    public void setFecha_term(Date fecha_term) {
        Fecha_term = fecha_term;
    }

    public Date getFecha_conc() {
        return fecha_conc;
    }

    public void setFecha_conc(Date fecha_conc) {
        this.fecha_conc = fecha_conc;
    }

    public String getDesc_cont() {
        return desc_cont;
    }

    public void setDesc_cont(String desc_cont) {
        this.desc_cont = desc_cont;
    }

    public String getNom_resp() {
        return nom_resp;
    }

    public void setNom_resp(String nom_resp) {
        this.nom_resp = nom_resp;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }




}
