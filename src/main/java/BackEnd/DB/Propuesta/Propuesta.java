/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB.Propuesta;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jgarcia07
 */
public class Propuesta {
    private int idPropuesta;
    private String idPersonal;
    private int idConvocatoria;
    private String titulo;
    private String tipoPropuesta;
    private String descripcion;
    private String estado;

    public Propuesta(String idPersonal, int idConvocatoria, String titulo, String tipoPropuesta, String descripcion, String estado) {
        this.idPersonal = idPersonal;
        this.idConvocatoria = idConvocatoria;
        this.titulo = titulo;
        this.tipoPropuesta = tipoPropuesta;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(int idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdConvocatoria() {
        return idConvocatoria;
    }

    public void setIdConvocatoria(int idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipoPropuesta() {
        return tipoPropuesta;
    }

    public void setTipoPropuesta(String tipoPropuesta) {
        this.tipoPropuesta = tipoPropuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean esValido() {
        
        if (!StringUtils.isNotBlank(idPersonal)) {
            return false;
        }
        if (!StringUtils.isNotBlank(titulo)) {
            return false;
        }
        if (!StringUtils.isNotBlank(tipoPropuesta)) {
            return false;
        }
        if (!StringUtils.isNotBlank(descripcion)) {
            return false;
        }

        if (idConvocatoria <= 0) {
            return false;
        }

        if (!StringUtils.isNotBlank(estado)) {
            return false;
        } else {

            switch (estado.toUpperCase()) {
                case "ACEPTADA":
                case "EN REVISION":
                case "RECHAZADO":
                    return true;
                default:
                    return false;
            }
        }

    }
}
