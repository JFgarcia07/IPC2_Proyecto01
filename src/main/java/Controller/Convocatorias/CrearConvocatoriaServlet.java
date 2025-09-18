/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Convocatorias;

import BackEnd.DB.Convocatoria.Convocatoria;
import Exception.EntityAlreadyExistsException;
import Exception.EntityDataInvalidException;
import Exception.UnauthorizedCallCreationException;
import Model.Convocatorias.CreadorConvocatorias;
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
@WebServlet(name = "CrearConvocatoriaServlet", urlPatterns = {"/CrearConvocatoriaServlet"})
public class CrearConvocatoriaServlet extends HttpServlet {

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
        CreadorConvocatorias creador = new CreadorConvocatorias();
        try {
            Convocatoria convocatoriaCreada = creador.crearConvocatoria(request);
            request.setAttribute("convocatoriaCreada", convocatoriaCreada); 

            RequestDispatcher dispatcher = request.getRequestDispatcher("/MenuPrincipal.jsp");
            dispatcher.forward(request, response);

        } catch (EntityDataInvalidException | EntityAlreadyExistsException | UnauthorizedCallCreationException e) {
            if (e.getMessage() != null && !e.getMessage().isBlank()) {
                request.setAttribute("error", e.getMessage());
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/Convocatorias-pages/CrearConvocatoria.jsp");
            dispatcher.forward(request, response);
        }
    }

}
