/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB.Congreso;

import BackEnd.DB.BDconnectionSingleton;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jgarcia07
 */
public class CongresoDB {
    private final Connection conn = BDconnectionSingleton.getInstance().getConnection();
    
    private final String QUERY_CONGRESOS_TODOS = "SELECT * FROM congreso";
    private final String QUERY_BUSCAR_CONGRESO_POR_ID = "SELECT COUNT(id_congreso) FROM congreso WHERE id_congreso = ?";
    private final String QUERY_CREAR_CONGRESO = "INSERT INTO congreso (id_congreso, titulo_congreso,descripcion_congreso, fechaInicio, costo, admin_congreso) VALUES (?,?,?,?,?,?)";
    private final String QUERY_ENCONTRAR_CONGRESO_POR_ID = "SELECT * FROM congreso WHERE id_congreso = ?";
    private final String QUERY_ENCONTRAR_CONGRESO_POR_ADMIN_CONGRESO = "SELECT * FROM congreso WHERE admin_congreso = ?";
    private final String QUERY_EDITAR_CONGRESO = "UPDATE congreso SET titulo_congreso = ?, descripcion_congreso = ?, fechaInicio = ?, costo = ? WHERE id_congreso = ?";
    
    public List<Congreso> listarCongresos(){
        List<Congreso> congresos = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_CONGRESOS_TODOS)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String idCongreso = rs.getString("id_congreso");
                String titulo = rs.getString("titulo_congreso");
                String descripcion = rs.getString("descripcion_congreso");
                Date fechaInicio = rs.getDate("fechaInicio");
                Double costo = rs.getDouble("costo");
                String idPersonal = rs.getString("admin_congreso");
                
                Congreso congreso = new Congreso(idCongreso, titulo, descripcion, fechaInicio, costo, idPersonal);
                congresos.add(congreso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return congresos;
    }
    
    public boolean existeCongreso(String idCongreso) {
        try (PreparedStatement ps = conn.prepareStatement(QUERY_BUSCAR_CONGRESO_POR_ID)) {
            ps.setString(1, idCongreso);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error al busacar el usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
   
    public void crearCongreso(Congreso congreso){
        try (PreparedStatement ps = conn.prepareStatement(QUERY_CREAR_CONGRESO)){
            ps.setString(1, congreso.getIdCongreso());
            ps.setString(2, congreso.getTituloCongreso());
            ps.setString(3, congreso.getDescripcionCongreso());
            ps.setDate(4, congreso.getFechaInicio());
            ps.setDouble(5, congreso.getCosto());
            ps.setString(6, congreso.getIdPersonal());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al crear congreso: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Optional<Congreso> obtenerCongresoPorId(String idCongreso){
        try (PreparedStatement ps = conn.prepareStatement(QUERY_ENCONTRAR_CONGRESO_POR_ID)){
            ps.setString(1, idCongreso);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Congreso congreso = new Congreso(idCongreso, rs.getString("titulo_congreso"),
                rs.getString("descripcion_congreso"), rs.getDate("fechaInicio"),
                rs.getDouble("costo"),
                rs.getString("admin_congreso"));
                return Optional.of(congreso);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el congreso: " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
    public List<Congreso> obtenerCongresoPorAdminCongreso(String idPersonal){
        List<Congreso> congresos = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_ENCONTRAR_CONGRESO_POR_ADMIN_CONGRESO)){
            ps.setString(1, idPersonal);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Congreso congreso = new Congreso(rs.getString("id_congreso"), rs.getString("titulo_congreso"),
                rs.getString("descripcion_congreso"), rs.getDate("fechaInicio"),
                rs.getDouble("costo"),
                idPersonal);
                
                congresos.add(congreso);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el congreso: " + e.getMessage());
            e.printStackTrace();
        }
        return congresos;
    }
    
    public void editarCongreso(Congreso congreso){
        try (PreparedStatement ps = conn.prepareStatement(QUERY_EDITAR_CONGRESO)){
            ps.setString(1, congreso.getIdCongreso());
            ps.setString(2, congreso.getDescripcionCongreso());
            ps.setDate(3, congreso.getFechaInicio());
            ps.setDouble(4, congreso.getCosto());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al editar congreso: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
