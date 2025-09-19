/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Instalacion;

import BackEnd.DB.Instalacion.Instalacion;
import BackEnd.DB.Instalacion.InstalacionDB;
import java.util.List;

/**
 *
 * @author jgarcia07
 */
public class ListadorInstalaciones {
    
    public List<Instalacion> listadorInstalaciones(){
        InstalacionDB instalacionDB = new InstalacionDB();
        List<Instalacion> instalaciones = instalacionDB.listaInstalaciones();
        
        return instalaciones;
    }
}
