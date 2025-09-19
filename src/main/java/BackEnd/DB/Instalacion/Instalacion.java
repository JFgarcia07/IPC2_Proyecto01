/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB.Instalacion;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jgarcia07
 */
public class Instalacion {
    private String idInstalacion;
    private String nombreInstalacion;
    private String ubicacion;

    public Instalacion(String idInstalacion, String nombreInstalacion, String ubicacion) {
        this.idInstalacion = idInstalacion;
        this.nombreInstalacion = nombreInstalacion;
        this.ubicacion = ubicacion;
    }

    public String getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(String idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getNombreInstalacion() {
        return nombreInstalacion;
    }

    public void setNombreInstalacion(String nombreInstalacion) {
        this.nombreInstalacion = nombreInstalacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public boolean esValido(){
        return StringUtils.isNotBlank(idInstalacion) && StringUtils.isNotBlank(nombreInstalacion) && StringUtils.isNotBlank(ubicacion);
    }
}
