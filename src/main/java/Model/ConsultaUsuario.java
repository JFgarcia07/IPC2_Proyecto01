/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import BackEnd.DB.Usuario.Usuario;
import BackEnd.DB.Usuario.UsuariosDB;
import Exception.EntityNotFoundException;
import java.util.Optional;

/**
 *
 * @author jgarcia07
 */
public class ConsultaUsuario {
    
    public Usuario obtenerUsuarioPorId(String idPersonal) throws EntityNotFoundException {
        UsuariosDB userDB = new UsuariosDB();
        Optional<Usuario> usuarioOpt = userDB.obtenerUsuarioPorId(idPersonal);
        
        if(usuarioOpt.isEmpty()){
            throw new EntityNotFoundException(String.format("El usuario no existe", idPersonal));
        }
        
        return usuarioOpt.get();
    }
}
