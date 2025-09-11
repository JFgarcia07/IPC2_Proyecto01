/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BackEnd.DB.Usuario.Usuario;
import Exception.EntityAlreadyExistsException;
import Exception.UserDataInvalidException;
import Model.CreadorUsuario;
import jakarta.servlet.RequestDispatcher;
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
@WebServlet(name = "nuevoUsuario", urlPatterns = {"/nuevoUsuario"})
public class UsuarioServlet extends HttpServlet {

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
        CreadorUsuario creador = new CreadorUsuario();
        try {
            Usuario usuarioCreado = creador.crearUsuario(request);
            request.setAttribute("Usuario Creado", usuarioCreado);
        } catch (UserDataInvalidException | EntityAlreadyExistsException e) {
            request.setAttribute("error", e.getMessage());
        }
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/IrGestorUsuarios");
        dispatcher.forward(request, response);

    }
}
