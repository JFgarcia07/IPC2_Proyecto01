/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Propuesta;

import BackEnd.DB.Convocatoria.ConvocatoriaDB;
import BackEnd.DB.Propuesta.Propuesta;
import BackEnd.DB.Propuesta.PropuestaDB;
import Exception.EntityAlreadyExistsException;
import Exception.EntityDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author jgarcia07
 */
public class CreadorPropuesta {
    private final PropuestaDB propuestaDB = new PropuestaDB();
    private final ConvocatoriaDB convocatoriaBD = new ConvocatoriaDB();
    
    public Propuesta crearPropuesta(HttpServletRequest request) throws EntityDataInvalidException,
        EntityAlreadyExistsException {
        Propuesta propuesta = extraer(request);
        
        if(propuestaDB.existePropuesta(propuesta.getIdPropuesta())){
            throw new EntityAlreadyExistsException("La propuesta ya existe");
        }
        
        propuestaDB.crearPropuesta(propuesta);
        
        return propuesta;
    }
    
    private Propuesta extraer(HttpServletRequest request) throws EntityDataInvalidException {
        try {
            int idConvocatoria = Integer.parseInt(request.getParameter("inputIdConvocatoria"));
            String idPersonal = request.getParameter("inputIdPersonal");
            String titulo = request.getParameter("inputTitulo");
            String descripcion = request.getParameter("descripcion");
            String tipoPropuesta = obtenerTipoPropuesta(request.getParameter("opcionesPropuesta"));
            String estado = request.getParameter("inputEstado");
            
            Propuesta propuesta = new Propuesta(idPersonal, idConvocatoria, titulo, tipoPropuesta, descripcion, estado);
            
            if(!propuesta.esValido()){
                throw new EntityDataInvalidException("Los datos no son validos");
            }
            
            return propuesta;
            
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new EntityDataInvalidException("Error en los datos enviados");
        }
    }
    
    public boolean validarFechaInicio(String idCongreso){
        LocalDate fechaActual = LocalDate.now();
        Date fechaHoy = Date.valueOf(fechaActual);
        
        Date fechaSQL = convocatoriaBD.obtenerFechaIncio(idCongreso);
        
        return fechaHoy.before(fechaSQL);
    }
    
    private String obtenerTipoPropuesta(String valor){
        if(valor.equalsIgnoreCase("1")){
            return "PONENCIA";
        } else {
            return "TALLER";
        }
    }
    
}
