/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Congreso;

import BackEnd.DB.Congreso.Congreso;
import BackEnd.DB.Congreso.CongresoDB;
import Exception.EntityAlreadyExistsException;
import Exception.EntityDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author jgarcia07
 */
public class CreadorCongreso {
    
    public Congreso crearCongreso(HttpServletRequest request) throws EntityDataInvalidException,
            EntityAlreadyExistsException {
        CongresoDB congresoDB = new CongresoDB();
        Congreso congreso = extraer(request);
        
        if(congresoDB.existeCongreso(congreso.getIdCongreso())){
            throw new EntityAlreadyExistsException(String.format("El congreso ya existe en el sistema", congreso.getIdCongreso()));
        }
        
        congresoDB.crearCongreso(congreso);
        
        return congreso;
    }
    
    private Congreso extraer(HttpServletRequest request) throws EntityDataInvalidException {
        try {
            String idPersonal = request.getParameter("inputIdPersonal");
            String idCongreso = request.getParameter("inputIdCongreso");
            String titulo = request.getParameter("inputTitulo");
            String descripcion = request.getParameter("descripcion");
            Date fechaInicio = transformarAdate(request.getParameter("fechaInicio"));
            double costo = Double.parseDouble(request.getParameter("inputCosto"));
            
            Congreso congreso = new Congreso(idCongreso, titulo, descripcion, fechaInicio, costo, idPersonal);
            
            if(!congreso.esValido()){
                throw new EntityDataInvalidException("Error al enviar los datos");
            }
            
            return congreso;
            
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
}
