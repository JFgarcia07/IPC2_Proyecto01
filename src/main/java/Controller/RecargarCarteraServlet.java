/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BackEnd.DB.Usuario.Usuario;
import Exception.EntityNotFoundException;
import Exception.UserDataInvalidException;
import Model.PerfilUsuario;
import Model.RecargarCartera;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author jgarcia07
 */
public class RecargarCarteraServlet extends HttpServlet {
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
        PerfilUsuario perfilUsuario = new PerfilUsuario();
       
        Usuario perfil = perfilUsuario.llenarDatosPerfil();
        request.setAttribute("perfil", perfil);
        request.getRequestDispatcher("/Usuarios-pages/RecargarCartera.jsp").forward(request, response);
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
        RecargarCartera recargador = new RecargarCartera();
        try {
            Usuario perfilRecargado = recargador.recargarCartera(request);
            request.setAttribute("perfil", perfilRecargado);
        } catch (UserDataInvalidException | EntityNotFoundException e) {
            request.setAttribute("error", e.getMessage());
        }
        
        response.sendRedirect(request.getContextPath() + "/IrPerfilServlet");
    }

}
