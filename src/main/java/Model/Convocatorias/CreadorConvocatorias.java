/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Convocatorias;

import BackEnd.DB.Convocatoria.Convocatoria;
import BackEnd.DB.Convocatoria.ConvocatoriaDB;
import Exception.EntityAlreadyExistsException;
import Exception.EntityDataInvalidException;
import Exception.UnauthorizedCallCreationException;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author jgarcia07
 */
public class CreadorConvocatorias {
    
    private final ConvocatoriaDB convocatoriaDB = new ConvocatoriaDB();
    
    public Convocatoria crearConvocatoria(HttpServletRequest request) throws EntityDataInvalidException,
            EntityAlreadyExistsException, UnauthorizedCallCreationException {

        Convocatoria convocatoria = extraer(request);

        if (convocatoriaDB.existeConvocatoria(convocatoria.getIdConvocatoria())) {
            throw new EntityAlreadyExistsException(String.format("La convocatoria ya existe en el sistema", convocatoria.getIdConvocatoria()));
        }

        convocatoriaDB.crearConvocatoriaBD(convocatoria);

        return convocatoria;
    }

    private Convocatoria extraer(HttpServletRequest request) throws EntityDataInvalidException,
            UnauthorizedCallCreationException {
        try {
            String idPersonal = request.getParameter("inputIdPersonal");
            Date fechaInicio = transformarAdate(request.getParameter("fechaInicio"));
            Date fechaFinal = transformarAdate(request.getParameter("fechaFinal"));
            String titulo = request.getParameter("inputTitulo");
            String descripcion = request.getParameter("descripcion");
            boolean estado = getBoolean(request.getParameter("inputEstado"));
            String idCongreso = request.getParameter("inputIdCongreso");
            
            Convocatoria convocatoria = new Convocatoria(idPersonal, fechaInicio, fechaFinal, titulo, descripcion, estado, idCongreso);
            
            if (!convocatoria.esValido()) {
                throw new EntityDataInvalidException("Error en los datos enviados, debe de llenar todos los datos");
            }
            
            if(!validarDate(fechaInicio, fechaFinal)){
                throw new EntityDataInvalidException("La fecha de finalización debe ser posterior a la fecha de inicio.");
            }
            
            if(!validarIdCongreso(convocatoria.getIdPersonal(), convocatoria.getIdCongreso())){
                throw new UnauthorizedCallCreationException("No puede crear una convocatoria para un congreso donde no es el administrador");
            }
            
            return convocatoria;
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new EntityDataInvalidException("Error en los datos enviados");
        }
    }
    
    private Date transformarAdate(String fechaString){
        if (fechaString == null || fechaString.isEmpty()) {
            System.err.println("fechaString es null o vacía");
            return null; 
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = dateFormat.parse(fechaString);
            return new java.sql.Date(utilDate.getTime());
        } catch (Exception e) {
            System.err.println("Error al convertir la fecha: " + fechaString);
            e.printStackTrace();
            return null;
        }
    }
    
    private boolean validarIdCongreso(String idPersonal, String idCongreso){
        List<String> idCongresoSQL = convocatoriaDB.obtenerCongresoPorIdPersonal(idPersonal);
        for (String id : idCongresoSQL) {
            if(id.equals(idCongreso)){
                return true;
            }
        }
        return false;
    }
    
    private boolean validarDate(Date fechaInicio, Date fechaFin){
        return fechaFin.after(fechaInicio);
    }
    
    private boolean getBoolean(String estadoStr){
        return estadoStr.equalsIgnoreCase("ACTIVA") || estadoStr.equalsIgnoreCase("ACTIVO");
    }
}
