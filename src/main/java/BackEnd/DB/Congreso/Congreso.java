/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB.Congreso;

import java.sql.Date;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jgarcia07
 */
public class Congreso {
    private String idCongreso;
    private String tituloCongreso;
    private String descripcionCongreso;
    private Date fechaInicio;
    private double costo;
    private String idPersonal;

    public Congreso(String idCongreso, String tituloCongreso, String descripcionCongreso, Date fechaInicio, Double costo, String idPersonal) {
        this.idCongreso = idCongreso;
        this.tituloCongreso = tituloCongreso;
        this.descripcionCongreso = descripcionCongreso;
        this.fechaInicio = fechaInicio;
        this.costo = costo;
        this.idPersonal = idPersonal;
    }

    public String getIdCongreso() {
        return idCongreso;
    }

    public void setIdCongreso(String idCongreso) {
        this.idCongreso = idCongreso;
    }

    public String getTituloCongreso() {
        return tituloCongreso;
    }

    public void setTituloCongreso(String tituloCongreso) {
        this.tituloCongreso = tituloCongreso;
    }

    public String getDescripcionCongreso() {
        return descripcionCongreso;
    }

    public void setDescripcionCongreso(String descripcionCongreso) {
        this.descripcionCongreso = descripcionCongreso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }
    
    public boolean esValido(){
        return costo > 35 && StringUtils.isNotBlank(idCongreso) && StringUtils.isNotBlank(tituloCongreso)
                && StringUtils.isNotBlank(descripcionCongreso) && fechaInicio != null;
    }
}
