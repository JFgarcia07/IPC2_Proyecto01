/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import BackEnd.DB.Usuario.Usuario;
import BackEnd.DB.UsuariosDB;
import Exception.EntityNotFoundException;
import Exception.UserDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author jgarcia07
 */
public class EditarUsuario {
    
    private final UsuariosDB userDB = new UsuariosDB();
    
    public Usuario actualizarUsuario(HttpServletRequest request) throws UserDataInvalidException,
            EntityNotFoundException {
        
        Usuario usuarioActualizado = extraer(request);
        
        if(!userDB.existeUsuario(usuarioActualizado.getIdPersonal())){
            throw new EntityNotFoundException(String.format("El usuario con Id Personal %s no existe", usuarioActualizado.getIdPersonal()));
        }
        
        userDB.editarUsuario(usuarioActualizado);
        
        return usuarioActualizado;
    }
    
    
    private Usuario extraer(HttpServletRequest request) throws UserDataInvalidException{
        try {
            Usuario usuario = new Usuario();
            String idPersonal = request.getParameter("idPersonal");
            String idRol = userDB.obtenerIdRol(request.getParameter("opcionesRol"));
            String email = request.getParameter("inputEmail");
            String nombreUsuario = request.getParameter("inputNombreUsuario");
            String password = request.getParameter("inputPassword");
            String organizacion = request.getParameter("inputOrganizacion");
            String numTelefono = request.getParameter("inputNumTelefono");
            boolean estado = obtenerEstado(request.getParameter("opcionesActivo"));
            
            usuario.setIdPersonal(idPersonal);
            usuario.setIdRol(idRol);
            usuario.setEmail(email);
            usuario.setNombreUsuario(nombreUsuario);
            usuario.setPassword(password);
            usuario.setOrganizacionProcedencia(organizacion);
            usuario.setNumTelefono(numTelefono);
            usuario.setActivo(estado);
            
            return usuario;
            
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new UserDataInvalidException("Error en los datos enviados");
        }
    }
    
    private boolean obtenerEstado(String valor){
        return valor.equals("1");
    }
}
