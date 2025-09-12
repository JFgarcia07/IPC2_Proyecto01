/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BackEnd.DB.Usuario.Usuario;
import Exception.UserDataInvalidException;
import Model.DesactivarUsuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author jgarcia07
 */
@WebServlet(name = "DesactivarUsuarioServlet", urlPatterns = {"/DesactivarUsuarioServlet"})
public class DesactivarUsuarioServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            DesactivarUsuario desactivador = new DesactivarUsuario();
            String idPersonal = request.getParameter("id");
            
            Usuario usuario = desactivador.desactivarUsuario(idPersonal);
            request.setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath() + "/Usuarios-pages/IrGestorUsuarios");
        } catch (UserDataInvalidException ex) {
            request.setAttribute("error", ex.getMessage());
        }
    }

}
