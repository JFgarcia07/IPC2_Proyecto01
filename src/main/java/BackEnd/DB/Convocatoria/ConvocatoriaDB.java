/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB.Convocatoria;

import BackEnd.DB.BDconnectionSingleton;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jgarcia07
 */
public class ConvocatoriaDB {
    
    private final String QUERY_CONVOCATORIAS_TODAS = "SELECT * FROM convocatoria WHERE estado = 1";
    private final String QUERY_CREAR_CONVOCATORIA = "INSERT INTO convocatoria (id_personal, fecha_inicio, fecha_limite, titulo, descripcion, estado) VALUES (?,?,?,?,?,?)";
    private final String QUERY_BUSCAR_CONVOCATORIA_POR_ID = "SELECT COUNT(id_convocatoria) FROM convocatoria WHERE id_convocatoria = ?";
    private final String QUERY_DESACTIVAR_CONVOCATORIA = "UPDATE convocatoria SET estado = 0 WHERE id_convocatoria = ?";
    
    public List<Convocatoria> listarConvocatoria(){
        List<Convocatoria> convocatoriasList = new ArrayList<>();
        Connection conn = BDconnectionSingleton.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_CONVOCATORIAS_TODAS)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String idConvocatoria = rs.getString("id_convocatoria");
                String idPersonal = rs.getString("id_personal");
                Date fechaInicio = rs.getDate("fecha_inicio");
                Date fechaFin = rs.getDate("fecha_limite");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                boolean estado = rs.getBoolean("estado");
                
                Convocatoria convocatoria = new Convocatoria(idPersonal, fechaInicio, fechaFin, titulo, descripcion,estado);
                convocatoria.setIdConvocatoria(idConvocatoria);
                convocatoriasList.add(convocatoria);
            }
        } catch (SQLException e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return convocatoriasList;
    }
    
    public void crearConvocatoriaBD(Convocatoria convocatoria){
        Connection conn = BDconnectionSingleton.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_CREAR_CONVOCATORIA)){
            ps.setString(1, convocatoria.getIdPersonal());
            ps.setDate(2, convocatoria.getFechaInicio());
            ps.setDate(3, convocatoria.getFechaFin());
            ps.setString(4, convocatoria.getTitulo());
            ps.setString(5, convocatoria.getDescripcion());
            ps.setBoolean(6, convocatoria.isEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al crear convocatoria: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public boolean existeConvocatoria(String idConvocatoria){
        Connection conn = BDconnectionSingleton.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_BUSCAR_CONVOCATORIA_POR_ID)){
            ps.setString(1, idConvocatoria);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar convocatoria: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    public void desactivarConvocatoria(int idConvocatoria){
        Connection conn = BDconnectionSingleton.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_DESACTIVAR_CONVOCATORIA)){
            ps.setInt(1, idConvocatoria);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al desactivar la convocatoria: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

