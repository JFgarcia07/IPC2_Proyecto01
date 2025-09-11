/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import BackEnd.DB.Usuario.Usuario;
import BackEnd.DB.UsuariosDB;
import Exception.UserDataInvalidException;

/**
 *
 * @author jgarcia07
 */
public class DesactivarUsuario {
    
    private final UsuariosDB userDB = new UsuariosDB();
    
    public Usuario desactivarUsuario(String idPersonal) throws UserDataInvalidException{
        Usuario usuarioDesactivado = extraer(idPersonal);
        
        if(!userDB.existeUsuario(usuarioDesactivado.getIdPersonal())){
            throw new UserDataInvalidException(String.format("El usuario con Id Personal %s no existe", usuarioDesactivado.getIdPersonal()));
        }
        
        userDB.desactivarUsuario(usuarioDesactivado);
        return usuarioDesactivado;
    }
    
    private Usuario extraer(String idPersonal) throws UserDataInvalidException{
        try {
            Usuario user = new Usuario();
            user.setIdPersonal(idPersonal);
            user.setActivo(false);
            return user;
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new UserDataInvalidException("Error en los datos enviados");
        }
    }
}
