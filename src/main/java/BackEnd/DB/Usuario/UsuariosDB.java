/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB.Usuario;

import BackEnd.DB.BDconnectionSingleton;
import static Model.EncriptarPassword.encriptar;
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
public class UsuariosDB {

    private final String QUERY_USUARIOS_TODOS = "SELECT * FROM usuario";
    private final String QUERY_BUSCAR_USUARIO_POR_ID = "SELECT COUNT(id_personal) FROM usuario WHERE id_personal = ?";
    private final String QUERY_ENCONTRAR_USUARIO_POR_ID = "SELECT * FROM usuario WHERE id_personal = ?";
    private final String QUERY_CREAR_USUARIO = "INSERT INTO usuario (id_personal, id_rol, email, nombre_usuario, password, oranizacion_procedencia, num_telefono, activo, cartera_digital) VALUES (?,?,?,?,?,?,?,?,?)";
    private final String QUERY_ID_ROL = "SELECT (id_rol) FROM rol WHERE nombre_rol = ?";
    private final String QUERY_EDITAR_USUARIO = "UPDATE usuario SET id_rol = ?, email = ?, password = ?, nombre_usuario = ?, oranizacion_procedencia = ?, num_telefono = ?, activo = ? WHERE id_personal = ?";
    private final String QUERY_DESACTIVAR_USUARIO = "UPDATE usuario SET activo = ? WHERE id_personal = ?";
    
    public List<Usuario> listaUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Connection conn = BDconnectionSingleton.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_USUARIOS_TODOS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idPersonal = rs.getString("id_personal");
                String idRol = rs.getString("id_rol");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String nombreUser = rs.getString("nombre_usuario");
                String orgProcedencia = rs.getString("oranizacion_procedencia");
                boolean estado = rs.getBoolean("activo");
                String numTelefono = rs.getString("num_telefono");
                double cartera = rs.getDouble("cartera_digital");

                Usuario user = new Usuario(idPersonal, idRol, email, password, nombreUser, orgProcedencia, estado, numTelefono, cartera);

                usuarios.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public boolean existeUsuario(String idPersonal) {
        Connection conn = BDconnectionSingleton.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_BUSCAR_USUARIO_POR_ID)) {
            ps.setString(1, idPersonal);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public String obtenerIdRol(String valorOpcion) {
        Connection conn = BDconnectionSingleton.getInstance().getConnection();
        String idRol = "";
        String nombreRol = "";

        switch (valorOpcion) {
            case "1":
                nombreRol = "ADMINISTRADOR SISTEMA";
                break;
            case "2":
                nombreRol = "ADMINISTRADOR CONGRESO";
                break;
            case "3":
                nombreRol = "USUARIO BASICO";
                break;
        }

        try (PreparedStatement ps = conn.prepareStatement(QUERY_ID_ROL)) {
            ps.setString(1, nombreRol);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idRol = rs.getString("id_rol");
            }
        } catch (SQLException e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return idRol;
    }

    public void crearUsuarioDB(Usuario usuario) {
        Connection conn = BDconnectionSingleton.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_CREAR_USUARIO)) {
            ps.setString(1, usuario.getIdPersonal());
            ps.setString(2, usuario.getIdRol());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getNombreUsuario());
            ps.setString(5, encriptar(usuario.getPassword()));
            ps.setString(6, usuario.getOrganizacionProcedencia());
            ps.setString(7, usuario.getNumTelefono());
            ps.setBoolean(8, usuario.isActivo());
            ps.setDouble(9, usuario.getCartera());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Optional<Usuario> obtenerUsuarioPorId(String idPersonal) {
        Connection conn = BDconnectionSingleton.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_ENCONTRAR_USUARIO_POR_ID)) {
            ps.setString(1, idPersonal);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario user = new Usuario();
                user.setIdPersonal(idPersonal);
                user.setIdRol(rs.getString("id_rol"));
                user.setEmail(rs.getString("email"));
                user.setNombreUsuario(rs.getString("nombre_usuario"));
                user.setOrganizacionProcedencia(rs.getString("oranizacion_procedencia"));
                user.setNumTelefono(rs.getString("num_telefono"));
                user.setActivo(rs.getBoolean("activo"));

                return Optional.of(user);
            }

        } catch (Exception e) {
            System.err.println("Error al obtener usuario: " + e.getMessage());
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public void editarUsuario(Usuario usuario) {
        Connection conn = BDconnectionSingleton.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_EDITAR_USUARIO)) {
            ps.setString(1, usuario.getIdRol());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getPassword());
            ps.setString(4, usuario.getNombreUsuario());
            ps.setString(5, usuario.getOrganizacionProcedencia());
            ps.setString(6, usuario.getNumTelefono());
            ps.setBoolean(7, usuario.isActivo());
            ps.setString(8, usuario.getIdPersonal());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al editar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void desactivarUsuario(Usuario usuario){
        Connection conn = BDconnectionSingleton.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(QUERY_DESACTIVAR_USUARIO)){
            ps.setBoolean(1, usuario.isActivo());
            ps.setString(2, usuario.getIdPersonal());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al desactivar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
