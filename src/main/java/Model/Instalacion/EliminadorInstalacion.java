/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Instalacion;

import BackEnd.DB.Instalacion.InstalacionDB;
import Exception.EntityNotFoundException;

/**
 *
 * @author jgarcia07
 */
public class EliminadorInstalacion {
    
    public void eliminarInstalacion(String idInstalacion) throws EntityNotFoundException {
        InstalacionDB instalacionDB = new InstalacionDB();
       
        if (!instalacionDB.existeInstalacion(idInstalacion)) {
            throw new EntityNotFoundException(String.format("La instalacion con Id %s no existe", idInstalacion));
        }
        
        instalacionDB.eliminarInstalacion(idInstalacion);
    }
}
