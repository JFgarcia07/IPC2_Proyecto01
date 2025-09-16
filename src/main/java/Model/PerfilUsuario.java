/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import BackEnd.DB.SesionGlobal;
import BackEnd.DB.Usuario.Usuario;
import BackEnd.DB.Usuario.UsuariosDB;
import Exception.EntityNotFoundException;
import Exception.UserDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author jgarcia07
 */
public class PerfilUsuario {
    
    
    public Usuario llenarDatosPerfil(){
        String idPersonal = SesionGlobal.idPersonal;
        UsuariosDB userDB = new UsuariosDB();
        Usuario perfil = userDB.obtenerUsuarioPorId(idPersonal).get();
        return perfil;
    }
    
    public Usuario editarPerfil(HttpServletRequest request) throws UserDataInvalidException, EntityNotFoundException{
        UsuariosDB userDB = new UsuariosDB();
        Usuario perfilActualizado = extraer(request);
        
        if(!userDB.existeUsuario(perfilActualizado.getIdPersonal())){
            throw new EntityNotFoundException(String.format("El usuario con Id Personal %s no existe", perfilActualizado.getIdPersonal()));
        }
        
        userDB.editarPerfil(perfilActualizado);
        
        return perfilActualizado;
    }
    
    
    private Usuario extraer(HttpServletRequest request) throws UserDataInvalidException {
        try {
            Usuario perfil = new Usuario();
            String idPersonal = request.getParameter("idPersonal");
            String email = request.getParameter("inputEmail");
            String nombreUsuario = request.getParameter("inputNombreUsuario");
            String password = request.getParameter("inputPassword");
            String organizacion = request.getParameter("inputOrganizacion");
            String numTelefono = request.getParameter("inputNumTelefono");

            perfil.setIdPersonal(idPersonal);
            perfil.setEmail(email);
            perfil.setNombreUsuario(nombreUsuario);
            perfil.setPassword(password);
            perfil.setOrganizacionProcedencia(organizacion);
            perfil.setNumTelefono(numTelefono);

            if (!perfil.perfilValido()) {
                throw new UserDataInvalidException("Error en los datos enviados");
            }
            
            return perfil;
            
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new UserDataInvalidException("Error en los datos enviados");
        }
    }

}
