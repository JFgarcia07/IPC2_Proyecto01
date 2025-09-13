/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB.Convocatoria;

import java.sql.Date;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jgarcia07
 */
public class Convocatoria {
    private String idConvocatoria;
    private String idPersonal;
    private Date fechaInicio;
    private Date fechaFin;
    private String titulo;
    private String descripcion;
    private boolean estado;

    public Convocatoria(String idPersonal, Date fechaInicio, Date fechaFin, String titulo, String descripcion, boolean estado) {
        this.idPersonal = idPersonal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getIdConvocatoria() {
        return idConvocatoria;
    }

    public void setIdConvocatoria(String idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public boolean esValido(){
        return StringUtils.isNotBlank(idPersonal) && 
               StringUtils.isNotBlank(titulo) && StringUtils.isNotBlank(descripcion);
    }
    
}
