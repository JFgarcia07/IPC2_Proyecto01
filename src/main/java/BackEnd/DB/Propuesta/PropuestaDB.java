/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB.Propuesta;

import BackEnd.DB.BDconnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jgarcia07
 */
public class PropuestaDB {
    
    private final String QUERY_PROPUESTAS_POR_ID_CONVOCATORIA = "SELECT * FROM propuesta WHERE id_convocatoria = ?";
    private final String QUERY_CREAR_PROPUESTA = "INSERT INTO propuesta (id_personal, titulo, tipo_propuesta, descripción, estado, id_convocatoria) VALUES (?,?,?,?,?,?)";
    private final String QUERY_BUSCAR_PROPUESTA_POR_ID = "SELECT COUNT(id_propuesta) FROM propuesta WHERE id_propuesta = ?";
    private final String QUERY_REVISAR_PROPUESTA = "UPDATE propuesta SET estado = ? WHERE id_propuesta = ?";
    
    
    private final Connection conn = BDconnectionSingleton.getInstance().getConnection();
    
    public List<Propuesta> listarPropuesta(int idConvocatoria){
        List<Propuesta> propuestasList = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_PROPUESTAS_POR_ID_CONVOCATORIA)){
            ps.setInt(1, idConvocatoria);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int idPropuesta = rs.getInt("id_propuesta");
                String idPersonal = rs.getString("id_personal");
                String titulo = rs.getString("titulo");
                String tipoPropuesta = rs.getString("tipo_propuesta");
                String descripcion = rs.getString("descripción");
                String estado = rs.getString("estado");
                
                Propuesta propuesta = new Propuesta(idPersonal, idConvocatoria, titulo, tipoPropuesta, descripcion, estado);
                propuesta.setIdPropuesta(idPropuesta);
                
                propuestasList.add(propuesta);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar las propuestas: " + e.getMessage());
            e.printStackTrace();
        }
        return propuestasList;
    }
    
    public void crearPropuesta(Propuesta propuesta){
        try (PreparedStatement ps = conn.prepareStatement(QUERY_CREAR_PROPUESTA)){
            ps.setString(1, propuesta.getIdPersonal());
            ps.setString(2, propuesta.getTitulo());
            ps.setString(3, propuesta.getTipoPropuesta());
            ps.setString(4, propuesta.getDescripcion());
            ps.setString(5, propuesta.getEstado());
            ps.setInt(6, propuesta.getIdConvocatoria());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al crear la propuestas: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public boolean existePropuesta(int idPropuesta){
        try (PreparedStatement ps = conn.prepareStatement(QUERY_BUSCAR_PROPUESTA_POR_ID)){
            ps.setInt(1, idPropuesta);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar propuesta: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    
    public void revisarPropuesta(int idPropuesta, String estado){
        try (PreparedStatement ps = conn.prepareStatement(QUERY_REVISAR_PROPUESTA)){
            ps.setString(1, estado);
            ps.setInt(2, idPropuesta);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al aceptar la propuesta: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
