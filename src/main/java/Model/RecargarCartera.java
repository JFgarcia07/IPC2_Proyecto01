/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import BackEnd.DB.Usuario.Usuario;
import BackEnd.DB.Usuario.UsuariosDB;
import Exception.EntityNotFoundException;
import Exception.UserDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author jgarcia07
 */
public class RecargarCartera {
    private final UsuariosDB userDB = new UsuariosDB();
    
    public Usuario recargarCartera(HttpServletRequest request) throws UserDataInvalidException, EntityNotFoundException {
        Usuario perfil = extraer(request);
        
        if(!userDB.existeUsuario(perfil.getIdPersonal())){
            throw new EntityNotFoundException(String.format("El usuario con Id Personal %s no existe", perfil.getIdPersonal()));
        }
        
        userDB.recargarCarteraDigital(perfil);

        return perfil;
    }
    
    private Usuario extraer(HttpServletRequest request) throws UserDataInvalidException {
        try {
            Usuario usuario = new Usuario();
            String idPersonal = request.getParameter("idPersonal");
            usuario.setIdPersonal(idPersonal);
            
            Double dineroRecargado = Double.parseDouble(request.getParameter("inputCartera")) + userDB.obtnerSaldoCartera(idPersonal);
            usuario.setCartera(dineroRecargado);

            if (dineroRecargado <= 0) {
                throw new UserDataInvalidException("No se puede recargar datos negativos");
            }

            return usuario;
            
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new UserDataInvalidException("Error en los datos enviados");
        }
    }
}
