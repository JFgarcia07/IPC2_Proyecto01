/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Propuestas;

import Exception.EntityNotFoundException;
import Model.Propuesta.RevisionPropuesta;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author jgarcia07
 */
public class RevisionPropuestaServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPropuesta = Integer.parseInt(request.getParameter("idPropuesta"));
        String valor = request.getParameter("valor");

        RevisionPropuesta revisador = new RevisionPropuesta();

        try {
            revisador.rechazarOaceptar(idPropuesta, valor);
            response.sendRedirect(request.getContextPath() + "/IrPropuestasPorConvocatorias");

        } catch (EntityNotFoundException ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("/Propuestas-pages/ListaPropuestas.jsp").forward(request, response);
        }
    }

}
