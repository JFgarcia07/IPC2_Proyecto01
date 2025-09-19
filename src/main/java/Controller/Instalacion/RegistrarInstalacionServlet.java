/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Instalacion;

import BackEnd.DB.Instalacion.Instalacion;
import Exception.EntityAlreadyExistsException;
import Exception.EntityDataInvalidException;
import Model.Instalacion.RegistradorInstalaciones;
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
@WebServlet(name = "RegistrarInstalacionServlet", urlPatterns = {"/RegistrarInstalacionServlet"})
public class RegistrarInstalacionServlet extends HttpServlet {

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
        RegistradorInstalaciones registrador = new RegistradorInstalaciones();
        
        try {
            Instalacion instalacionNueva = registrador.registrarInstalacion(request);
            
            request.setAttribute("instalacionNueva", instalacionNueva);
            response.sendRedirect(request.getContextPath() + "/IrListadoInstalaciones");
            
        } catch (EntityDataInvalidException | EntityAlreadyExistsException e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Instalaciones-pages/CrearInstalacion.jsp");
            dispatcher.forward(request, response);
            
        }
    }

}
