/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Instalacion;

import BackEnd.DB.Instalacion.Instalacion;
import BackEnd.DB.Instalacion.InstalacionDB;
import Exception.EntityAlreadyExistsException;
import Exception.EntityDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author jgarcia07
 */
public class RegistradorInstalaciones {
    
    public Instalacion registrarInstalacion(HttpServletRequest request) throws EntityDataInvalidException,
            EntityAlreadyExistsException {
        InstalacionDB instalacionDB = new InstalacionDB();
        
        Instalacion instalacion = extraer(request);
        
        if(instalacionDB.existeInstalacion(instalacion.getIdInstalacion())){
            throw new EntityAlreadyExistsException(String.format("La instalacion ya existe en el sistema", instalacion.getIdInstalacion()));
        }
        
        instalacionDB.ingresarIntalacion(instalacion);
        
        return instalacion;
    }
    
    private Instalacion extraer(HttpServletRequest request) throws EntityDataInvalidException {
        try {
            String idInstalacion = request.getParameter("inputIdInstalacion");
            String nombre = request.getParameter("inputNombre");
            String ubicacion = request.getParameter("inputUbicacion");
            
            Instalacion instalacion = new Instalacion(idInstalacion, nombre, ubicacion);
            
            if(!instalacion.esValido()){
                throw new EntityDataInvalidException("Error en los datos enviados, debe de llenar todos los datos");
            }
            
            return instalacion;
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new EntityDataInvalidException("Error en los datos enviados");
        }
    }
}
