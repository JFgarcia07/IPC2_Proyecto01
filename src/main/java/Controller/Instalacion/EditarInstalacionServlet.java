/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Instalacion;

import BackEnd.DB.Instalacion.Instalacion;
import Exception.EntityDataInvalidException;
import Exception.EntityNotFoundException;
import Model.Instalacion.EditorInstalaciones;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author jgarcia07
 */
public class EditarInstalacionServlet extends HttpServlet {
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
        EditorInstalaciones editor = new EditorInstalaciones();
        
        String idInstalacion = request.getParameter("idInstalacion");
        request.setAttribute("idInstalacion", idInstalacion);
        
        Instalacion instalacion = editor.obtenerDatosInstalacion(idInstalacion);
        
        request.setAttribute("instalacion", instalacion);
        request.getRequestDispatcher("/Instalaciones-pages/EditarInstalacion.jsp").forward(request, response);
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
        EditorInstalaciones editor = new EditorInstalaciones();
        try {
            Instalacion instalacion = editor.editarInstalacion(request);
            request.setAttribute("instalacion", instalacion);
            
            response.sendRedirect(request.getContextPath() + "/IrListadoInstalaciones");
        } catch (EntityDataInvalidException | EntityNotFoundException e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Instalaciones-pages/EditarInstalacion.jsp");
            dispatcher.forward(request, response);
        }
    }

}
