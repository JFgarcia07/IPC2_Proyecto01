/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import BackEnd.DB.Usuario.Usuario;
import BackEnd.DB.UsuariosDB;
import Exception.EntityAlreadyExistsException;
import Exception.UserDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author jgarcia07
 */
public class CreadorUsuario {
    
    private UsuariosDB userDB = new UsuariosDB();
    
    public Usuario crearUsuario(HttpServletRequest request) throws UserDataInvalidException,
        EntityAlreadyExistsException {

        Usuario usuario = extraer(request);
        
        if(userDB.existeUsuario(usuario.getIdPersonal())){
            System.out.println("EXISTE");
            throw new EntityAlreadyExistsException(String.format("El usuario ya existe en el registro", usuario.getIdPersonal()));
        }
        
        userDB.crearUsuarioDB(usuario);
        
        return usuario;
    }
    
    
    private Usuario extraer(HttpServletRequest request) throws UserDataInvalidException {
        try {
            String idPersonal = request.getParameter("inputIdPersonal");
            String idRol = userDB.obtenerIdRol(request.getParameter("opcionesRol"));
            String email = request.getParameter("inputEmail");
            String nombreUsuario = request.getParameter("inputNombreUsuario");
            String password = request.getParameter("inputPassword");
            String organizacion = request.getParameter("inputOrganizacion");
            String numTelefono = request.getParameter("inputNumTelefono");
            boolean activo = obtenerEstado(request.getParameter("inputActivo"));
            double cartera = 0;
            
            Usuario usuario = new Usuario(idPersonal,idRol,email,password,nombreUsuario,organizacion,activo, numTelefono, cartera);
            
            return usuario;
            
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new UserDataInvalidException("Error en los datos enviados");
        }
    }
    
    private boolean obtenerEstado(String activoString){
        return activoString.equalsIgnoreCase("Activo");
    }
}
