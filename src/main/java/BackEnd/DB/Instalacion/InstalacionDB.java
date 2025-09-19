/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB.Instalacion;

import BackEnd.DB.BDconnectionSingleton;
import java.sql.Connection;
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
public class InstalacionDB {
    private final Connection conn = BDconnectionSingleton.getInstance().getConnection();
    
    private final String QUERY_LISTAR_INSTALACIONES_TODAS = "SELECT * FROM instalacion";
    private final String QUERY_BUSCAR_INSTALACION_POR_ID = "SELECT id_instalacion FROM instalacion WHERE id_instalacion = ?";
    private final String QUERY_INGRESAR_INSTALACION = "INSERT INTO instalacion (id_instalacion, nombre_instalacion, ubicacion) VALUES (?,?,?)";
    private final String QUERY_ENCONTRAR_INSTALACION_POR_ID = "SELECT * FROM instalacion WHERE id_instalacion = ?";
    private final String QUERY_EDITAR_INSTALACION = "UPDATE instalacion SET nombre_instalacion = ?, ubicacion = ? WHERE id_instalacion = ?";
    private final String QUERY_ELIMINAR_INSTALACION = "DELETE FROM instalacion WHERE id_instalacion = ?";
    
    public List<Instalacion> listaInstalaciones(){
        List<Instalacion> instalaciones = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_LISTAR_INSTALACIONES_TODAS)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString("id_instalacion");
                String nombre = rs.getString("nombre_instalacion");
                String ubicacion = rs.getString("ubicacion");
                
                Instalacion instalacion = new Instalacion(id, nombre, ubicacion);
                instalaciones.add(instalacion);
            }
        } catch (SQLException e) {
            System.err.println("Erro al listar las instalaciones");
            e.printStackTrace();
        }
        return instalaciones;
    }
    
    public boolean existeInstalacion(String idIntalacion){
        try (PreparedStatement ps = conn.prepareStatement(QUERY_BUSCAR_INSTALACION_POR_ID)){
            ps.setString(1, idIntalacion);
            ResultSet rs = ps.executeQuery();
            
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error al buscar la instalacion: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    public void ingresarIntalacion(Instalacion instalacion){
        try (PreparedStatement ps = conn.prepareStatement(QUERY_INGRESAR_INSTALACION)){
            ps.setString(1, instalacion.getIdInstalacion());
            ps.setString(2, instalacion.getNombreInstalacion());
            ps.setString(3, instalacion.getUbicacion());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al ingresar la instalacion: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Optional<Instalacion> obtenerInstalacionPorId(String idInstalacion){
        try (PreparedStatement ps = conn.prepareStatement(QUERY_ENCONTRAR_INSTALACION_POR_ID)){
            ps.setString(1, idInstalacion);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String id = rs.getString("id_instalacion");
                String nombre = rs.getString("nombre_instalacion");
                String ubicacion = rs.getString("ubicacion");
                
                Instalacion instalacion = new Instalacion(id, nombre, ubicacion);
                return Optional.of(instalacion);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la instalacion: " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
    public void editarInstalacion(Instalacion instalacion){
        try (PreparedStatement ps = conn.prepareStatement(QUERY_EDITAR_INSTALACION)){
            ps.setString(1, instalacion.getNombreInstalacion());
            ps.setString(2, instalacion.getUbicacion());
            ps.setString(3, instalacion.getIdInstalacion());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al editar la instalacion: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void eliminarInstalacion(String idInstalacion){
        try (PreparedStatement ps = conn.prepareStatement(QUERY_ELIMINAR_INSTALACION)){
            ps.setString(1, idInstalacion);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al borrar la instalacion: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
