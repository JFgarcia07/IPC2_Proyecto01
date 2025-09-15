/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Propuestas;

import BackEnd.DB.Propuesta.Propuesta;
import BackEnd.DB.SesionGlobal;
import Exception.EntityAlreadyExistsException;
import Exception.EntityDataInvalidException;
import Model.Propuesta.CreadorPropuesta;
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
public class CrearPropuestaServlet extends HttpServlet {

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
        String idConvocatoria = request.getParameter("idConvocatoria");
        String idPersonal = SesionGlobal.idPersonal;
        
        request.setAttribute("idConvocatoria", idConvocatoria);
        request.setAttribute("idPersonal", idPersonal);
        
        request.getRequestDispatcher("/Propuestas-pages/CrearPropuesta.jsp").forward(request, response);
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
        CreadorPropuesta creador = new CreadorPropuesta();
        try {
            Propuesta propuestaCreada = creador.crearPropuesta(request);
            request.setAttribute("propuestaCreada", propuestaCreada);

            response.sendRedirect(request.getContextPath() + "/IrListadoConvocatorias");

        } catch (EntityDataInvalidException | EntityAlreadyExistsException e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Propuestas-pages/CrearPropuesta.jsp");
            dispatcher.forward(request, response);
        }
    }
}
