/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BackEnd.DB.Usuario.Usuario;
import Exception.EntityNotFoundException;
import Exception.UserDataInvalidException;
import Model.ConsultaUsuario;
import Model.EditarUsuario;
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
@WebServlet(name = "EditarUsuarioServlet", urlPatterns = {"/EditarUsuarioServlet"})
public class EditarUsuarioServlet extends HttpServlet {


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

        ConsultaUsuario consultaUser = new ConsultaUsuario();
        String idUsuario = request.getParameter("id");
        
        try {
            Usuario usuario = consultaUser.obtenerUsuarioPorId(idUsuario);
            
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("/EditarUsuario.jsp").forward(request, response);
            
        } catch (EntityNotFoundException ex) {
            request.setAttribute("error", ex.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EditarUsuario editor = new EditarUsuario();
        try {
            Usuario usuarioActulizado = editor.actualizarUsuario(request);
            request.setAttribute("usuario", usuarioActulizado);

        } catch (UserDataInvalidException | EntityNotFoundException e) {
            request.setAttribute("error", e.getMessage());
        }
        
        response.sendRedirect(request.getContextPath() + "/IrGestorUsuarios");
    }
    
}
