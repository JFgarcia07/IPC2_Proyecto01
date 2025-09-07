/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import BackEnd.DB.LogInDB;
import BackEnd.DB.Usuario.Usuario;
import Exception.UserDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author jgarcia07
 */
public class ValidarLogIn {
    private Usuario extraerDatos(HttpServletRequest request) throws UserDataInvalidException {
        try {
            String email = request.getParameter("inputEmail");
            String password = request.getParameter("inputPassword");

            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setPassword(password);

            return usuario;
            
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new UserDataInvalidException("Error en los datos enviados");
        }
    }
    
    public boolean validarCredenciales(HttpServletRequest request) throws UserDataInvalidException {
        LogInDB logIn = new LogInDB();
        Usuario usuario = extraerDatos(request);
        
        return logIn.validarLogIn(usuario);
    }
}
