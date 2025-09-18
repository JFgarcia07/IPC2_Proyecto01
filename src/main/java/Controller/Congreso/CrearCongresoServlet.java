/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Congreso;

import BackEnd.DB.Congreso.Congreso;
import BackEnd.DB.SesionGlobal;
import Exception.EntityAlreadyExistsException;
import Exception.EntityDataInvalidException;
import Model.Congreso.CreadorCongreso;
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
public class CrearCongresoServlet extends HttpServlet {
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
        String idPersonal = SesionGlobal.idPersonal;
        
        request.setAttribute("idPersonal", idPersonal);
        request.getRequestDispatcher("/Congresos-pages/CrearCongreso.jsp").forward(request, response);
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
        
        CreadorCongreso creador = new CreadorCongreso();
        try {
            Congreso congresoCreado = creador.crearCongreso(request);
            request.setAttribute("congresoCreado", congresoCreado);
            
            response.sendRedirect(request.getContextPath() + "/IrListadoCongresos");
            
        } catch (EntityDataInvalidException | EntityAlreadyExistsException e) {
            if (e.getMessage() != null && !e.getMessage().isBlank()) {
                request.setAttribute("error", e.getMessage());
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Congresos-pages/CrearCongreso.jsp");
            dispatcher.forward(request, response);
        }
    }

}
