/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB.Usuario;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jgarcia07
 */
public class Usuario {
    private String idPersonal;
    private String idRol;
    private String email;
    private String password;
    private String nombreUsuario;
    private String organizacionProcedencia;
    private boolean activo;
    private String numTelefono;
    private double cartera;


    public Usuario() {
    }

    public Usuario(String idPersonal, String idRol, String email, String password, String nombreUsuario, String organizacionProcedencia, boolean activo, String numTelefono, double cartera) {
        this.idPersonal = idPersonal;
        this.idRol = idRol;
        this.email = email;
        this.password = password;
        this.nombreUsuario = nombreUsuario;
        this.organizacionProcedencia = organizacionProcedencia;
        this.activo = activo;
        this.numTelefono = numTelefono;
        this.cartera = cartera;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getOrganizacionProcedencia() {
        return organizacionProcedencia;
    }

    public void setOrganizacionProcedencia(String organizacionProcedencia) {
        this.organizacionProcedencia = organizacionProcedencia;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public double getCartera() {
        return cartera;
    }

    public void setCartera(double cartera) {
        this.cartera = cartera;
    }

    public boolean esValido(){
        return StringUtils.isNotBlank(idPersonal) && StringUtils.isNotBlank(idRol) && StringUtils.isNotBlank(email)
                && StringUtils.isNotBlank(nombreUsuario) && StringUtils.isNotBlank(organizacionProcedencia) &&
                StringUtils.isNotBlank(numTelefono);
    }
}
