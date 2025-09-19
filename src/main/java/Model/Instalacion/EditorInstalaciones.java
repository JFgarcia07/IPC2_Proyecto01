/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Instalacion;

import BackEnd.DB.Instalacion.Instalacion;
import BackEnd.DB.Instalacion.InstalacionDB;
import Exception.EntityDataInvalidException;
import Exception.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author jgarcia07
 */
public class EditorInstalaciones {
    
    private final InstalacionDB instalacionDB = new InstalacionDB();
    
    public Instalacion editarInstalacion(HttpServletRequest request) throws EntityDataInvalidException,
            EntityNotFoundException {
        
        Instalacion instalacion = extraer(request);
        
        if(!instalacionDB.existeInstalacion(instalacion.getIdInstalacion())){
             throw new EntityNotFoundException(String.format("La instalacion con Id %s no existe", instalacion.getIdInstalacion()));
        }
        
        instalacionDB.editarInstalacion(instalacion);
        
        return instalacion;
    }
    
    private Instalacion extraer(HttpServletRequest request) throws EntityDataInvalidException {
        try {
            String idInstalacion = request.getParameter("inputIdInstalacion");
            String nombre = request.getParameter("inputNombre");
            String ubicacion = request.getParameter("inputUbicacion");

            Instalacion instalacion = new Instalacion(idInstalacion, nombre, ubicacion);

            if (!instalacion.esValido()) {
                throw new EntityDataInvalidException("Error en los datos enviados, debe de llenar todos los datos");
            }

            return instalacion;
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new EntityDataInvalidException("Error en los datos enviados");
        }
    }
    
    public Instalacion obtenerDatosInstalacion(String idInstalacion){
        return instalacionDB.obtenerInstalacionPorId(idInstalacion).get();
    }
}
